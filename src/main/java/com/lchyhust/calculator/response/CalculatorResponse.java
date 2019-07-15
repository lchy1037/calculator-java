package com.lchyhust.calculator.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 计算的响应体
 *
 * @author mikeluan
 * @create 2019-07-15 15:51
 */
@Data
public class CalculatorResponse implements Serializable {
    private Integer returnCode;
    private String returnMsg;
    private String expression;
    private Integer result;
}
