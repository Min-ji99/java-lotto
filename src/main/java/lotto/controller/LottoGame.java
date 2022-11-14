package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.util.InputChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGame {
    private UserLotto userLotto;
    private InputView inputView;
    private InputChecker inputChecker;
    private OutputView outputView;
    private Lotto winningLotto;

    public LottoGame(){
        inputView=new InputView();
        inputChecker=new InputChecker();
        outputView=new OutputView();
    }
    public void startGame() throws IllegalArgumentException{
        getMoneyInput();
        getLottoWinningNumberInput();
    }
    public void getMoneyInput() throws IllegalArgumentException{
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            userLotto=new UserLotto(Integer.parseInt(input));
            System.out.printf("%d%s\n", userLotto.getLottoCount(), outputView.printLottoPurchaseCount());
            outputView.printLottoNumbersAll(userLotto.getLottos());
        }
    }
    public void getLottoWinningNumberInput() throws IllegalArgumentException {
        String input=inputView.inputWinningNumber();
        List<String> inputWinningLottoNumbers = Arrays.asList(input.split(","));

        if(inputChecker.checkInputWinningLottoNumbersIsNumeric(inputWinningLottoNumbers)){
            List<Integer> changeStringToIntegerLottoNunbers=new ArrayList<>();
            for(String number : inputWinningLottoNumbers){
                changeStringToIntegerLottoNunbers.add(Integer.parseInt(number));
            }
            winningLotto=new Lotto(changeStringToIntegerLottoNunbers);
        }
    }
}
