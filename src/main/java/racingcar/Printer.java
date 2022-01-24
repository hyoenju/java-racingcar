package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.Participants;
import racingcar.domain.car.Car;

public class Printer {
    private static final String DASH = "-";
    private static final String HEAD_MESSAGE = "\n실행 결과\n";
    private static final String RESULT_FORMAT = "%s : %s\n";
    private static final String FINAL_RESULT_FORMAT = "최종 우승자 : %s";


    public void printInputCarNameMessage(){
        String NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        System.out.println(NAME_MESSAGE);
    }

    public void printInputTurnMessage(){
        String TURN_MESSAGE = "시도할 횟수는 몇 번인가요?";
        System.out.println(TURN_MESSAGE);
    }
    public void printErrorMessage(String message) {
        String ERROR_PREFIX = "[ERROR] ";
        System.out.println(ERROR_PREFIX + message);
    }

    public static String createCarStatusMessage(Car car) {
        String repeated = new String(new char[car.getStatus()]).replace("\0", DASH);
        return String.format(RESULT_FORMAT, car.getName(), repeated);
    }

    public void printFinalWinners(Stream<String> winnersName) {
        System.out.printf(FINAL_RESULT_FORMAT, winnersName.collect(Collectors.joining(", ")));
    }

    public String getResultOfOneTurn(Participants participants) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < participants.count(); i++) {
            sb.append(createCarStatusMessage(participants.get(i)));
        }
        return sb.append("\n").toString();
    }

    public void printResultMessage(StringBuilder result_sb) {
        StringBuilder sb = new StringBuilder(HEAD_MESSAGE);
        sb.append(result_sb);
        System.out.println(sb);
    }
}
