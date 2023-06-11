public class MinutesToYearsDaysCalculator {
    public static void main(String[] args) {
        printYearsAndDays(525600);
        printYearsAndDays(1051200);
        printYearsAndDays(561600);
    }

    public static void printYearsAndDays(long minutes){
        if(minutes < 0){
            System.out.println("Invalid Value");
            return;
        }

        long days = (minutes / 60) / 24;

        System.out.println(minutes + " min = " + (days / 365) + " y and " + (days % 365) + " d");
    }
}