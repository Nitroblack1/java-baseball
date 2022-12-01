package baseball.Domain;

import baseball.Domain.Baseball.status;
import baseball.UI.InputView;
import baseball.UI.OutputView;

public class Application {
    public static void main(String[] args) {
        Baseball game = new Baseball();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        while(game.getGameStatus() != status.QUIT) {
            game.passUserInputAndGetResult(inputView.getNumbers());
            outputView.printCurrentResult(game.getCurrentResult());
            if (game.getGameStatus() == status.CORRECTED) {
                game.manageGameStatusAfterCorrected(inputView.getIntention());
            }
        }
    }
}
