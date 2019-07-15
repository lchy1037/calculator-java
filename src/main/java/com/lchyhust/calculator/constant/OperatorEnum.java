package com.lchyhust.calculator.constant;

import lombok.Data;

/**
 * 操作符
 *
 * @author mikeluan
 * @create 2019-07-15 16:22
 */
public enum OperatorEnum {
    /* 加号 */
    OPERATOR_PLUS(1, "+", "加号"),
    /* 减号 */
    OPERATOR_MINUS(2, "-", "减号"),
    /* 乘号 */
    OPERATOR_MULTIPLE(3, "*", "乘号"),
    /* 除号 */
    OPERATOR_DIVIDE(4, "/", "除号");
    private Integer code;
    private String type;
    private String name;

    private OperatorEnum(Integer code, String type, String name) {
        this.code = code;
        this.type = type;
        this.name = name;
    }

    public static OperatorEnum getByType(String type) {
        for (OperatorEnum op : values()) {
            if (op.getType().equals(type)) {
                return op;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
