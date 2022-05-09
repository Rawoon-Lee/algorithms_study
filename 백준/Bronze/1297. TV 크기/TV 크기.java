import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        double pow = Math.pow(c, 2) / (Math.pow(a, 2) + Math.pow(b, 2));
        double sqrt = Math.sqrt(pow);
        System.out.println((int) (sqrt * a)+" "+(int)(sqrt * b));
    }
}
