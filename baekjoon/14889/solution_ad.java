import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();

  static int N,min=Integer.MAX_VALUE;
  static int[][] stats;
  static int[] team;
  static void input() {
    N=scan.nextInt();
    stats=new int[N+1][N+1];
    team=new int[N+1];
    for(int i=1;i<=N;i++){
      for(int j=1;j<=N;j++){
        stats[i][j]=scan.nextInt();
      }  
    }
  }
  //팀 숫자로 구분하자.
  static void calc(){
    int sum1=0,sum2=0;
    for(int i=1;i<=N;i++){
      for(int j=i+1;j<=N;j++){
        if(team[i]==team[j]){
          if(team[i]==1)
            sum1+=stats[i][j]+stats[j][i];
          else
            sum2+=stats[i][j]+stats[j][i];
        }
      }
    }
    min=Math.min(min,Math.abs(sum1-sum2));
  }
  
  static void rec_func(int k,int memeberCnt){
    if(k == N+1){
      if(memeberCnt == N/2){
        calc();
      }
    }
    else{
      team[k]=1;
      rec_func(k+1,memeberCnt+1);
      team[k]=0;
      rec_func(k+1,memeberCnt);
    }
    
    
  }
  
  public static void main(String[] args) {
    input();
    rec_func(1,0);
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
