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
  static int stac,link;//스타크 1팀,링크 2팀
  //팀 숫자로 구분하자.
  static void calc(){
    int sum1=0,sum2=0;
    for(int i=1;i<=N;i++){
      for(int j=i+1;j<=N;j++){
        //자기자신은 뺀다.
        if(i == j)
          continue;
        //같은 팀인지 확인
        if(team[i]==team[j]){
          //스타크 팀
          if(team[i]==1){
            sum1+=stats[i][j]+stats[j][i];
          }
          //링크 팀
          else{
            sum2+=stats[i][j]+stats[j][i];
          }
        }
      }
    }
    min=Math.min(min,Math.abs(sum1-sum2));
  }
  static void rec_func(int k){
    if(k == N+1){
      if(stac == link){
        //여기서 계산하자
        calc();
      }
    }
    else{
      for(int i=1;i<=2;i++){
        if(i == 1){
          stac++;
        }
        else{
          link++;
        }
        team[k]=i;
        rec_func(k+1);
        team[k]=0;
        if(i == 1){
          stac--;
        }          
        else{
          link--;
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
