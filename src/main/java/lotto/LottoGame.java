package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.util.InputChecker;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private Money money;
    private InputView inputView;
    private InputChecker inputChecker;
    private OutputView outputView;
    private List<Lotto> lottos;

    public LottoGame(){
        inputView=new InputView();
        inputChecker=new InputChecker();
        outputView=new OutputView();
        lottos=new ArrayList<>();
    }
    public void startGame(){
        getMoneyInput();
        getLottoNumberList();
    }
    public void getMoneyInput(){
        String input=inputView.inputMoney();
        if(inputChecker.checkInputMoney(input)){
            money=new Money(Integer.parseInt(input));
            System.out.printf("%d%s\n", money.getLottoCount(), outputView.printLottoPurchaseCount());
        }
    }
    public void getLottoNumberList(){
        for(int i=0; i< money.getLottoCount(); i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            if (!lotto.getLotto().isEmpty()) {
                lottos.add(lotto);
            }
        }
        outputView.printLottoNumbersAll(lottos);
    }
}
