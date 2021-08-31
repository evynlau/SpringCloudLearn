package com.liuwei.learn.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author ：LiuWei
 * @Date ：Created in 2021/8/25 16:57
 * @Package: com.liuwei.learn.payment.bean
 * @Modified By：
 * @Description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }
}
