package com.nfdw.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

public class ShiroKitUtils {
    /**
     * 设置shiro指定的sessionKey
     *
     */
    public static void setSessionAttr(String key, Object value,String timeout) {
        Session session = getSession();
        if(StringUtils.isEmpty(timeout)){
            session.setTimeout(Long.parseLong(timeout));
        }
        session.setAttribute(key, value);
    }

    /**
     * 从shiro获取session
     *
     */
    public static Session getSession() {
        return getSubject().getSession();
    }
    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }
    /**
     * 移除shiro指定的sessionKey
     */
    public static void removeSessionAttr(String key) {
        Session session = getSession();
        if (session != null){
            session.removeAttribute(key);
        }
    }
    public static <T> T getSessionAttr(String key) {
        Session session = getSession();
        return session != null ? (T) session.getAttribute(key) : null;
    }
}
