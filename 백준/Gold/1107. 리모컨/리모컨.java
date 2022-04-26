import java.util.Scanner;

public class Main {
    //리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다.
//+를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고,
//-를 누르면 -1된 채널로 이동한다.
//채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.
//수빈이가 지금 이동하려고 하는 채널은 N
//지금 보고 있는 채널은 100
//어떤 버튼이 고장났는지 주어졌을 때(하나도 고장나지 않을수도 있으며 이경우엔 3번째 줄 없음),
//채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지
//5457로 가기위해서 5455로 4변 누르고 플러스 ++누르니까 6번 누른 것이다.
    static int ans, channel, B;
    static String[] buttons;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        channel = sc.nextInt(); //가야되는 채널
        B = sc.nextInt(); //고장된 버튼의 수
        boolean[] nums = new boolean[10];
        //false 인 버트만 사용가능하다.
        if (B != 0) {
            for (int i=0; i<B; i++) {
                nums[sc.nextInt()] = true;
            }
        } //입력완료
        buttons = new String[10-B];
        int idx = 0;
        for (int i=0; i<10; i++) {
            if (!nums[i]) {
                buttons[idx++] = Integer.toString(i);
            }
        }
        int len = Integer.toString(channel).length();
        ans = Integer.MAX_VALUE;
        ans = Answer(len);
        System.out.println(ans);
    }
    public static int Answer(int len) {
        //갈려는 채널이 100이면 답은 무조건 0
        if (channel == 100) return 0;
        //고장난 버튼이 10개이면 +로만 이동해야 되니까 100과의 절대값
        int tmp = Math.abs(channel-100);
        if (B == 10) return tmp;
        perm(0, 0, len-1, "");
        perm(0, 0, len, "");
        perm(0, 0, len+1, "");
        return Math.min(tmp, ans);
    }
    //모든 조합을 만든 다음에 가장 작은 수를 구할 수 있지 않을까?
    public static void perm(int sidx, int cnt, int len, String num) {
        if (cnt >= ans) return;
        if (len == sidx) {
            //아무것도 더해지지 않았는데 뭘 계산해
            if (num.equals("")) return;
            else cnt += Math.abs(channel-Integer.parseInt(num));
            ans = Math.min(cnt, ans);
            return;
        }
        for (String b:buttons) {
            perm(sidx+1, cnt+1, len, num.concat(b));
        }
    }
}
