import java.io.*;
import java.math.BigInteger;
import java.util.*;
// 조합
// nCm = n-1Cm-1 + n-1Cm
// BigInteger 사용
public class Bj2407 {
    static BigInteger[][] coef;
    static BigInteger nCm(int n,int m){
        if(coef[n][m]!=BigInteger.valueOf(0)) return coef[n][m];
        if(m==0 || n==m)
            return coef[n][m] = BigInteger.valueOf(1);

        return coef[n][m] = nCm(n-1,m-1).add(nCm(n-1,m));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        coef = new BigInteger[N+1][M+1];

        for(int i=0;i<=N;i++){
            for(int j=0;j<=M;j++){
                coef[i][j] = BigInteger.valueOf(0);
            }
        }

        System.out.println(nCm(N,M));

    }
}
