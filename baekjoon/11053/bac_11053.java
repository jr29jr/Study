package backjoon;

import java.io.*;
import java.util.*; 

public class bac_11053 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int NUMBER_COUNT;//number count
    static int[] numbers;//input numbers
    static void input(){
        FastReader fr=new FastReader();
        NUMBER_COUNT=fr.nextInt();

        numbers=new int[NUMBER_COUNT];
        for(int i=0;i<NUMBER_COUNT;i++){
            numbers[i]=fr.nextInt();
        }
    }

    static int[] maxLength;//index 번째 수열로 끝나는 최대길이 배열
    static void process(){
        int result=0;
        maxLength=new int[NUMBER_COUNT];
        //처음은 무조건 가능
        maxLength[0]=1;
        for(int i=1;i<NUMBER_COUNT;i++){
            int max=0;
            for(int j=0;j<i;j++){
                //넣을 수 있나부터 확인하자.
                if(numbers[j] < numbers[i]){
                    //넣을 수 있는 경우
                    if(maxLength[j] > max){
                        max=maxLength[j];
                    }
                }
                
            }
            //갱신하는 부분이네
            maxLength[i]=max+1;
        }
        
        for(int i=0;i<NUMBER_COUNT;i++){
            result=Math.max(result,maxLength[i]);
        }
        System.out.println(result);

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

