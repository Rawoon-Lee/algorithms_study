import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int price = sc.nextInt();
        int num = sc.nextInt();
        int money = sc.nextInt();
        int total = price * num;
        if (total - money > 0) System.out.println(total-money);
        else System.out.println(0);
    }
}
