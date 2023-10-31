import java.io.*;
import java.util.*;

public class Bj9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if(N%2==1) System.out.println("SK");
        else System.out.println("CY");

    }
}
