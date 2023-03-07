package backjoon;

import java.io.*;
import java.util.*; 

public class bac_11657 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int cityCount,busCount;
    static List<int[]> routes;
    static void input(){
        FastReader fr=new FastReader();
        cityCount=fr.nextInt();
        busCount=fr.nextInt();

        routes=new ArrayList<>();
        for(int i=0;i<busCount;i++){
            //시작,도착,걸리는 시간
            int[] route=new int[3];
            route[0]=fr.nextInt();
            route[1]=fr.nextInt();
            route[2]=fr.nextInt();
            routes.add(route);
        }      

    }

    static void process(){
        //도시 개수만큼 만들어라.
        long[] distance=new long[cityCount+1];
        boolean hasCycle =ballmanFord(1, cityCount, routes, distance);
        if(hasCycle == true)
            System.out.println(-1);
        else{
            printDistance(distance);
        }
    }
    static void printDistance(long[] distance){
        StringBuilder sb=new StringBuilder();
        //시작점을 제외하고 출력
        for(int i=2;i<distance.length;i++){
            if(distance[i] == Integer.MAX_VALUE)
                sb.append(-1).append('\n');
            else
                sb.append(distance[i]).append('\n');

        }

        System.out.println(sb.toString());
    }
    static boolean ballmanFord(int start,int cityCount,List<int[]> routes,long[] distance){
        //거리배열 초기화
        for(int i=0;i<distance.length;i++)
            distance[i]=Integer.MAX_VALUE;
        //시작점은 초기화
        distance[start]=0;
        //도시 수만큼 반복(음의 순환을 찾기위해서 n번 하는거다.기본적으로 n-1만 하면된다.)
        for(int i=0;i<cityCount;i++){
            //모든 간선으로 갱신
            for(int j=0;j<routes.size();j++){
                int[] route=routes.get(j);
                int nowNode=route[0];
                int nextNode=route[1];
                int time=route[2];
                //거리 갱신이 가능한 경우
                if(distance[nowNode] != Integer.MAX_VALUE && distance[nextNode] > distance[nowNode]+time){
                    distance[nextNode] = distance[nowNode]+time;
                    //음의 순환이 존재한다.
                    if(i == cityCount-1)
                        return true;
                }
            }
        }
        return false;
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
