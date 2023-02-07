package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1541
 {

    public static void main(String[] args) {
        process();
    }   
    

    static void process(){
        FastReader fr=new FastReader();
        int sum=0;
        boolean canMinus=false;//이전에 -부호가 나왔으면 음수로 변경이 가능
        //처음 숫자는 양수라 더한다,
        sum+=fr.nextInt();
        //토큰이 남아있을때까지 한다.
        while(fr.st.hasMoreTokens()){
            //토큰이 +,1일 경우 
            //토큰을 한개 꺼내서 연산한다.
            String nextString=fr.next();
            //+ 일경우
            if(nextString.equals("+")){
                //숫자를 꺼낸다
                int temp=fr.nextInt();
                //음수로 바꿀 수 있나 확인
                if(canMinus){
                    sum-=temp;
                }
                else{
                    sum+=temp;
                }
            }
            //-일 경우
            else if(nextString.equals("-")){
                //숫자를 꺼낸다
                int temp=fr.nextInt();
                //빼준다
                sum-=temp;
                //뒤에 나오는 숫자를 음수로 변환이 가능하다.
                canMinus=true;
            }
        }
        //결과 출력
        System.out.println(sum);
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
                    st = new StringTokenizer(br.readLine(),"+-",true);
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

