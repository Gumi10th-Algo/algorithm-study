import java.io.*;
import java.util.*;
// 계단 오르기
// 연속 1회 배열, 연속 2회 배열 두 개를 만들어 각각 상향식 기록.
public class Bj2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] str = new int[N+3];
        int[] One = new int[N+3];
        int[] Two = new int[N+3];

        for(int i=1;i<=N;i++){
            str[i] = Integer.parseInt(br.readLine());
        }

        One[1] = str[1];
        One[2] = str[2];

        for(int f=1;f<=N;f++){
            if(One[f] + str[f+1] > Two[f+1]) Two[f+1] = One[f] + str[f+1];
            if(One[f] + str[f+2] > One[f+2]) One[f+2] = One[f] + str[f+2];
            if(Two[f] + str[f+2] > One[f+2]) One[f+2] = Two[f] + str[f+2];
        }

        System.out.println(One[N] > Two[N] ? One[N] : Two[N]);
    }
}

// 한 계단 또는 두 계단
// 연속된 3개의 계단을 밟으면 안 된다. 최대 2개까지. 그렇다면
// n번째 계단을 가는 방법은. n-3 n-2 n