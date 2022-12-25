public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.0, 3.0));
        System.out.println(areEqualByThreeDecimalPlaces(-3.123, 3.123));
    }

    public static boolean areEqualByThreeDecimalPlaces(double number1, double number2){
        int firstNumber = (int) (number1 * 1000);
        int secondNumber = (int) (number2 * 1000);
        if(firstNumber == secondNumber)
            return true;
        else
            return false;
    }
}