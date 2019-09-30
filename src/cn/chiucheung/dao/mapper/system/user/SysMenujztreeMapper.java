package cn.chiucheung.dao.mapper.system.user;

import cn.chiucheung.po.system.user.SysMenujztree;
import cn.chiucheung.po.system.user.SysMenujztreeExample;
import cn.chiucheung.po.system.user.SysMenujztreeKey;
import cn.chiucheung.pojo.system.menu.SysMenujztreeList;
import cn.chiucheung.pojo.system.menu.TextureMapQueryVo;
import cn.chiucheung.pojo.system.role.MenujztreeCustom;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysMenujztreeMapper {
    int countByExample(SysMenujztreeExample example);

    int deleteByExample(SysMenujztreeExample example);

    int deleteByPrimaryKey(SysMenujztreeKey key);

    int insert(SysMenujztree record);

    int insertSelective(SysMenujztree record);

    List<SysMenujztree> selectByExample(SysMenujztreeExample example);

    SysMenujztree selectByPrimaryKey(SysMenujztreeKey key);

    int updateByExampleSelective(@Param("record") SysMenujztree record, @Param("example") SysMenujztreeExample example);

    int updateByExample(@Param("record") SysMenujztree record, @Param("example") SysMenujztreeExample example);

    int updateByPrimaryKeySelective(SysMenujztree record);

    int updateByPrimaryKey(SysMenujztree record);

	List<MenujztreeCustom> findAllMenujtreeByPid(String pid);

    /**
     * 搜索框查询
     * @param textureMapQueryVo 查询需要的条件
     * @return 返回查询到的数据
     */
    List<SysMenujztreeList> selectInfo(TextureMapQueryVo textureMapQueryVo);

    /**
     * 搜索框查询到数据总数量
     * @param textureMapQueryVo 查询需要的分页条件
     * @return 返回查询到的总数据量
     */
    String selectInfoTotal(TextureMapQueryVo textureMapQueryVo);

    List<SysMenujztreeList> selectChildMenuInfo();

    /**
     * 查询带分页的菜单信息
     * @return 返回分页的菜单信息
     */
    List<SysMenujztreeList> selectMenuPageInfo(TextureMapQueryVo textureMapQueryVo);

    /**
     * 获取某一个值下的数据总量
     * @param mid 某一个值
     * @return 返回的数据总量
     */
    String selectMenuPageCountInfo(@Param("mid") String mid, @Param("name") String name);

}