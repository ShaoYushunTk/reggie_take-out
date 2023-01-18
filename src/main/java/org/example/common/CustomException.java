package org.example.common;

/**
 * @author Yushun Shao
 * @date 2023/1/18 19:31
 * @description: 自定义业务异常
 */
public class CustomException extends RuntimeException{
    public CustomException(String msg){
        super(msg);
    }
}
