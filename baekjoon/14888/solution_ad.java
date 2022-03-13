import java.io.*;
import java.util.*;

//변수명 변경,라이브러리 사용
class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();
  
  static void input() {
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
      max=Integer.MIN_VALUE;
      min=Integer.MAX_VALUE;
  }

  static int N,max,min;
  static int[] inputArray,oper,operCnt;
  static int calc(int operand1,int operator,int operand2){

    if (operator == 1)// +
      return operand1 + operand2;
    else if (operator == 2)// -
      return operand1 - operand2;
    else if (operator == 3)// *
      return operand1 * operand2;
    else // /
      return operand1 / operand2;
  }
  
  public static void main(String[] args) {
    input();
    rec_func(1,inputArray[1]);
    sb.append(max).append('\n').append(min);
    System.out.println(sb.toString());
  }
  //만족한 경우
  //M개를 고른 경우
  //만족하지않은 경우
  //k번째부터 M번째까지 원소를 고르는 경우,중복 가능
  //k번까지의 연산 결과를 value에 저장.
  static void rec_func(int k,int value){
      if(k == N){
        min=Math.min(min,value);
        max=Math.max(max,value);
      }
      else{
        for(int i=1;i<=4;i++){
          if(operCnt[i]>0){
            operCnt[i]--;
            //value를 안주고 이번방을..
            rec_func(k+1,calc(value,i,inputArray[k+1]));
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
