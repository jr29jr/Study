
import java.io.*;
import java.util.*;

class bae_1182_ad{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();
  static int N,S,ans;
  static int[] nums;  
  static void input() {
    N=scan.nextInt();
    S=scan.nextInt();
    nums=new int[N+1];
    for(int i=1;i<=N;i++){
      nums[i]=scan.nextInt();
    }
  }
   
  //만족한 경우
  //만족하지않은 경우
  //value는 num까지의 합
  static void rec_func(int num,int value ){
    if(num == N+1){
      if(value == S)
        ans++;
    } 
    else{
      rec_func(num+1,value+nums[num]);
      rec_func(num+1,value);        
    }
  }
  public static void main(String[] args) {
    input();
    rec_func(1,0);
    //합이 0일 경우와 공집합인 경우를 구분해야한다.
    //합이 0일 경우 공집합이 포함된거라 -1만 해주면 되는거였다.
    if(S==0)
      ans--;
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
