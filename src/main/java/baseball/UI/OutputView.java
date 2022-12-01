package baseball.UI;

import java.util.List;

public class OutputView {

    public void printCurrentResult(List<Integer> currentResult) {
        if(currentResult.get(0) == 0 && currentResult.get(1) == 0) {
            System.out.println("낫싱");
        }
        if(currentResult.get(0) == 0 && currentResult.get(1) != 0) {
            System.out.printf("%d스트라이크\n", currentResult.get(1));
        }
        if(currentResult.get(0) != 0 && currentResult.get(1) == 0) {
            System.out.printf("%d볼\n", currentResult.get(0));
        }
        if(currentResult.get(0) != 0 && currentResult.get(1) != 0) {
            System.out.printf("%d볼 %d스트라이크\n", currentResult.get(0), currentResult.get(1));
        }
    }
}
