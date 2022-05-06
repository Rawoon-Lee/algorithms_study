import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T = sc.nextInt();
        for (int t =0; t<T; t++) {
            int N = sc.nextInt();

            Map<String, Integer> clothes = new HashMap<>();
            for (int i=0; i<N; i++) {
                sc.next();
                String kind = sc.next();
                clothes.put(kind, clothes.getOrDefault(kind, 0)+1);
            } //입력끝

            //옷의 종류
            int R = clothes.size();
            int ans = 1;
            for (String key: clothes.keySet()) {
                ans *= clothes.get(key) + 1;
            }
            sb.append(ans-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}