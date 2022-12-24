public class Main {
    public static void main(String[] args) {

        int score1 = 8000;
        if(score1 <= 10000 && score1 > 8000){
            System.out.println("high score");
        }else if(score1 > 6000){
            System.out.println("Not too bad");
        }else if(score1 > 2000){
            System.out.println("Low score");
        }else{
            System.out.println("Invalid score");
        }

        int highScore = calculateScore(true, 800, 5, 100);
        System.out.println("The high score is " + highScore);

        System.out.println("The next high score is " + calculateScore(true, 10000, 8, 200));

    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus){
        int finalScore = score;
        if(gameOver) {
            finalScore += (levelCompleted * bonus);
        }
        return finalScore;
    }
}
