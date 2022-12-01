package baseball.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Baseball {
    Referee referee;
    private status gameStatus;
    private List<Integer> currentResult;

    enum status {
        PROGRESSING, CORRECTED, RESTART, QUIT;
    }
    Baseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        referee = new Referee();
        gameStatus = status.PROGRESSING;
    }

    public void generateAnswer() {
        referee.generateAnswer();
    }

    public void passUserInputAndGetResult(String userInput) {
        if (referee.judge(userInput).get(1) == 3) {
            gameStatus = status.CORRECTED;
        }
        currentResult = new ArrayList<>(referee.judge(userInput));
    }

    public void manageGameStatusAfterCorrected(String userInput) {
        if (Objects.equals(userInput, "1")) {
            gameStatus = status.RESTART;
        }
        if (Objects.equals(userInput, "2")) {
            gameStatus = status.QUIT;
        }
    }

    public void restartGame() {
        gameStatus = status.PROGRESSING;
    }

    public status getGameStatus() {
        return gameStatus;
    }

    public List<Integer> getCurrentResult() {
        return currentResult;
    }
}
