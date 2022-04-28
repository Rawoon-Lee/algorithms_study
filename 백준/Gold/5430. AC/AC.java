import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너
        Scanner sc = new Scanner(System.in);
        //스트링빌더
        StringBuilder sb = new StringBuilder();
        //테케
        int T = sc.nextInt();
        //for (테케)
        tc: for (int t=0; t<T; t++) {
            //String order
            String order = sc.next();
            //int N
            int N = sc.nextInt();
            if (N == 0) {
                if (order.contains("D")) sb.append("error\n");
                else sb.append("[]\n");
                sc.next();
                continue;
            }
            //String[] tmp.split("[[,]]")
            String str = sc.next();
            String[] tmp = str.substring(1, str.length()-1).split(",");
            //List<스트링> 초기화
            List<String> list = new ArrayList<>(Arrays.asList(tmp));
            //입력끝

            //방향을 알려주는 변수 초기화
            //boolean isSeq = true; 순서대로
            boolean isSeq = true;
            //order 용 idx = 0
            int idx = 0;
            //while(idx < N)
            while(idx < order.length()) {
                //char act = order[idx]
                char act = order.charAt(idx);
                //switch
                switch (act) {
                    case 'R':
                        //isSeq = !isSeq
                        isSeq = !isSeq;
                        break;
                    case 'D':
                        //if (true) - 0번째 삭제
                        try {
                            if (isSeq) list.remove(0);
                            else list.remove(list.size()-1);
                        } catch (IndexOutOfBoundsException e) {
                            sb.append("error\n");
                            continue tc;
                        }
                        break;
                }
                idx++;
            }
            sb.append("[");
            int len = list.size();
            for (int i=0; i<len; i++) {
                if (isSeq) sb.append(list.get(i)).append(",");
                else sb.append(list.get(len-1-i)).append(",");
            }
            if (sb.charAt(sb.length()-1) == ',') sb.setLength(sb.length()-1);
            sb.append("]\n");
        }
        System.out.println(sb.toString());
    }
}
