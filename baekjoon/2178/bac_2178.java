package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2178 {

    public static void main(String[] args) {
        input();
        preprocess();
        int result=bfs(0,0);
        System.out.println(result);
    }
    
    static int N,M;
    static int[][] map;//미로의 지도
    static boolean[][] visit;//방문여부 저장

    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();

        map=new int[N][M];
        for(int i=0;i<N;i++){
            String temp=fr.nextLine();
            for(int j=0;j<temp.length();j++){
                map[i][j]=temp.charAt(j)-'0';
            }
        }
    }

    static void preprocess(){
        visit=new boolean[N][M];
    }
    static class Place{
        int row,col,count;//행,열,여기오는데 지나온 개수
        Place(int row,int col,int count){
            this.row=row;
            this.col=col;
            this.count=count;
        }
    }
    /**
     * row,col에서 시작하는 미로의 N,M에 도착하는 최단거리 구하는 함수
     * @param row 행 번호
     * @param col 열 번호
     * @return N,M까지 최단거리
     */
    static int bfs(int row,int col){
        int min=0;
        Queue<Place> list=new LinkedList<Place>();
        //시작점 넣자.방문했다고 체크해야지
        list.add(new Place(row,col,1));
        visit[row][col]=true;

        while(!list.isEmpty()){
            //리스트에서 1개씩 꺼내서 인접한거 다 넣자.
            Place now=list.poll();
            //N,M에 도착한 경우
            if(now.row == N-1 && now.col == M-1){
                min=now.count;
                break;
            }
                
            //아닌 경우 상하좌우 안들렸던 곳 넣자.
            else{
                int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
                //상하좌우로 이동하자.
                for(int i=0;i<4;i++){
                    int nowRow=now.row+direction[i][0],nowCol=now.col+direction[i][1];
                    //배열 밖이면 넘어간다.
                    if( nowRow < 0 || nowCol < 0 || nowRow >=N || nowCol >= M)
                        continue;
                    
                    //이미 방문한곳도 넘기자.
                    if(visit[nowRow][nowCol])
                        continue;
                    
                    //벽일 경우도 넘겨야지
                    if(map[nowRow][nowCol] == 0)
                        continue;
                    //빈곳이면 진행하자.
                    else{
                        list.add(new Place(nowRow,nowCol,now.count+1));
                        visit[nowRow][nowCol]=true;
                    }
                }
            }
        }
        return min;
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

