 public class Main {
    public static void main(String[] args) {
        // a mile is equal to 1.609344 kilometers
        double kilometers = (100 * 1.609344);
        int highScore = 50;

        if(highScore == 50) {
            System.out.println("This is an expression");

        }


        // In the following code that I will type below, write down what parts of the code
        // are expressions.
        int score = 100; // exp1
        if (score > 99 && score < 1000) { // exp 2,3,4
             System.out.println("You got the high score");
            score = 0; // exp 5
            int test = score + score; //exp 6 (addition), exp 7 (assignment)
        }

        //There are 7 expressions here


        System.out.println("This is"
                            + " another" +
                            " still more");


        // The following is correct syntax but not recommended
        int               myVariable
                  =
                  5
                ;

        // IntelliJ - auto code formatting :
        // Code -> Reformat Code
        int test = 4; double tot = 100.0; System.out.println("Just testing the formatting");

        // After IntelliJ auto code formatting
        int test1 = 4;
        double tot1 = 100.0;
        System.out.println("Just testing the formatting");
    }
}
