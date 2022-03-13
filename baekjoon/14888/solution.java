import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();

  static void input() {
      FastReader scan = new FastReader();
      N = scan.nextInt();
      inputArray=new int[N+1];
      oper=new int[N];//연산자 배열
      for(int i=1;i<=N;i++){
        inputArray[i]=scan.nextInt();
      }
      operCnt=new int[5];//연산자 개수 저장
      for(int i=1;i<5;i++){
        operCnt[i]=scan.nextInt();
      }    
  }

  static int N,maxN=Integer.MIN_VALUE,minN=Integer.MAX_VALUE;
  static int[] inputArray,oper,operCnt;
  static int calc(){
    int num=inputArray[1];
    for(int i=1;i<=N-1;i++){
      if(oper[i]==1){
        num+=inputArray[i+1];
      }
      else if(oper[i]==2){
        num-=inputArray[i+1];
      }
      else if(oper[i]==3){
        num*=inputArray[i+1];
      }
      else{
        num/=inputArray[i+1];
      }
    }
    return num;
  }
  
  public static void main(String[] args) {
    input();
    rec_func(1);
    System.out.println(maxN+"\n"+minN);
    
  }
  //만족한 경우
  //M개를 고른 경우
  //만족하지않은 경우
  //k번째부터 M번째까지 원소를 고르는 경우,중복 가능
  static void rec_func(int k){
      if(k == N){
        int num=calc();
        if( num<minN)
          minN=num;
        if( num>maxN)
          maxN= num;
      }
      else{
        for(int i=1;i<=4;i++){
          if(operCnt[i]>0){
            oper[k]=i;
            operCnt[i]--;
            rec_func(k+1);
            oper[k]=0;
            operCnt[i]++;
          }
          
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
