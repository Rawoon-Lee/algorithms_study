import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        //처음은 무조건 0
        list.add(sc.nextInt()+1);
        for (int i=2; i<=N; i++) {
            int loc = sc.nextInt();
            int idx = i-1;
            list.add(idx-loc, i);
        }
        for (int i=0; i<N; i++) {
            System.out.print(list.get(i)+" ");
        }
    }
}
