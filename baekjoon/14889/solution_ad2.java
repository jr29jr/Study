import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] check,ans;
    static int[][] stats;
    static int min=Integer.MAX_VALUE;
    static void input() {
        N=scan.nextInt();
        stats=new int[N+1][N+1];
        check=new int[N+1];//스타트 팀인지 확인
        ans=new int[N/2+1];
        for(int i=1;i<=N;i++)
            for(int j=1;j<=N;j++)
                stats[i][j]=scan.nextInt();
    }
    //스타트와 링크의 stats합의 차를 계싼
    static int calcStats(){
        int linkS=0,startS=0;//링크와 스타트의 스테이터스 합
        for(int i=1;i<=N;i++){
            for(int j=i+1;j<=N;j++){
                if(check[i] == check[j]){
                    //스타트 팀
                    if(check[i]==1){
                        startS+=stats[i][j]+stats[j][i];
                    }
                    //링크팀
                    else{
                        linkS+=stats[i][j]+stats[j][i];
                    }
                }
            }
        }
        return Math.abs(startS-linkS);
    }
    //10명 뽑으면 만족
    //k가 N/2번째 선수까지 뽑아야한다.
    static void rec_func(int k){
        if(k == N/2+1){
            //10명뽑은 경우
            min=Math.min(min,calcStats());
        }
        else{
            //ans[k]는 0이잖아.. 이전방으로 가야지..
            for(int i=ans[k]+1;i<=N;i++){
                if(check[i]==0){
                    check[i]=1;
                    ans[k]=i;
                    rec_func(k+1);
                    ans[k]=0;
                    check[i]=0;
                }
            }
        }

    }
    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(min);
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
