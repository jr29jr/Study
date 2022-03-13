import java.io.*;
import java.util.*;
//대각선에 대한 정리를 제대로 해두자.이건 두고두고 쓰고 맨날 까먹는다.
public class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();
  static int N;
  static int[] col;
  static int count;
  static void input() {
    N = scan.nextInt();
    col=new int[N+1];
    count=0;
  }
  static boolean attackable(int row1,int col1,int row2,int col2){
    if(col1 == col2)return true;
    if(row1+col1 == row2+col2)return true;
    if(row1-col1 == row2-col2)return true;
    return false;
  }
  //체스를 놓을 수 있나 확인.
  static boolean check(int r,int c){
    for(int i=1;i<r;i++){
      if(attackable(r,c,i,col[i]))
        return false;
    }
    return true;
  }
   //체스를 N개 놓은경우
  //n개 놓기전까지 반복
  static void rec_func(int row){
    if(row== N+1){
      count++;
    }
    for(int i=1;i<=N;i++){
      if(check(row,i)){
        col[row]=i;
        rec_func(row+1);
        col[row]=0;
      }
    }
  }
  public static void main(String[] args) {
    input();
    rec_func(1);
    sb.append(count);
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
