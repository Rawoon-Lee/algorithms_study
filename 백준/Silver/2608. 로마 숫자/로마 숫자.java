import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //map을 써서 해당 숫자를 해석하면 될것 같다.
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int sum = 0;
        for (int i=1; i<A.length(); i++) {
            if (map.get(A.charAt(i-1)) < map.get(A.charAt(i))) {
                sum -= map.get(A.charAt(i-1));
                continue;
            }
            sum += map.get(A.charAt(i-1));
        }
        sum += map.get(A.charAt(A.length()-1));

        for (int i=1; i<B.length(); i++) {
            if (map.get(B.charAt(i-1)) < map.get(B.charAt(i))) {
                sum -= map.get(B.charAt(i-1));
                continue;
            }
            sum += map.get(B.charAt(i-1));
        }
        sum += map.get(B.charAt(B.length()-1));

        //우와 아라비아를 로마자로 바꾸는건 최큼 골 아픈디?
        //모든 글자를 하나하나 나눠서 1~9까지 표현하고 (0은 건너뛰고)
        //해당 위치의 크기에 맞게 곱해서 그 문자를 넣어주면 되네!!
        String num = Integer.toString(sum);
        int idx = num.length() - 1;
        StringBuilder sb = new StringBuilder();
        for (int s=0; s<num.length(); s++) {
            String tmp = "";
            switch (num.charAt(s)) {
                case '1':
                    tmp = "I";
                    break;
                case '2':
                    tmp = "II";
                    break;
                case '3':
                    tmp = "III";
                    break;
                case '4':
                    tmp = "IV";
                    break;
                case '5':
                    tmp = "V";
                    break;
                case '6':
                    tmp = "VI";
                    break;
                case '7':
                    tmp = "VII";
                    break;
                case '8':
                    tmp = "VIII";
                    break;
                case '9':
                    tmp = "IX";
                    break;
                default:
                    break;
            }
            for (int t=0; t<tmp.length(); t++) {
                int n = map.get(tmp.charAt(t));
                n *= (int) Math.pow(10, idx);
                for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                    Character c = entry.getKey();
                    Integer i = entry.getValue();
                    if (i == n) {
                        sb.append(c);
                        break;
                    }
                }
            }
            idx--;
        }
        System.out.println(num);
        System.out.println(sb.toString());
    }
}
