package cn.chiucheung.controller.system;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import cn.chiucheung.annotation.AnnotationLimit;
import cn.chiucheung.controller.utils.FileUtil;
import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysMenujztreeExample;
import cn.chiucheung.pojo.system.menu.SysMenujztreeList;
import cn.chiucheung.pojo.system.menu.TextureMapQueryVo;
import cn.chiucheung.service.system.MenuInfoService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/system/menu")
public class MenuInfoController {

	@Autowired
    MenuInfoService menuInfoService;

	
	@RequestMapping("index")
    @AnnotationLimit(mid="bb",pid="0")
	public String file() {
		return "system/menuManage";
	}
	/**
	 * 搜索框查询
	 * 
	 * @param textureMapQueryVo
	 *            查询需要的条件
	 * @return 返回查询到的数据
	 */
	@RequestMapping("select")
	@ResponseBody
    @AnnotationLimit(mid="bh",pid="bb")
	public JSONObject selectInfo(TextureMapQueryVo textureMapQueryVo) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.accumulate("total",menuInfoService.selectInfoTotal(textureMapQueryVo));
		jsonObject.accumulate("rows",menuInfoService.selectInfo(textureMapQueryVo));
		return jsonObject;
	}

	/**
	 * 根据指定的条件查询信息
	 * 
	 * @param mid
	 *            本身ID
	 * @param pid
	 *            父类ID
	 * @return 返回处理后的结果
	 */
	@RequestMapping("selectById")
	@ResponseBody
    @AnnotationLimit(mid="bh",pid="bb")
	public JSONObject selectInfoById(String mid, String pid) {
		JSONObject jsonObject = new JSONObject();
		SysMenujztreeExample menuExample = new SysMenujztreeExample();
		menuExample.createCriteria().andMidEqualTo(mid).andPidEqualTo(pid);
		List<SysMenujztree> SysMenujztree = menuInfoService.selectInfoById(menuExample);
		jsonObject.accumulate("data", SysMenujztree.get(0));
		jsonObject.accumulate("success", true);
		return jsonObject;
	}

	/**
	 * 删除指定条件的信息
	 * @return 返回处理后的结果
	 */
	@RequestMapping("delete")
	@ResponseBody
    @AnnotationLimit(mid="bhc",pid="bh")
	public JSONObject deleteInfo(SysMenujztree sysMenujztree,HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String localPath = request.getServletContext().getRealPath("");
		String[] iconArray = sysMenujztree.getIcon().split(",");
		if (iconArray.length > 0) {
			for (String string : iconArray) {
			    if (!string.equals("")) {
                    String icons = localPath + string.substring(0, 13);
                    FileUtil.DeleteFolder(icons);
                }
			}
		}
		int i = menuInfoService.deleteInfo(sysMenujztree.getMid(),
				sysMenujztree.getPid());
		if (i > 0) {
			return jsonObject.accumulate("success", true);
		}
		if (i == -1){
            jsonObject.accumulate("success", false);
            jsonObject.accumulate("message","此菜单不允许操作");
            return jsonObject;
        }
		return jsonObject.accumulate("success", false);
	}

	/**
	 * 修改菜单信息
	 * 
	 * @param record
	 *            传输修改后的信息
	 * @param iconImg
	 *            图标图片信息
	 * @param request
	 *            接收到的请求
	 * @return 返回处理完成的结果
	 */
	@RequestMapping("update")
	@ResponseBody
    @AnnotationLimit(mid="bhb",pid="bh")
	public JSONObject updateInfo( SysMenujztree record,@RequestParam(value = "iconImg", required = true) MultipartFile[] iconImg,HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		SysMenujztreeExample menuExample = new SysMenujztreeExample();
		menuExample.createCriteria().andMidEqualTo(record.getMid()).andPidEqualTo(record.getPid());
		// 获取项目部署路径
		String localPath = request.getServletContext().getRealPath("");
		// 获取当前时间戳作为目录
		long dataString = new Date().getTime();
		// 获取前端传输过来的图标路径
		String path = record.getIcon();
		// 将路径截取到倒数第二层赋值给一个新的变量
		String[] s = path.split("/");
		String newPath = "";
		for (int i = 0; i < s.length - 1; i++) {
			newPath = newPath + s[i] + "/";
		}
		try {
			for (MultipartFile iconFile : iconImg) {
				// 判断图片文件是否为空,当不为空时再对文件进行操作
				if (!iconFile.isEmpty()) {
					String suffix = iconFile.getOriginalFilename().substring(
							iconFile.getOriginalFilename().lastIndexOf("."));
					suffix = suffix.toLowerCase();
					// 判断图片文件的后缀名是否正确
					if (suffix.equals(".jpg") || suffix.equals(".jpeg")
							|| suffix.equals(".png") || suffix.equals(".gif")) {
						// 判断传输过来的图标路径是否为空,当为空时将图片文件存入一个新的路径,当不为空时删除原有文件
						// 然后将新文件存入原有文件路径处
						if (!path.equals("") && path != null) {

							String imgName = iconFile.getOriginalFilename();
							File targetFile = new File(localPath, newPath + imgName);
							// 判断原先存储的文件是否存在,存在就将该文件删除
							File oldFile = new File(localPath, path);
							if (oldFile.exists()) {
								Boolean b = FileUtil.DeleteFolder(localPath + path);
								if (b) {
									// 当旧文件删除成功后将传输过来的文件存储在旧文件相同的目录下
									iconFile.transferTo(targetFile);
									record.setIcon(newPath + imgName);
								}
							} else {
								// 不存在旧文件就直接将新文件存入旧文件所在路径
								iconFile.transferTo(targetFile);
								record.setIcon(newPath + imgName);
							}

						} else {
							// 图标路径
							File iconPath = new File(localPath + "/" + dataString + "/image");

							if (!iconPath.exists()) {
								iconPath.mkdirs();
							}
							File targetFile = new File(iconPath,iconFile.getOriginalFilename());
							iconFile.transferTo(targetFile);
							String fileName = dataString + "/image/" + iconFile.getOriginalFilename();
							record.setIcon(fileName);
						}
					} else {
						jsonObject.accumulate("success", false);
						jsonObject.accumulate("errorMsg", "图片格式不支持");
						return jsonObject;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("errorMsg", e.getMessage());
			return jsonObject;
		}
		int i = menuInfoService.updateInfo(record, menuExample);
		if (i > 0) {
			return jsonObject.accumulate("success", true);
		}
		return jsonObject.accumulate("success", false);
	}

	/**
	 * 新增菜单信息
	 * 
	 * @param record
	 *            需要新增的信息
	 * @param iconImg
	 *            图标的图片信息
	 * @param request
	 *            接收的请求
	 * @return 返回处理完成的结果
	 */
	@RequestMapping("insert")
	@ResponseBody
    @AnnotationLimit(mid="bha",pid="bh")
	public JSONObject insertInfo( SysMenujztree record,@RequestParam(value = "iconImg") MultipartFile[] iconImg,HttpServletRequest request) {
		JSONObject jsonObject = new JSONObject();
		String path = request.getServletContext().getRealPath("");
		long dataString = new Date().getTime();
		// 图标路径
		File iconPath = new File(path + "/" + dataString + "/image");
		try {
			// 对图标进行操作
			for (MultipartFile iconFile : iconImg) {
				if (!iconFile.isEmpty()) {
					if (!iconPath.exists()) {
						iconPath.mkdirs();
					}
					String suffix = iconFile.getOriginalFilename().substring(iconFile.getOriginalFilename().lastIndexOf("."));
					suffix = suffix.toLowerCase();
					if (suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png") || suffix.equals(".gif")) {
						File targetFile = new File(iconPath,iconFile.getOriginalFilename());
						iconFile.transferTo(targetFile);
						String fileName = dataString + "/image/" + iconFile.getOriginalFilename();
						record.setIcon(fileName);
					} else {
						jsonObject.accumulate("success", false);
						jsonObject.accumulate("errorMsg", "图片格式不支持");
						Boolean b = FileUtil.DeleteFolder(path + "/" + dataString + "/image");
						if (b) {
							return jsonObject;
						} else {
							return jsonObject.accumulate("errorMsg",
									"图片格式不正确，请重新上传!");
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			jsonObject.accumulate("success", false);
			jsonObject.accumulate("errorMsg", e.getMessage());
			return jsonObject;
		}

		int i = menuInfoService.insertInfo(record);
		if (i > 0) {
			return jsonObject.accumulate("success", true);
		}
		return jsonObject.accumulate("success", false);
	}

	/**
	 * 获取全部菜单信息
	 * 
	 * @param textureMapQueryVo
	 *            获取信息的条件
	 * @return 返回组装成树形结构的菜单信息
	 */
	@RequestMapping("getAllMenuInfo")
	@ResponseBody
    @AnnotationLimit(mid="bh",pid="bb")
	public Object getAllMenuInfo(TextureMapQueryVo textureMapQueryVo) {
		String id = textureMapQueryVo.getId();
		JSONObject jsonObject = new JSONObject();
		List<SysMenujztreeList> list;
		if (("").equals(id) || id == null) {
			list = menuInfoService.getAllMenuInfo(textureMapQueryVo);
			jsonObject.accumulate("rows", list);
			jsonObject.accumulate("total", menuInfoService.selectMenuPageCountInfo("0",textureMapQueryVo.getName()));
			return jsonObject;
		} else {
			list = menuInfoService.getAllMenuInfo(textureMapQueryVo);
			return list;
		}

	}

	/**
	 * 获取除最底层外的全部菜单信息
	 * 
	 * @return 返回组装成树形结构的菜单信息
	 */
	@RequestMapping("getMenuInfo")
	@ResponseBody
    @AnnotationLimit(mid="bh",pid="bb")
	public Object getMenuInfo() {
		JSONObject jsonObject = new JSONObject();
		List<SysMenujztreeList> list = menuInfoService.getMenuInfo();
		jsonObject.accumulate("rows", list);
		return jsonObject;
	}

}
