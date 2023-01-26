package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1764 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int N,M;//듣지 못하는 ,보지못하는 개수
    static String[] nlist,mlist;//듣지 못하는 리스트,보지못하는 리스트 
    static FastReader fr=new FastReader();
    static void input(){
        N=fr.nextInt();
        M=fr.nextInt();
        nlist=new String[N];

        for(int i=0;i<N;i++)
            nlist[i]=fr.nextLine();
    }

    static void process(){
        //정렬부터하자
        Arrays.sort(nlist);
        StringBuilder sb=new StringBuilder();
        int sum=0;
        String[] temp=new String[N];
        //n리스트에서 꺼내서 m리스트에 있나 확인하자.
        for(int i=0;i<M;i++){
            String sample=fr.nextLine();
            int result=binarySearch(0, N-1,sample, nlist);
            //존재할 경우
            if(result != -1){
                temp[sum]=nlist[result];
                sum++;
                //sb.append(nlist[result]).append('\n');
            }
        }
        Arrays.sort(temp,0, sum);
        System.out.println(sum);
        
        for(int i=0;i<sum;i++){
            System.out.println(temp[i]);
        }
        //System.out.println(sb.toString());
    }
    /**
     * array안에 result가 있는지 찾는 메소드
     * @param start 시작점
     * @param end 끝점
     * @param result 찾을 값
     * @param array 검색할 배열
     * @return 존재할 경우 index,없으면 -1
     */
    static int binarySearch(int start,int end,String result,String[] array){
        int index=-1;
        //같은 경우만 찾는다.
        while(start <= end){
            int mid=(start+end)/2;
            int compare=result.compareTo(array[mid]);//result랑 array[mid]비교값 저장
            //같은 경우면 끝낸다.
            if(compare == 0){
                index=mid;
                break;
            }
            //array[mid]가 더 앞일 경우
            else if(compare > 0){
                start=mid+1;
            }
            //result가 앞일 경우
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

