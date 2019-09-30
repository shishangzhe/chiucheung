package cn.chiucheung.utils;

import javax.servlet.http.HttpSession;

import cn.chiucheung.po.system.user.SysUser;

/**
 * 用户身份信息工具类
 *
 * @author mrt
 */
public class UserUtils {

    public static final String USER = "user";

    /**
     * 设置用户到session
     *
     * @param session
     * @param user
     */
    public static void saveUserToSession(HttpSession session, SysUser user) {
        session.setAttribute(USER, user);
    }

    /**
     * 从Session获取当前用户信息
     *
     * @param session
     * @return
     */
    public static SysUser getUserFromSession(HttpSession session) {
        Object attribute = session.getAttribute(USER);
        return attribute == null ? null : (SysUser) attribute;
    }

}
