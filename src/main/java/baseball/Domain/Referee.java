package baseball.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Referee implements RandomAnswer {
    private List<Integer> answer;

    public void generateAnswer() {
        answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public List<Integer> getAnswer() {
        return this.answer;
    }

    public List<Integer> judge(String userInput) {
        List<Integer> guess = Arrays.stream(userInput.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int ball = (int)guess.stream().filter(answer::contains).count();
        int strike = 0;
        for(int i = 0; i < 3; i++) {
            if (Objects.equals(guess.get(i), answer.get(i))) {
                strike++;
                ball--;
            }
        }
        return new ArrayList<>(Arrays.asList(ball, strike));
    }
}
