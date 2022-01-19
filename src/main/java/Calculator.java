import java.util.List;

public class Calculator {
    public Calculator(){

    }

    public float add(float num1, float num2) {
        return num1 + num2;
    }

    public float sub(float num1, float num2) {
        return num1 - num2;
    }

    public float mul(float num1, float num2) {
        return num1 * num2;
    }

    public float div(float num1, float num2) {
        return num1 / num2;
    }

    public float doBinaryOperation(float num1, float num2, String ope) {
        switch (ope) {
            case "+":
                return add(num1, num2);
            case "-":
                return sub(num1, num2);
            case "*":
                return mul(num1, num2);
            case "/":
                return div(num1, num2);
        }
        return 0;
    }

    public float doMultipleOperation(List<Integer> numbers, List<String> operator){
        float result = numbers.remove(0);
        for (int i=0; i < numbers.size(); i++){
            result = doBinaryOperation(result, (float) numbers.get(i), operator.get(i));
        }
        return result;
    }
}
