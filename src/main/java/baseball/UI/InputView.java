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


}
