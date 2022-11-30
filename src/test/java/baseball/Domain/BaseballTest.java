package baseball.Domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballTest {

    @DisplayName("게임 시작시 정답 추출하여 Referee에 전달 테스트")
    @Test
    void gameStartTest() {
        Baseball game = new Baseball();

        assertThat(game.referee.getAnswer().size()).isEqualTo(3);
    }
}
