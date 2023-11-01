import java.util.*;
import java.io.*;

public class Bj22942{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> list = new ArrayList<>();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            list.add(new int[]{x-r, x+r});
        }
        list.sort((n1, n2)->{
            if(n1 == n2){
                return n2[1] - n1[1];
            }
            return n1[0] - n2[0];
        });

        boolean flag = false;

        for(int i=0; i<list.size()-1; i++){
            if(list.get(i)[1] >= list.get(i+1)[0] && list.get(i)[1] <= list.get(i+1)[1]){
                flag = true;
                break;
            }
        }

        if(flag)
            System.out.println("NO");
        else
            System.out.println("YES");
    }

}