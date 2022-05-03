import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }
        int ans = 0;
        Map<Character, Integer> index = new HashMap<>();
        for (int i=0; i<words[0].length(); i++) {
            index.put(words[0].charAt(i), index.getOrDefault(words[0].charAt(i), 0)+1);
        }

        for (int i=1; i<N; i++) {
            if (Math.abs(words[0].length()-words[i].length()) > 1) continue ;
            Map<Character, Integer> tmp = new HashMap<>();
            for (int j=0; j<words[i].length(); j++) {
                char letter = words[i].charAt(j);
                tmp.put(letter, tmp.getOrDefault(letter, 0)+1);
            }
            int diff = 0;
            int same = 0;
            for (Character key:index.keySet()) {
                if (!tmp.containsKey(key)) {
                    diff+=index.get(key);
                }
                else {
                    int num = Math.abs(index.get(key) - tmp.get(key));
                    if (num == 0) same+=num;
                    else diff+=num;
                    tmp.remove(key);
                }
            }
            for (Character key:tmp.keySet()) {
                diff+=tmp.get(key);
            }
            if (words[0].length() == words[i].length()) {
                if (diff <= 2) ans++;
            }
            else {
                if (diff <= 1) ans++;
            }
        }
        System.out.println(ans);
    }
}