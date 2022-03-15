import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();

  static int N,K,min;
  static int[] coins;
  static void input() {
    N=scan.nextInt();
    K=scan.nextInt();
    coins=new int[N+1];
    for(int i=1;i<=N;i++){
      coins[i]=scan.nextInt();
    }
  }
   

  static void rec_func(int money,int coinCnt,int k){
    if(money == 0 )
      min=coinCnt;
    //해당하는 돈을 만들수 없는 경우(문제에 없는 조건이라 생략)
    else{
      rec_func(money%coins[k],coinCnt+money/coins[k],k-1);    
    }
    
  }
  public static void main(String[] args) {
    input();
    //가진돈,동전의 개수,동전의 시작지점
    rec_func(K,0,N);
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
