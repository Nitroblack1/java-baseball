package baseball.Domain;

import java.util.List;

public class Baseball {
    Referee referee;
    Baseball() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        referee = new Referee();
    }
}
