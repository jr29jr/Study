package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1654 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int has,want;//가지고있는 랜선의 개수,원하는 랜선의 개수
    static int[] lines;//가지고있는 랜선 리스트
    static void input(){
        FastReader fr=new FastReader();
        has=fr.nextInt();
        want=fr.nextInt();

        lines=new int[has];
        for(int i=0;i<has;i++)
            lines[i]=fr.nextInt();
    }

    static void process(){
        //랜선의 길이는 양의 인트 범위다
        int start=0,end=Integer.MAX_VALUE;
        //길이를 매개변수로 하는 이분 탐색을 한다.
        long length=binarySearch(start, end, want);
        System.out.println(length);
    }
    /**
     * result 개수의 랜선을 가질때의 랜선의 최대길이를 구하는 메소드
     * @param start 가장 짧은 길이
     * @param end 가장 긴 길이
     * @param result 원하는 랜선의 개수
     * @return 최대 길이
     */
    static long binarySearch(long start,long end,int result){
        long length=1;//최소 1짜리 1개는 가능하다.
        while(start <= end){
            //start와 end 더하면 int 넘어가는 경우가 있다
            //이거때문에 다 long하는것도 좀..
            long mid=(start+end)/2;
            //result 개수만큼 가능하면 선의 길이를 늘린다.
            if(canGet(mid)){
                length=mid;
                start=mid+1;
            }
            //안되면 선의 길이를 줄인다.
            else{
                end=mid-1;
            }
        }
        return length;
    }
    /**
     * length 길이의 N개의 랜선을 구할 수 있는지 확인하는 메소드
     * @param length 길이
     * @return 가능여부
     */
    static boolean canGet(long length){
        boolean can=false;
        long sum=0;
        //모든 랜선을 length로 나눠서 몫을 더한게 K이상이면 된다.
        for(int i=0;i<has;i++){
            sum+=lines[i]/length;
        }
        //N개 이상의 랜선을 구할 수 있는 경우
        if(sum >= want)
            can=true;
        return can;
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
