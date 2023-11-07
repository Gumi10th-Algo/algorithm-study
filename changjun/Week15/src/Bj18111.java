import java.io.*;
import java.util.*;
// 마인크래프트

// 높이가 256 밖에 안되니 이걸 기준으로 줄 세우기
public class Bj18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 높이별 개수 배열
        int[] blocks = new int[257];
        int cnt = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int n = Integer.parseInt(st.nextToken());
                blocks[n]++;
                cnt+=n;
            }
        }

        // 최대 높이, 최소 높이
        int high = 256;
        int min = 0;
        while(blocks[high]==0) high--;
        while(blocks[min]==0) min++;

        int minTime = Integer.MAX_VALUE;
        int ground = -1;

        for(int i=high;i>=min;i--){
            // 총 블록이 모자라면 컨티뉴.
            if(cnt+B < i*M*N ) continue;

            int time = 0;

            // 목표 높이 보다 작은 거 계산
            for(int j=0;j<i;j++){
                time+=(i-j) * blocks[j];
            }

            // 목표 높이 보다 큰 거 계산
            for(int j=i+1;j<=256;j++){
                time+=2 * (j-i) * blocks[j];
            }

            // 시간 갱신
            if(time < minTime){
                minTime = time;
                ground = i;
            }
        }

        System.out.println(minTime+" "+ground);
    }
}
