package org.example.common;

/**
 * @author Yushun Shao
 * @date 2023/1/18 14:59
 * @description: 基于ThreadLocal封装的工具类
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    /**
     * 保存登录用户id
     * @param id
     */
    public static void setCurrentId(Long id){
        threadLocal.set(id);
    }

    /**
     * 获取登录用户id
     * @return
     */
    public static Long getCurrentId(){
        return threadLocal.get();
    }
}
