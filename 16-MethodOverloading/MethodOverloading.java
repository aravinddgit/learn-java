public class Main{
    public static void main(String[] args) {
        System.out.println("Method 1: " + calculateScore("Aravind", 500));
        System.out.println("Overloading 1: " + calculateScore(500));
        System.out.println("Overloading 2: " + calculateScore());

        // Note: Overloading is the method of changing a method signature to denote different functions with the same name.
        // Method signature constitutes the number of arguments, the order of the arguments, the type of arguments. However, it does not constitute the return type.

        //Overloading with default arguments
        System.out.println("Method 2: " + calculateScore1("Adam",600));
        System.out.println("Method 2 overloading with default arguments: " + calculateScore1(100));

    }

    // Method 1
    public static int calculateScore(String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " score points");
        return score * 1000;
    }

    //Overloading method 1
    public static int calculateScore(int score){
        System.out.println("Player X" + " scored " + score + " score points");
        return score  * 10;
    }

    //Overloading method 2
    public static int calculateScore(){
        System.out.println("Player X scored some points");
        return 999;
    }

    // Different return type - Invalid Method overloading
//    public static void calculateScore(){
//        System.out.println("Player X scored some points");
//    }


    //  Java does not support passing default values for arguments
    //    But there is a way to bypass this!
    // Method 2
    public static int calculateScore1(String playerName, int score){
        System.out.println("Player " + playerName + " scored " + score + " score points");
        return score * 1000;
    }

    //Overloading method 2
    public static int calculateScore1(int score){
        return calculateScore1("Anonymous", score);
    }

}