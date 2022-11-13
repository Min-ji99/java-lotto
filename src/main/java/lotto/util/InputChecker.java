package lotto.util;

import lotto.ErrorMessage;

public class InputChecker {
    public boolean isDigit(String input) throws IllegalArgumentException{
        for(int i=0; i<input.length(); i++){
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_DIGIT_ERROR.print());
            }
        }
        return true;
    }
    public boolean isMultipleThousand(int money) throws IllegalArgumentException{
        if(money%1000!=0){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_MULTIPLE_THOUSAND.print());
        }
        return true;
    }
    public boolean checkInputMoney(String input) throws IllegalArgumentException{
        if(!isDigit(input) || isMultipleThousand(Integer.parseInt(input))){
            return false;
        }
        return true;
    }
}
