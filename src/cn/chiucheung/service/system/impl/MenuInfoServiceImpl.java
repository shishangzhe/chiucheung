package cn.chiucheung.service.system.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import cn.chiucheung.dao.mapper.system.user.SysMenujztreeMapper;
import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysMenujztreeExample;
import cn.chiucheung.pojo.system.menu.SysMenujztreeList;
import cn.chiucheung.pojo.system.menu.TextureMapQueryVo;
import cn.chiucheung.service.system.MenuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

  @Autowired
  SysMenujztreeMapper sysMenujztreeMapper;

  public List<SysMenujztreeList> selectInfo(
          TextureMapQueryVo textureMapQueryVo) {
    return sysMenujztreeMapper.selectInfo(textureMapQueryVo);
  }

  @Override
  public List<SysMenujztree> selectInfoById(SysMenujztreeExample example) {
    return sysMenujztreeMapper.selectByExample(example);
  }

  @Override
  public int insertInfo(SysMenujztree record) {
    int insertSelective = sysMenujztreeMapper.insertSelective(record);
    return insertSelective;
  }

  @Override
  public int deleteInfo(String mid, String pid) {
    String[] midArray = mid.split(",");
    String[] pidArray = pid.split(",");
    List<String> pidList = new ArrayList<>();
    List<String> midList = new ArrayList<>();
    for (int j = 0; j < midArray.length; j++) {
      String mids = midArray[j];
      String pids = pidArray[j];
      if (mids.equals("bh") && pids.equals("bb")){
          return -1;
      }
      pidList.add(pids);
      midList.add(mids);
    }
    SysMenujztreeExample menuExample = new SysMenujztreeExample();
    menuExample.createCriteria().andPidIn(pidList).andMidIn(midList);
    int i = sysMenujztreeMapper.deleteByExample(menuExample);
    return i;
  }
  
  @Override
  public int deleteMenuInfo(String mid,String pid) {
    int i = 0;
    SysMenujztreeExample menuExample = new SysMenujztreeExample();
    String[] midArray = mid.split(",");
    String[] pidArray = pid.split(",");
    List<String> pidList = new ArrayList<>();
    List<String> midList = new ArrayList<>();
    for (int j = 0; j < midArray.length; j++) {
      String mids = midArray[j];
      String pids = pidArray[j];
      pidList.add(pids);
      midList.add(mids);
      i = deleteMenuChildInfo(mid,pid);
    }
    menuExample.createCriteria().andPidIn(pidList).andMidIn(midList);
    i = sysMenujztreeMapper.deleteByExample(menuExample);
    
    return i;
  }
  
  public int deleteMenuChildInfo(String mid,String pid){
    int i = 0;
    SysMenujztreeExample menuExample = new SysMenujztreeExample();
    menuExample.createCriteria().andPidEqualTo(mid);
    List<SysMenujztree> menuList = sysMenujztreeMapper.selectByExample(menuExample);
    if (menuList.size()>0) {
      for (SysMenujztree sysMenu : menuList) {
        String midChild = sysMenu.getMid();
        String pidChild = sysMenu.getPid();
        deleteMenuChildInfo(midChild,pidChild);
      }
       i = sysMenujztreeMapper.deleteByExample(menuExample);
    }
    
    return i;
  }

  @Override
  public int updateInfo(SysMenujztree record, SysMenujztreeExample example) {
    int i = sysMenujztreeMapper.updateByExampleSelective(record, example);
    return i;
  }

  @Override
  public String selectInfoTotal(TextureMapQueryVo textureMapQueryVo) {
    return sysMenujztreeMapper.selectInfoTotal(textureMapQueryVo);
  }

  @Override
  public String selectMenuPageCountInfo(String mid,String name) {
    return sysMenujztreeMapper.selectMenuPageCountInfo(mid,name);
  }
  
  @Override
  public List<SysMenujztreeList> getAllMenuInfo(TextureMapQueryVo textureMapQueryVo) {
    List<SysMenujztreeList> menuList = sysMenujztreeMapper.selectMenuPageInfo(textureMapQueryVo);
    return menuList;
  }

  @Override
  public List<SysMenujztreeList> getMenuInfo(){
    List<SysMenujztreeList> menuList = sysMenujztreeMapper.selectChildMenuInfo();
    Map<String, List<SysMenujztreeList>> pidMap = new HashMap<String, List<SysMenujztreeList>>();    
    
    for (SysMenujztreeList menujztreeList : menuList) {
      if (pidMap.containsKey(menujztreeList.getPid())) {
        pidMap.get(menujztreeList.getPid()).add(menujztreeList);
      } else {
        List<SysMenujztreeList> lists = new ArrayList<SysMenujztreeList>();
        lists.add(menujztreeList);
        pidMap.put(menujztreeList.getPid(), lists);
      }
    }
    List<SysMenujztreeList> lists = new ArrayList<SysMenujztreeList>();
    
    SysMenujztreeList menu = new SysMenujztreeList();
    menu.setMid("0");
    menu.setName("新增菜单");
    menu.setIsparent(true);
    menu.setIsmenu(true);
    lists.add(menu);
    List<SysMenujztreeList> list2 = pidMap.get("0");

    getMenuList(list2, pidMap);
    lists.get(0).setChildren(list2);

    return lists;
  }
  
  /**
   * 该方法用于组装树形结构的数据
   * @param menuList 父级集合
   * @param pidMap key值为父类ID的map集合
   */
  private void getMenuList(List<SysMenujztreeList> menuList,Map<String, List<SysMenujztreeList>> pidMap) {
    for (SysMenujztreeList menujztreeList : menuList) {

      if (pidMap.containsKey(menujztreeList.getMid())) {

        List<SysMenujztreeList> list = pidMap.get(menujztreeList.getMid());
        getMenuList(list, pidMap);
        menujztreeList.setChildren(list);
      }
    }
  }

}
