package cn.chiucheung.service.system;

import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysMenujztreeExample;
import cn.chiucheung.pojo.system.menu.SysMenujztreeList;
import cn.chiucheung.pojo.system.menu.TextureMapQueryVo;

import java.util.List;

public interface MenuInfoService{
	/**
	 * 搜索框查询
	 * @param textureMapQueryVo 查询需要的条件
	 * @return 返回查询到的数据
	 */
	public List<SysMenujztreeList> selectInfo(TextureMapQueryVo textureMapQueryVo);
	
	/**
	 * 根据条件查询数据
	 * @param example 需要的条件
	 * @return 返回根据条件查询到的数据
	 */
	public List<SysMenujztree> selectInfoById(SysMenujztreeExample example);
	
	/**
	 * 给数据库新增数据
	 * @param record 新增的数据
	 * @return 返回是否成功
	 */
	public int insertInfo(SysMenujztree record);
	
	/**
	 * 删除指定数据
	 * @return 是否成功
	 */
	public int deleteInfo(String mid, String pid);
	
	/**
	 * 删除父类以及跟父类关联的子类菜单
	 * @param mid 本身id
	 * @param pid 本身父类id
	 * @return 是否成功
	 */
	public int deleteMenuInfo(String mid, String pid);

	/**
	 * 更新指定条件的数据
	 * @param record 指定条件
	 * @param example 更新的数据内容
	 * @return 是否成功
	 */
	public int updateInfo(SysMenujztree record, SysMenujztreeExample example);
	
	/**
	 * 搜索框查询到数据总数量
	 * @param textureMapQueryVo 查询需要的条件
	 * @return 返回查询到的总数据量
	 */
	public String selectInfoTotal(TextureMapQueryVo textureMapQueryVo);
	
	/**
	 * 获取除最底层外的全部菜单信息
	 * @return 返回组装成树形结构的菜单信息
	 */
	public List<SysMenujztreeList> getMenuInfo();
	
	
	/**
	 * 获取某些条件下的菜单总数量
	 * @param mid 本身ID
	 * @param name 菜单名称
	 * @return 返回查询到的菜单总数量
	 */
	public String selectMenuPageCountInfo(String mid, String name);
	
	/**
	 * 获取全部菜单信息
	 * @param textureMapQueryVo 获取信息的条件
	 * @return 返回组装成树形结构的菜单信息(带分页功能)
	 */
	public List<SysMenujztreeList> getAllMenuInfo(TextureMapQueryVo textureMapQueryVo);
	
	
	
	
}
