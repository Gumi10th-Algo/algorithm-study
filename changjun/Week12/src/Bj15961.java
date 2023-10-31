import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 회전 초밥.
// 투 포인터로 오른쪽으로 넓혀가다 중복되는 초밥을 만나면 왼쪽 포인터를 중복 이상으로 땡김 -> 문제 잘못 이해
// 현재 목록 중 쿠폰 초밥이 없을 시 +1
// 연속되어 먹는 k개가 존재하므로 항상 k개씩 탐색.
// 아.. 연속해서 먹는 k개 초밥 중 중복이 있어도 OK, 종류가 덜 할 뿐..................
// HashSet, LinkedList -> 시간초과
// 그냥 종류 카운트하는 배열. 갓 배열.
public class Bj15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수 N
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속 콤보 접시
        int c = Integer.parseInt(st.nextToken()); // 쿠폰

        int[] sushi = new int[N + k]; // 한 바퀴 돌고 k - 1 까지 체크해야 함.

        // N개 입력.
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        // 각 종류 초밥이 현재 몇 개인지 저장하는 배열 count
        int[] count = new int[d+1];
        int cnt = 0; // 종류 수
        int max = 0; // 가장 큰 종류.

        // 초기 k개 입력 겸. 한 바퀴 돈 상태 체크 위해 k개 추가.
        for (int i = 0; i < k; i++) {
            // 현재 해당 종류 초밥 추가하면서 만약 0개 였다면 종류 + 1
            if(count[sushi[i]]++ == 0){
                cnt++;
            }
            sushi[N + i] = sushi[i]; // 한 바퀴 돈 스시 입력.
        }

        for (int i = k; i < N + k; i++) {
            // 종류 수가 최고보다 같거나 크면 체크해서 갱신.
            if(cnt>=max){
                // 핸재 쿠폰초밥이 없으면 +1 있으면 그대로
                if(count[c] == 0){
                    max = cnt+1;
                } else {
                    max = cnt;
                }
                // 나올 수 있는 최대값이 나오면 종료.
                if(max == k+1){
                    break;
                }
            }
            // 이번 초밥이 새 종류이면 종류 + 1
            if (count[sushi[i]]++ == 0) {
                cnt++;
            }
            // 사라지는 초밥이 1개였다면 종류 - 1
            if(count[sushi[i-k]]-- == 1){
                cnt--;
            }
        }
        System.out.println(max);
    }
}