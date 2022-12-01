package baseball.Domain;

import baseball.Domain.Baseball.status;
import baseball.UI.InputView;
import baseball.UI.OutputView;

public class Application {

    public static void main(String[] args) {
        Baseball game = new Baseball();
        game.referee.generateAnswer();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        while (game.getGameStatus() != status.QUIT) {
            if (game.getGameStatus() == status.RESTART) {
                game.referee.generateAnswer();
                game.restartGame();
            }
            game.passUserInputAndGetResult(inputView.getNumbers());
            outputView.printCurrentResult(game.getCurrentResult());
            if (game.getGameStatus() == status.CORRECTED) {
                game.manageGameStatusAfterCorrected(inputView.getIntention());
            }
        }
    }
}
