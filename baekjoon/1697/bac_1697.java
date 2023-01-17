package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1697 {

    public static void main(String[] args) {
        input();
        preprocess();
        System.out.println(bfs());
    }
    static int N,K;//N은 출발점,K는 도착점
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        K=fr.nextInt();
    }
    static boolean[] visit;//숫자에 방문했는지 저장하는 변수
    static int MAX_SIZE = 100000;
    static void preprocess(){
        visit=new boolean[MAX_SIZE+1];
    }
    
    /**
     * -1,+1,*2로 이동하면서 K까지 가장 가까운 거리 저장하는 함수
     */
    static int bfs(){
        Queue<int[]> list=new LinkedList<int[]>();
        //시작점 넣는다
        list.add(new int[]{N,0});
        visit[N]=true;
        int result=0;
        //빌때까지 한다.
        while(!list.isEmpty()){
            int[] now=list.poll();
            //도착한 경우
            if(now[0] == K){
                result=now[1];
                break;
            }

            //뺀거리가 0이상이면 넣는다.
            if(now[0]-1 >= 0 && visit[now[0]-1] == false){
                list.add(new int[]{now[0]-1,now[1]+1});
                visit[now[0]-1]=true;
            }
            //더한 거리가 최대치보다 이하면 넣는다
            if(now[0]+1 <= MAX_SIZE  && visit[now[0]+1] == false){
                list.add(new int[]{now[0]+1,now[1]+1});
                visit[now[0]+1]=true;
            }
            //곱한 거리가 최대치보다 이하면 넣는다
            if(now[0]*2 <= MAX_SIZE  && visit[now[0]*2] == false){
                list.add(new int[]{now[0]*2,now[1]+1});
                visit[now[0]*2]=true;
            }
        }
        return result;
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
