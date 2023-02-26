package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1916 {

    public static void main(String[] args) {
        setting();
        input();
        dijkstra(start, arrive, cityCount, valueMap, visited, best);
        System.out.println(best[arrive]);
    }
    static int[][] valueMap;
    static int start,arrive;
    static int bustCount,cityCount;
    static int MAX_CITY_COUNT=1000;
    static long[] best;
    static boolean[] visited;

    static void input(){
        FastReader fr=new FastReader();
        cityCount=fr.nextInt();
        bustCount=fr.nextInt();

        for(int i=0;i<bustCount;i++){
            int start,end,value;
            start=fr.nextInt();
            end=fr.nextInt();
            value=fr.nextInt();
            if(valueMap[start][end] > value)
                valueMap[start][end]=value;
        }

        start=fr.nextInt();
        arrive=fr.nextInt();
    }
    //초기화 하는 부분
    static void setting(){
        valueMap=new int[MAX_CITY_COUNT+1][MAX_CITY_COUNT+1];

        for(int i=1;i<=MAX_CITY_COUNT;i++){
            for(int j=1;j<=MAX_CITY_COUNT;j++){
                if(i == j)
                    valueMap[i][j]=0;
                else
                    valueMap[i][j]=Integer.MAX_VALUE;
            }
        }

        best=new long[MAX_CITY_COUNT+1];
        visited=new boolean[MAX_CITY_COUNT+1];
    }
    static void dijkstra(int start,int arrive,int citiyCount,int[][] valueMap,boolean[] visited,long[] best){
        //시작점을 고른다.
        visited[start]=true;

        for(int i=1;i<=citiyCount;i++){
            best[i]=valueMap[start][i];
        }
        //모든 도시 방문할때까지 반복
        while(true){
            //최단거리인 지점을 고른다.
            int next=searchShortCity(start, visited, best, citiyCount);
            if(next == -1)
                break;
            //방문여부 저장
            visited[next]=true;
            //최단거리 배열을 갱신한다.
            for(int i=1;i<=citiyCount;i++){
                best[i]=Math.min(best[i],best[next]+valueMap[next][i]);
            }            
        }
    }
    /**
     * @return 다음에 방문할 도시위치(없으면 -1)
     */
    static int searchShortCity(int start,boolean[] visited,long[] beat,int citiyCount){
        long min=Long.MAX_VALUE;
        int next=-1;
        for(int i=1;i<=citiyCount;i++){
            if(visited[i] == false && best[i] < min){
                min=best[i];
                next=i;
            }
        }
        //다 방문했을 경우 -1
        return next;
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

