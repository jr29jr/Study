package backjoon;
import java.io.*;
import java.util.*; 

public class bac_1260 {

    public static void main(String[] args) {
        input();
        dfs(V);
        sb.append('\n');
        //visit 배열 초기화
        for(int i=1;i<=N;i++)
            visit[i]=false;
        bfs(V);
        System.out.println(sb.toString());
    }
    static int N,V,M;//정점의 개수,V는 시작 정점,M은 간선의 개수
    static int[][] array;//인접행렬
    static boolean[] visit;//정점의 방문 여부
    static StringBuilder sb=new StringBuilder();
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();
        V=fr.nextInt();

        array=new int[N+1][N+1];
        visit=new boolean[N+1];

        for(int i=0;i<M;i++){
            int num1,num2;//입력받을 간선의 정점 2개
            num1=fr.nextInt();
            num2=fr.nextInt();
            array[num1][num2]=1;
            array[num2][num1]=1;
        }
    }

    /**
     *  number에서 방문 가능한 모든 지점을 dfs방식을 방문한다.
     * @param number 방문한 번호
     */
    static void dfs(int number){
        //방문했으니 방문여부 체크
        visit[number]=true;

        sb.append(number).append(' ');

        //인접한 정점을 오름차순으로 방문
        for(int i=1;i<=N;i++){
            //간선이 있나 확인해야한다.
            if(array[number][i] == 0)
                continue;

            //이미 방문했으면 생략
            if(visit[i] == true)
                continue;
            //i번
            dfs(i);
        }
        
    }
    /**
     * number에서 방문 가능한 모든지점을 bfs 방식으로 방문
     * @param number 방문한 정점
     */
    static void bfs(int number){
        //number부터 시작처리
        Queue<Integer> q=new LinkedList<Integer>();
        q.add(number);
        visit[number]=true;

        while(!q.isEmpty()){
            //한개 꺼낸다
            int now=q.poll();
            sb.append(now).append(' ');
            //꺼낸거에서 간선있는거 다 넣자.
            for(int i=1;i<=N;i++){
                //간선 없는거
                if(array[i][now] == 0)
                    continue;
                
                //이미 방문한 곳
                if(visit[i] == true)
                    continue;
                
                //방문 안한곳이면 다 넣자.
                q.add(i);
                //방문했으면 true로 바꿔주자.
                visit[i]=true;
            }
        }
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
