package com.lchyhust.calculator.controller;

import com.lchyhust.calculator.constant.OperatorEnum;
import com.lchyhust.calculator.constant.ReturnCodeEnum;
import com.lchyhust.calculator.request.CalculatorRequest;
import com.lchyhust.calculator.response.CalculatorResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 核心计算类
 *
 * @author mikeluan
 * @create 2019-07-15 15:37
 */
@RestController
public class CalculatorController {
    @RequestMapping(value = "/calculate")
    @ResponseBody
    public CalculatorResponse calculator(@RequestBody CalculatorRequest req) {
        // TODO: 暂时不做类型检查，后续改为泛型
        CalculatorResponse resp = new CalculatorResponse();

        OperatorEnum operValue = OperatorEnum.getByType(req.getOper());
        if (operValue == null) {
            resp.setResult(0);
            resp.setReturnCode(ReturnCodeEnum.FAILED.getCode());
            resp.setReturnMsg(ReturnCodeEnum.FAILED.getName());
            return resp;
        }
        switch (operValue) {
            case OPERATOR_PLUS:
                resp.setResult(req.getNum1() + req.getNum2());
                resp.setReturnCode(ReturnCodeEnum.SUCCESS.getCode());
                break;
            case OPERATOR_MINUS:
                resp.setResult(req.getNum1() - req.getNum2());
                resp.setReturnCode(ReturnCodeEnum.SUCCESS.getCode());
                break;
            case OPERATOR_MULTIPLE:
                resp.setResult(req.getNum1() * req.getNum2());
                resp.setReturnCode(ReturnCodeEnum.SUCCESS.getCode());
                break;
            case OPERATOR_DIVIDE:
                if (req.getNum2() == 0) {
                    resp.setReturnCode(ReturnCodeEnum.ErrDivisorIsZero.getCode());
                    resp.setReturnMsg(ReturnCodeEnum.ErrDivisorIsZero.getName());
                    return resp;
                }
                resp.setResult(req.getNum1() / req.getNum2());
                resp.setReturnCode(ReturnCodeEnum.SUCCESS.getCode());
                break;
            default:
                resp.setResult(0);
                resp.setReturnCode(ReturnCodeEnum.ErrOperateTypeInvalid.getCode());
                resp.setReturnMsg(ReturnCodeEnum.ErrOperateTypeInvalid.getName());
                return resp;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(req.getNum1())
                .append(req.getOper())
                .append(req.getNum2())
                .append("=")
                .append(resp.getResult());
        resp.setExpression(sb.toString());
        resp.setReturnMsg(ReturnCodeEnum.SUCCESS.getName());
        return resp;
    }
}
