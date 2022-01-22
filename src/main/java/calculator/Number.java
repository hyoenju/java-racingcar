package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    public void addNumber(String num) {
        if (!num.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException("숫자가 아닙니다");
        }
        numbers.add(Integer.valueOf(num));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
