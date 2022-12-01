package baseball.Domain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;

public class RefereeTest {

    @Mock
    Referee referee = new Referee();

    @DisplayName("판정 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456", "789"})
    void judgementTest(String userInput) {
        referee.generateAnswer();
        System.out.println(referee.getAnswer());
        System.out.println(referee.judge(userInput));
    }
}
