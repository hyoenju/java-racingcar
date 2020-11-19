package stringCalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorManager {

    private int result = 0;

    public CalculatorManager(List<Integer> operands, List<String> operators) {
        result = operands.get(0); // 첫 자리 값 셋팅;
        calculate(operands, operators);
    }

    private void calculate(List<Integer> operands, List<String> operators) {
        int operatorCnt = 1;

        for (String operator : operators) {
            // 연산자의 개수(초기 값 1)
            // 연산자의 개수와 피연산자의 첫 자리만 빼면 개수는 같다.
            int operand = operands.get(operatorCnt);
            calculate(operand, operator);
            operatorCnt++;
        }
    }

    private void calculate(int operand, String operator) {
        List<Operator> operators = filterOperator(operator);
        calculate(operand, operators);
    }

    private List<Operator> filterOperator(String operator) {
        List<Operator> operators = new ArrayList<>();
        for (Operator value : Operator.values()) {
            addIfEquals(operator, value, operators);
        }

        return operators;
    }

    private void addIfEquals(String operator, Operator value, List<Operator> operators) {
        if (operator.equals(value.getOperator())) {
            operators.add(value);
        }
    }

    private void calculate(int operand, List<Operator> operators) {
        for (Operator value : operators) {
            result = value.calculate(result, operand);
        }
    }

    public int getResult() {
        return result;
    }
}