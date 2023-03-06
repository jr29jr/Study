package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1929 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int startNumber,endNumber;
    static void input(){
        FastReader fr=new FastReader();
        startNumber=fr.nextInt();
        endNumber=fr.nextInt();
    }
    static int MAX_SIZE=1000000;
    static void process(){
        //확인안했으면 -1,소수면 자기자신 저장
        int[] valicDecimal=new int[MAX_SIZE+1];
        for(int i=0;i<valicDecimal.length;i++)
            valicDecimal[i]=-1;
        calcDecimal(valicDecimal);
        printDecimal(valicDecimal,startNumber,endNumber);
    }
    static void printDecimal(int[] valicDecimal,int startNumber,int endNumber){
        StringBuilder sb=new StringBuilder();
        for(int i=startNumber;i<=endNumber;i++){
            if(valicDecimal[i] == i)
                sb.append(i).append('\n');
        }
        System.out.println(sb.toString());
    }    
    //소수 체크 함수를 만들어서 숫자마다 한다?..

    /**
     * index번째 숫자가 소수인지 확인하는 함수
     */
    static void calcDecimal(int[] check){
        //1은 소수가 아니다.
        check[1]=0;
        //2부터 확인한다.
        for(int i=2;i<check.length;i++){
            //확인 안했을 경우
            if(check[i] == -1 ){
                check[i]=i;
                //자기 배수들 처리
                for(int j=i;j<check.length;j+=i){
                    check[j]=i;
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
