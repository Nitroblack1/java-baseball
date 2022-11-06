package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import org.junit.jupiter.api.Test;

public class Application {

    public static void main(String[] args) {
        boolean run = true;
        boolean finish = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (run && finish) {
            finish = false;
            RunGame game = new RunGame();
            DataBase data = new DataBase();
            data.setAnswer(game.setAnswer());
            Output output = new Output();
            while (!finish) {
                CompareNumbers strikeBall = new CompareNumbers();
                data.setUserInput(game.userInput());
                strikeBall.checkNumber(data.getUserInput(), data.getAnswer());
                data.setBall(strikeBall.ball);
                data.setStrike(strikeBall.strike);
                output.printResult(data.getStrike(), data.getBall());
                finish = game.isFinish(data.getStrike());
                run = game.isAgain(finish);
            }
        }
        System.out.println("게임 종료");
    }
}

class RunGame {

    public List<Integer> setAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public List<Integer> userInput() {
        List<Integer> intUserInput = new ArrayList<>();
        String[] stringUserInput = {};
        stringUserInput = Console.readLine().split("");
        for (String number : stringUserInput) {
            intUserInput.add(Integer.parseInt(number));
        }
        return intUserInput;
    }

    public boolean isFinish(int strike) {
        if (strike == 3) {
            return true;
        }
        return false;
    }

    public boolean isAgain(boolean finish) {
        int userInput = -1;
        if (finish == true) {
            userInput = Integer.parseInt(Console.readLine());
        }
        if (userInput == 1) {
            return true;
        }
        if (userInput == 2) {
            return false;
        }
        return true;
    }
}

class Output {

    static void printResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}

class CompareNumbers {

    int strike = 0;
    int ball = 0;

    public void checkNumber(List<Integer> userInput, List<Integer> answer) {
        for (int number : userInput) {
            if (answer.contains(number)) {
                ball++;
            }
        }
        for (int i = 0; i < userInput.size(); i++) {
            if (userInput.get(i) == answer.get(i)) {
                strike++;
                ball--;
            }
        }
    }
}

class DataBase {

    static List<Integer> answer = new ArrayList<>();
    private List<Integer> userInput = new ArrayList<>();
    private int strike = 0;
    private int ball = 0;

    public static void setAnswer(List<Integer> randomNumber) {
        answer = randomNumber;
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public void setUserInput(List<Integer> userInput) {
        this.userInput = userInput;
    }

    public List<Integer> getUserInput() {
        return this.userInput;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getStrike() {
        return this.strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getBall() {
        return this.ball;
    }
}