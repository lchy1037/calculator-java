package com.lchyhust.calculator.constant;

/**
 * 接口返回值
 *
 * @author mikeluan
 * @create 2019-07-15 17:21
 */
public enum ReturnCodeEnum {
    /* success */
    SUCCESS(0, "success"),
    /* failed */
    FAILED(1, "failed"),
    /* divisor can't be zero */
    ErrDivisorIsZero(2, "divisor can't be zero"),
    /* operate type is invalid */
    ErrOperateTypeInvalid(3, "operate type is invalid");
    private Integer code;
    private String name;

    ReturnCodeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
