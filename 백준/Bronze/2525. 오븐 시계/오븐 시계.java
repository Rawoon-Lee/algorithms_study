import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int time = sc.nextInt();
        if (min + time < 60) {
            System.out.println(hour + " " + (min+time));
        } else {
            hour += (min + time) / 60;
            hour %= 24;
            System.out.println(hour + " " + ((min + time) % 60));
        }
    }
}
