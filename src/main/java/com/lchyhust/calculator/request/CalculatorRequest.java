package com.lchyhust.calculator.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 计算的请求体
 *
 * @author mikeluan
 * @create 2019-07-15 15:48
 */
@Data
public class CalculatorRequest implements Serializable {
    private Integer num1;
    private Integer num2;
    private String oper;
}
