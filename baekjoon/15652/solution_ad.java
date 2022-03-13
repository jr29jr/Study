import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();

  static void input() {
      FastReader scan = new FastReader();
      N = scan.nextInt();
      M = scan.nextInt();
      selected = new int[M + 1];
  }

  static int N, M;
  static int[] selected;
  
  public static void main(String[] args) {
    input();

    rec_func(1);
    System.out.println(sb.toString());
  }
  //만족한 경우
  //M개를 고른 경우
  //만족하지않은 경우
  //k번째부터 M번째까지 원소를 고르는 경우,중복 가능
  //전달인자로 줄게 아니라 배열이니 앞방에 접근이 가능하다.그걸 이용해서 개선하자.
  static void rec_func(int k){
      if(k == M+1){
        for(int i=1;i<=M;i++){
          sb.append(selected[i]).append(' ');
        }
        sb.append('\n'); 
      }
      else{
        //1번방부터라 out of index가 안나고 0번방 가리킨다.
        int start=selected[k-1];
        if(start == 0)
          start=1;
        for(int i=start;i<=N;i++){
          selected[k]=i;
          rec_func(k+1);
          selected[k]=0;
        }
      }    
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
