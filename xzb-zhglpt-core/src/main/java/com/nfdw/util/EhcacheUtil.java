package com.nfdw.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.shiro.cache.ehcache.EhCacheManager;

public class EhcacheUtil {
    /**
     * 设置缓存对象
     *
     * @param cacheManager
     * @param key
     * @param object
     */
    public static void setCache(CacheManager cacheManager, String key, Object object, int timeout) {

        Cache cache = cacheManager.getCache("smsRetryCache");
        Element element = new Element(key, object);
        element.setTimeToLive(timeout);
        cache.put(element);
    }

    /**
     * 从缓存中取出对象
     *
     * @param cacheManager
     * @param key
     * @return
     */
    public static Object getCache(CacheManager cacheManager, String key) {
        Object object = null;
        Cache cache = cacheManager.getCache("smsRetryCache");
        if (cache.get(key) != null && !cache.get(key).equals("")) {
            object = cache.get(key).getObjectValue();
        }
        return object;

    }
}
