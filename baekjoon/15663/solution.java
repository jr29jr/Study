import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();
  static int N,M;
  static int[] nums;
  static int[] ans,check;
  
  static void input() {
    N=scan.nextInt();
    M=scan.nextInt();
    nums=new int[N+1];
    check=new int[N+1];
    ans=new int[M+1];
    for(int i=1;i<=N;i++){
      nums[i]=scan.nextInt();
    }
    Arrays.sort(nums);
  }
   
  //
  static void rec_func(int cand){
    if(cand == M+1){
      
      //만족한 경우
      for(int i=1;i<=M;i++){
        sb.append(ans[i]).append(' ');
      }
      sb.append('\n');
    }
    else{
      int last_num=0;
      for(int i=1;i<=N;i++){
        if(check[i]== 1)
          continue;
        if(last_num == nums[i])
          continue;
        //마지막에 썻던 후보랑 비교
        last_num=nums[i];
        ans[cand]=nums[i];
        check[i]=1;
        rec_func(cand+1);
        ans[cand]=0;
        check[i]=0;
      }
    }
  }
  public static void main(String[] args) {
    input();
    rec_func(1);
    System.out.println(sb.toString());
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
