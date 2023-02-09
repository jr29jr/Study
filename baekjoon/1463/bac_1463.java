package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1463 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int[] result;//index번째 숫자의 결과를 저장
    static int X;//1로 만들 숫자
    static void input(){
        FastReader fr=new FastReader();
        X=fr.nextInt();
    }

    static void process(){
        result=new int[X+1];

        //값이 저장 안된곳은 -1
        for(int i=0;i<=X;i++)
            result[i]=-1;

        //1~3은 초기화해두자.
        result[1]=0;
        System.out.println(dp(X));
    }
    static int dp(int number){
        //3으로 나눈값,2로 나눈값,-1에서 접근한 횟수를 저장 
        int numDivideThree=Integer.MAX_VALUE,numDivideTwo=Integer.MAX_VALUE,numMinueOne=Integer.MAX_VALUE;

        if(result[number] != -1)
            return result[number];
        
        if(number%3 == 0)
            numDivideThree=dp(number/3);
        
        if(number%2 == 0)
            numDivideTwo=dp(number/2);
        numMinueOne=dp(number-1);
        int min=Math.min(Math.min(numDivideThree,numDivideTwo),numMinueOne)+1;
        result[number]=min;
        return min;
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

