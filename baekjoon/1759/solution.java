import java.io.*;
import java.util.*;

class Main{
  static StringBuilder sb = new StringBuilder();
  static FastReader scan = new FastReader();

  static int L,C;
  static char[] alp,ans;
  static int selectCnt;//선택한 개수
  static int[] check;//선택한거 확인
  static void input() {
    L=scan.nextInt();
    C=scan.nextInt();
    ans=new char[C+1];
    alp=new char[C+1];
    for(int i=1;i<=C;i++){
      alp[i]=scan.next().charAt(0);
    }
    Arrays.sort(alp);
  }
  static boolean isVowel(char ch){
    if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
      return true;
    else
      return false;
  }
  static boolean vaildCheck(char[] str){
    int vowelCnt=0,consonantCnt=0;
    for(int i=1;i<=L;i++){
      if(isVowel(str[i])){
        vowelCnt++;
      }
      else{
        consonantCnt++;  
      }
    }

    if(vowelCnt >=1 && consonantCnt >=2)
      return true;
    else
      return false;
  }
  //만족하는 경우
  //문자열 4개를 넣는 경우
  //num이전까지 포함한 수
  static void rec_func(int num,int count){
    if(num == C+1){
      //L인 경우다 ㅋㅋ
      if(count == L){
        if(vaildCheck(ans)){
           //문자열을 정렬해서 sb에 출력
          for(int i=1;i<=L;i++){
            sb.append(ans[i]);
          }
          sb.append('\n');
        }
      }
    }
    else{
      //더 느려지네?..
      if(count<L){
        ans[count+1]=alp[num];
        rec_func(num+1,count+1); //들어간경우         
        ans[count+1]=0;
      }
      if(count <=L)
        rec_func(num+1,count);//안들어간경우
    }  
  }
  
  public static void main(String[] args) {
    input();
    rec_func(1,0);
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
