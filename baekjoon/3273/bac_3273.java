package backjoon;
import java.io.*;
import java.util.*; 

public class bac_3273 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int N,x;//수의 개수,찾아야할 값
    static int[] list;//수의 배열
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();

        list=new int[N];
        for(int i=0;i<N;i++)
            list[i]=fr.nextInt();

        x=fr.nextInt();
    }

    static void process(){
        //정렬
        Arrays.sort(list);
        //개수를 확인해야한다.
        int sum=0;
        //이진탐색해서 있나 찾아라.
        for(int i=0;i<N-1;i++){
            int result=binarySearch(i+1, N-1, x-list[i], list);
            if(result != -1)
                sum++;
        }
        System.out.println(sum);
    }

    static int binarySearch(int start,int end,int result,int[] array){
        int index=-1;
        while(start <= end){
            int mid=(start+end)/2;
            if(result == array[mid]){
                index=mid;
                break;
            }
            else if(result>array[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }

        }
        return index;
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
