package ro.esolacad.javaad.unittest;

public class Calculator {

    public int getRandomNumber(int firstParam, int secondParam) {
        boolean firstParamIsEven = firstParam % 2 == 0;
        boolean secondParamIsEven = secondParam % 2 == 0;

        if(firstParamIsEven && secondParamIsEven) {
            return 1;
        } else if(firstParamIsEven || secondParamIsEven){
            return 2;
        } else {
            return 4;
        }
    }
}
