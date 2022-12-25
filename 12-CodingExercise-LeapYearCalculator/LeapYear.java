public class LeapYear {
    public static void main(String[] args) {
        System.out.println(isLeapYear(-1600));
        System.out.println(isLeapYear(1600));
        System.out.println(isLeapYear(2017));
        System.out.println(isLeapYear(2000));
    }

    public static boolean isLeapYear(int year){
        if(year < 1 || year > 9999) return false;
        boolean isLeap = false;
        if((year % 4) == 0){
            if((year % 100) == 0){
                if((year % 400) == 0){
                    isLeap = true;
                }
            }else{
                isLeap = true;
            }
        }
        return isLeap;
    }
}