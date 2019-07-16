package com.lchyhust.calculator;

import com.lchyhust.calculator.constant.OperatorEnum;
import com.lchyhust.calculator.constant.ReturnCodeEnum;
import com.lchyhust.calculator.controller.CalculatorController;
import com.lchyhust.calculator.request.CalculatorRequest;
import com.lchyhust.calculator.response.CalculatorResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorApplicationTests {

	@Autowired
	CalculatorController calculatorController;

	@Test
	public void contextLoads() {
		Integer num1 = 10;
		Integer num2 = 5;
		String opPlus = OperatorEnum.OPERATOR_PLUS.getType();
		String opMinus = OperatorEnum.OPERATOR_MINUS.getType();
		String opMultiple = OperatorEnum.OPERATOR_MULTIPLE.getType();
		String opDivide = OperatorEnum.OPERATOR_DIVIDE.getType();

		CalculatorResponse resp = new CalculatorResponse();

		printResult(calculate(num1, opPlus, num2), "plus");
		printResult(calculate(num1, opMinus, num2), "minus");
		printResult(calculate(num1, opMultiple, num2), "multiple");
		printResult(calculate(num1, opDivide, num2), "divide");
	}

	private CalculatorResponse calculate(Integer num1, String oper, Integer num2) {
		CalculatorRequest req = new CalculatorRequest();
		req.setNum1(num1);
		req.setNum2(num2);
		req.setOper(oper);
		return calculatorController.calculator(req);
	}

	private void printResult(CalculatorResponse resp, String msg) {
		if (resp.getReturnCode().equals(ReturnCodeEnum.SUCCESS.getCode())) {
			System.out.println(msg + " success. expression: " + resp.getExpression());
		} else {
			System.out.println(msg + " failed. error msg: " + resp.getReturnMsg());
		}
	}
}
