package baseball.UI;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    @Mock
    InputView inputView = new InputView();

    @Nested
    @DisplayName("숫자 입력을 받을 때")
    class NumberInputTest {

        @DisplayName("올바른 숫자 입력 테스트")
        @Test
        void wrightNumberInputTest() {
            String testCase = "123";
            InputStream in = new ByteArrayInputStream(testCase.getBytes());
            System.setIn(in);

            assertThat(inputView.getNumbers()).isEqualTo(testCase);
        }

        @DisplayName("예외 상황 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"114", "fw7"})
        void wrongNumberInputTest(String testCase) {
            InputStream in = new ByteArrayInputStream(testCase.getBytes());
            System.setIn(in);

            assertThatThrownBy(() -> inputView.getNumbers())
                    .isInstanceOf(IllegalArgumentException.class);

        }
    }

    @Nested
    @DisplayName("게임이 끝난 후 재시작/종료 여부를 입력 받을 때")
    class RetryOrQuitTest {

        @DisplayName("올바른 입력 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"1", "2"})
        void wrightIntentionTest(String userInput) {
            InputStream in = new ByteArrayInputStream(userInput.getBytes());
            System.setIn(in);

            assertThat(inputView.getIntention()).isEqualto(userInput);
        }

        @DisplayName("예외 상황 테스트")
        @ParameterizedTest
        @ValueSource(strings = {"3", "rr"})
        void wrongIntentionTest(String userInput) {
            InputStream in = new ByteArrayInputStream(testCase.getBytes());
            System.setIn(in);

            assertThatThrownBy(() -> inputView.getIntention())
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
