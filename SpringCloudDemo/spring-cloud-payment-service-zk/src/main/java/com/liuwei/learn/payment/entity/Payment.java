package com.liuwei.learn.payment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: LiuWei
 * @Date: Created in 2021/8/25 16:49
 * @Package: com.liuwei.learn.payment.entity
 * @Modified By:
 * @Description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
