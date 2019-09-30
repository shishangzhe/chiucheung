package cn.chiucheung.pojo.system.menu;

import cn.chiucheung.po.system.user.SysMenujztree;

import java.util.List;

public class SysMenujztreeList extends SysMenujztree {
  
  private String state;
  
  private List<SysMenujztreeList> children;
  

  public String getState() {
    
    return !getIsparent() && !getIsmenu() ? "open":"closed";
  }

  public List<SysMenujztreeList> getChildren() {
    return children;
  }

  public void setChildren(List<SysMenujztreeList> children) {
    this.children = children;
  }
  


}
