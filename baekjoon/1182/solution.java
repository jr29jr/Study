import java.io.*;
import java.util.*;

class bae_1182{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();
  static int N,S,ans,size;
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
      if(value == S && size >=1)
        ans++;
    } 
    else{
      size++;
      rec_func(num+1,value+nums[num]);
      size--;
      rec_func(num+1,value);        
    }
  }
  public static void main(String[] args) {
    input();
    rec_func(1,0);
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
