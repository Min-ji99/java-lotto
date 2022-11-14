package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class InputCheckerTest {
    InputChecker inputChecker;

    @BeforeEach
    void setup(){
        inputChecker=new InputChecker();
    }

    @DisplayName("입력한 값이 정수가 아닌 경우 예외 발생 확인")
    @Test
    void isDigitTest(){
        assertThatThrownBy(()->inputChecker.isDigit("1000j"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 숫자가 1000으로 나누어떨어지지 않으면 예외 발생하는지 확인")
    @Test
    void isMultipleThousandTest1(){
        assertThatThrownBy(()->inputChecker.isMultipleThousand(1004))
                .isInstanceOf(IllegalArgumentException.class);
        assertThat(inputChecker.isMultipleThousand(1000)).isTrue();
    }
    @DisplayName("입력한 숫자가 1000으로 나누어떨어지면 true 반환하는지 확인")
    @Test
    void isMultipleThousandTest2(){
        assertThat(inputChecker.isMultipleThousand(1000)).isTrue();
    }

    @DisplayName("입력한 값이 숫자아니거나 1000으로 나누어떨어지지 않으면 예외 발생하는지 확인")
    @Test
    void checkInputMoney1(){
        assertThatThrownBy(()->inputChecker.checkInputMoney("1004"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->inputChecker.checkInputMoney("hi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @DisplayName("입력한 값이 숫자이고 1000으로 나누어떨어지면 true를 반환하는지 확인")
    @Test
    void checkInputMoney2(){
        assertThat(inputChecker.checkInputMoney("14000")).isTrue();
    }
}