import java.io.*;
import java.util.*;
// 동전 1

// 원 마다 종류를 집어 넣는 게 아니라
// 종류마다 한 번 씩 돌기.
// coin(n-1,k) -> coin(n,k)
public class Bj2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 동전 종류
        int K = Integer.parseInt(st.nextToken()); // 구하려는 액수.
        int[] coin = new int[N+1];
        int[] dp = new int[K+1];

        // 입력
        for(int i=0;i<N;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 초기값 입력.
        dp[0] = 1;

        // 동전 종류 마다 한 번씩 순환
        for(int i=0;i<N;i++){
            // 동전 액수 만큼 뒤로 가서 더해준다.
            for(int j=coin[i];j<=K;j++){
                dp[j] += dp[j-coin[i]];
            }
        }

        System.out.println(dp[K]);
    }
}
