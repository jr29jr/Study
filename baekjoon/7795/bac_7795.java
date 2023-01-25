package backjoon;
import java.io.*;
import java.util.*; 

public class bac_7795 {
    static FastReader fr=new FastReader();
    public static void main(String[] args) {
        int T=fr.nextInt();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<T;i++){
            input();
            int result=process();
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
    static int A,B;//a배열 크기,B배열 크기
    static int[] Alist,Blist;//a배열,b배열
    static void input(){
        A=fr.nextInt();
        B=fr.nextInt();

        Alist=new int[A];
        Blist=new int[B];
        for(int i=0;i<A;i++)
            Alist[i]=fr.nextInt();

        for(int i=0;i<B;i++)
            Blist[i]=fr.nextInt();
        
    }
    static int process(){
        //result보다 값이 작은 방의 index
        int sum=0;
        Arrays.sort(Blist);
        for(int i=0;i<A;i++){
            sum+=binarySearch(0, B-1, Alist[i], Blist)+1;
        }       
        //방번호+1이 개수다
        return sum;
    }
    static int binarySearch(int start,int end,int result,int[] array){
        //없을 경우를 고려
        int res=-1;
        while(start <= end){
            int mid=(start+end)/2;
            if(array[mid] < result){
                res=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return res;
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
