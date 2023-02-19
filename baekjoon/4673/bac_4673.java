package backjoon;

import java.io.*;
import java.util.*; 

public class bac_4673 {

    public static void main(String[] args) {
        process();
    }
    static int MAX_SIZE=10000;

    static void process(){
        int[] selfNumberCheck=new int[MAX_SIZE+1];

        selfNumberCheck[1]=0;
        for(int i=1;i<MAX_SIZE;i++){
            if(selfNumberCheck[i] != 0){
                continue;
            }
            CheckNonSelfNumber(i,selfNumberCheck);
        }

        for(int i=1;i<=MAX_SIZE;i++){
            if(selfNumberCheck[i] == 0)
                System.out.println(i);
        } 
    }
    /**
     * rutune d(n) when d(n) <= 10, fill in check list
     * @param number
     * @param list
     */
    static void CheckNonSelfNumber(int number,int[] list){
        while(true){
            int result=dFuntion(number);
            if(result > MAX_SIZE)
                break;
            list[result]=number;
            number=result;
        }
    }

    static int dFuntion(int number){
        String temp=number+"";
        int sum=0;
        for(int i=0;i<temp.length();i++){
            sum+=temp.charAt(i)-'0';
        }
        return number + sum;

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
