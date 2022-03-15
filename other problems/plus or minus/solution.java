import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();

  static String S;
  static int size;
  static int[] numbers;
  static int min;
  static void input() {
    S=scan.nextLine();
    size=S.length();
    numbers=new int[size+1];
    for(int i=1;i<=size;i++){
      numbers[i]=S.charAt(i-1)-'0';
    }
  }
  
  //k 버째를 연산한다
  //피연산자 2개다 0과 1이 아닐 경우 곱연산
  static void rec_func(int k,int value){
    if(k == size+1){
      min=value;
    }
    else{
      if(value == 0){
        rec_func(k+1,value+numbers[k]);
      }
      else{
        if(numbers[k] == 1 || numbers[k] == 0){
          rec_func(k+1,value+numbers[k]);
        }
        else{
          rec_func(k+1,value*numbers[k]);
        }
      }      
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
