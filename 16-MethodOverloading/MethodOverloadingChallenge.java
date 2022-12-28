public class MethodOverloadingChallenge {
    public static void main(String[] args) {
        System.out.println(convertToCentimeters(11));
        System.out.println(convertToCentimeters(5,11));
    }

    public static double convertToCentimeters(int heightInInches){
        return heightInInches * 2.54;
    }

    public static double convertToCentimeters(int heightInFeet, int heightInInches){
        int totalHeightInInches = (heightInFeet * 12) + heightInInches;
        return convertToCentimeters(totalHeightInInches);
    }
}