public class SecondsMinutesChallenge {
    public static void main(String[] args) {
        System.out.println(getDurationString(-3945));
        System.out.println(getDurationString(-65,45));
        System.out.println(getDurationString(65,145));
    }

    public static String getDurationString(int seconds){
        if(seconds < 0){
            return "Error: Seconds should be greater than or equal to 0";
        }

        return getDurationString(seconds / 60, seconds % 60);
    }

    public static String getDurationString(int minutes, int seconds){
        if(minutes < 0 || seconds < 0 || seconds > 59){
            return "Error! Minutes should be greater than 0 and seconds should be equal to or in between 0 and 60";
        }

        int hours = minutes / 60;
        int remMinutes = minutes % 60;

        return hours + "h " + remMinutes + "m " + seconds + "s";
    }
}