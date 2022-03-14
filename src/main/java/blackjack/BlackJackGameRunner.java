package blackjack;

import blackjack.dto.CurrentTurnParticipant;
import blackjack.view.input.DrawCommand;
import blackjack.view.input.InputView;
import blackjack.view.output.OutputView;
import java.util.List;

public class BlackJackGameRunner {

    public void run() {
        final List<String> playerNames = InputView.inputPlayerNames();
        final GameCommunicator gameCommunicator = new GameCommunicator(playerNames);
        OutputView.showGameInitInfo(gameCommunicator.getInitDealerInfo(), gameCommunicator.getInitPlayerInfo());

        runPlayerTurn(gameCommunicator);
        runDealerTurn(gameCommunicator);

        OutputView.printResultPlayerInfos(gameCommunicator.getPlayerResultInfos());
        OutputView.printAllOutcomeResult(gameCommunicator.getWinningResult());
    }

    private void runDealerTurn(final GameCommunicator gameCommunicator) {
        while (!gameCommunicator.isDealerTurnEnd()) {
            gameCommunicator.drawDealer();
            OutputView.printDealerDraw();
        }
        gameCommunicator.stayDealer();
    }

    private void runPlayerTurn(final GameCommunicator gameCommunicator) {
        while (!gameCommunicator.isAllPlayersEnd()) {
            final String command = InputView.inputDrawCommand(gameCommunicator.getCurrentTurnPlayerInfo());
            final DrawCommand drawCommand = DrawCommand.from(command);
            final CurrentTurnParticipant currentCurrentTurnParticipant =
                    checkCurrentPlayerDrawNew(gameCommunicator, drawCommand);
            OutputView.printPlayerCardInfo(currentCurrentTurnParticipant);
        }
    }

    private CurrentTurnParticipant checkCurrentPlayerDrawNew(
            final GameCommunicator gameCommunicator, final DrawCommand command) {
        if (command.isNo()) {
            return gameCommunicator.drawNextPlayer();
        }
        return gameCommunicator.drawCurrentPlayer();
    }
}