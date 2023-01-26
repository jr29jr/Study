package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2805 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int N;//나무의 수
    static long amount;//필요한 나무의 양
    static int[] trees;//나무 높이 배열
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        amount=fr.nextInt();

        trees=new int[N];
        for(int i=0;i<N;i++)
            trees[i]=fr.nextInt();
        
    }

    static void process(){
        int start=0,end=2000000000;
        int res=binarySearch(start, end, amount);
        System.out.println(res);
    }
    /**
     * 
     * @param start
     * @param end
     * @param result 가져야할 나무의 양
     * @return result만큼 가져가기 위해 최대한 자를 높이
     */
    static int binarySearch(int start,int end,long result){  
        int res=-1;
        while(start <= end){
            int mid=(start+end)/2;
            //필요한 양만큼 구할 수 있는 경우
            //나무를 덜 잘라도 된다. 높이를 높여도되는경우다
            if(calcAmount(mid) >= result){
                res=mid;
                start=mid+1;
            }
            //나무가 부족한 경우다
            //나무를 더 잘라야한다.
            else{
                end=mid-1;
            }
        }
        return res;
    }
    /**
     * 해당 높이에서 가져갈 수 있는 나무의 양을 계산하는 메소드
     * @param height 자를 높이
     * @return 나무의 양
     */
    static long calcAmount(int height){
        long sum=0;
        for(int i=0;i<N;i++){
            if(trees[i] > height){
                sum+=trees[i]-height;
            }
        }
        return sum;
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
