import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int n,m;
    static int[] numbersA,numbersB,rowMins;
    static int[][] andAry;
    static int max=Integer.MIN_VALUE;

    static void input() {
        n=scan.nextInt();
        m=scan.nextInt();
        numbersA=new int[n+1];
        numbersB=new int[m+1];
        for(int i=1;i<=n;i++)
            numbersA[i]=scan.nextInt();
        for(int i=1;i<=m;i++)
            numbersB[i]=scan.nextInt();

        andAry=new int[n+1][m+1];
        rowMins=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                andAry[i][j]=numbersA[i]&numbersB[j];
            }
        }
    }

    //
    static int solve(){
        for(int i=0;i<=512;i++){
            if(calcMin(i))
                return i;
        }
        return -1;
    }
    static boolean calcMin(int target){
        for(int i=1;i<=n;i++){
            boolean has=false;
            for(int j=1;j<=m;j++){
                if((target | andAry[i][j]) == target){
                    has=true;
                }
                if(has == true)
                    break;
            }
            if( has == false)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        input();
        int ans=solve();
        System.out.println(ans);
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
