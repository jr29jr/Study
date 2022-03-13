import java.io.*;
import java.util.*;


class Main{
  static int money;
  static int[] costs;
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();
  
  static void input() {
    money=scan.nextInt();
    costs=new int[7];
    for(int i=0;i<=5;i++)
      costs[i]=scan.nextInt();  
  }
  
  public static void main(String[] args) {
    input();
    int answer=new Solution().solution(money,costs);
    System.out.println(answer);
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
