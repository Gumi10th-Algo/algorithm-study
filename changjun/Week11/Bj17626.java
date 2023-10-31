import java.io.*;
import java.util.*;

// Four Squares
// 라그랑주의 네제곱 수 정리
// 하향식. 이게 DP지

public class Bj17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] dp = new int[N+1];
        dp[1] = 1;

        for(int i=2;i<=N;i++){
            int min = i;
            for(int j=1;j*j<=i;j++){
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = dp[min]+1;
        }

        System.out.println(dp[N]);
    }
}
