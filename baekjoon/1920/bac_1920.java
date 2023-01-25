package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1920 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int N,M;//검색할 배열 크키,검색할 숫자 배열
    static int[] nlist,mlist;//검색해야할 배열,검색할 숫자가 들어있는 배열
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        nlist=new int[N];
        for(int i=0;i<N;i++)
            nlist[i]=fr.nextInt();

        M=fr.nextInt();
        mlist=new int[M];
        for(int i=0;i<M;i++)
            mlist[i]=fr.nextInt();
    }

    static void process(){
        StringBuilder sb=new StringBuilder();
        //검색할 배열을 정렬해줘야한다.
        Arrays.sort(nlist);
        for(int i=0;i<M;i++){
            int result=binarySearch(0,N-1, nlist, mlist[i]);
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }
    static int binarySearch(int start,int end,int[] list,int result){
        //존재하지않을 경우
        int res=0;
        //같거나 작은때까지 반복
        while(start <= end){
            int mid=(start+end)/2;
            //작을 경우
            if(list[mid] > result){
                end=mid-1;
            }
            //클 경우
            else if(list[mid] <result){
                start=mid+1;
            }
            //같을 경우
            else{
                res=1;
                break;
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

