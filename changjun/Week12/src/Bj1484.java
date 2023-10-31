import java.io.*;
import java.util.*;
// 다이어트

// 투포인터?
// a+b  a-b..
public class Bj1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int G = Integer.parseInt(st.nextToken());
        ArrayList<Integer> l = new ArrayList();

        // G = a^2 - b^2
        //   = (a+b) * (a-b)
        for(int i=1 ;i<Math.sqrt(G);i++){
            if(G%i!=0) continue; // 안 나눠지면 continue

            int j = G / i;
            if((i+j)%2!=0) continue; // i+j가 홀수면 a가 자연수가 안 나온다.

            l.add((i + j) / 2); // a 넣기.
        }

        Collections.sort(l);

        for(int n:l){
            sb.append(n+"\n");
        }

        if(l.isEmpty()) sb.append(-1);
        System.out.println(sb);
    }
}
