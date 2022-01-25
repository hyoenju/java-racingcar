package calculator;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private final List<Integer> numbers;

    public Number() {
        numbers = new ArrayList<>();
    }

    public void add(String num) {
        if (!num.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new NumberFormatException("숫자가 아닙니다");
        }
        numbers.add(Integer.valueOf(num));
    }

    public int remove(int index) {
        return numbers.remove(index);
    }

    public double get(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }
}