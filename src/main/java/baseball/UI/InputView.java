package baseball.UI;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;

public class InputView {

    public String getNumbers() throws IllegalArgumentException {
        System.out.print("숫자를 입력해주세요 : ");
        String userInput = readLine();
        validateNumbers(userInput);
        return userInput;
    }

    private void validateNumbers(String userInput) {
        if (!userInput.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("No number or no three numbers");
        }
        if (Arrays.stream(userInput.split("")).distinct().count() != userInput.length()) {
            throw new IllegalArgumentException("No duplicated Numbers");
        }
    }

    public  String getIntention() throws IllegalArgumentException {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        validateIntention(userInput);
        return userInput;
    }

    private void validateIntention(String userInput) {
        if (!(userInput.equals("1") || userInput.equals("2"))) {
            throw new IllegalArgumentException("1이나 2를 입력하세요.");
        }
    }
}
