package backjoon;
import java.io.*;
import java.util.*; 

/*
 * 두가지 실수를 했다.
 * 처음 문제 풀때는 지나온 곳을 2번 넣어서 답이 이상해졌는데 그걸 늦게 발견해버렸다.반성해야한다.
 * 
 * 그래서 아예 처음부터 다시 풀엇을때는 오름차순 정렬을 까먹어서 또 틀렷다
 */
public class bac_2667 {

    public static void main(String[] args) {
        input();
        progress();
    }
    static int N;//마을의 크기
    static int[][] map;//마을 지도

    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();

        map=new int[N][N];
        for(int i=0;i<N;i++){
            String temp=fr.nextLine();
            for(int j=0;j<N;j++)
                map[i][j]=temp.charAt(j)-'0';
        }
           

    }

    /**
     * 0,0부터 [N-1],[N-1]의 모든 정점에서 단지를 계산한다
     */
    static int houseCount;//단지내 집의 수
    static ArrayList<Integer> list;//집의수(단지별) 리스트
    static boolean[][] visit;//map[row][col] 방문 여부 저장
    static void progress(){
        list=new ArrayList<Integer>();
        visit=new boolean[N][N];

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                //빈 곳이면
                if(map[i][j] == 0)
                    continue;

                //이미 방문했으면
                if(visit[i][j])
                    continue;

                houseCount=0;
                dfs(i,j);
                list.add(houseCount);
            }
        }
        //오름차순 소트 안했네..
        Collections.sort(list);
        //단지의 수와 집의 개수를 출력하자
        StringBuilder sb=new StringBuilder();
        //집의수 개수가 단지의 수다
        sb.append(list.size()).append('\n');
        for(int i=0;i<list.size();i++)
            sb.append(list.get(i)).append('\n');

        System.out.println(sb.toString());

    }
    /**
     * map[row][col] 지점에서 만들 수 있는 단지를 만들고 집의 개수를 저장하는 함수
     * @param row 행
     * @param col 열
     */
    static void dfs(int row,int col){
        //방문하면 할일
        visit[row][col]=true;
        houseCount++;
        //상하좌우 방향 저장(row,col 순으로)
        int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        //상하좌우로 이동하면서 단지내에 속하는지 확인
        for(int i=0;i<4;i++){
            int nowRow=row+direction[i][0],nowCol=col+direction[i][1];
            //배열 벗어나는가?
            if( nowRow < 0 || nowCol <0 || nowRow >=N || nowCol >= N)
                continue;

            //간선이 존재하는가?
            if(map[nowRow][nowCol] == 0)
                continue;
            
            //이미 방문했는가?
            if(visit[nowRow][nowCol])
                continue;

            dfs(nowRow,nowCol);
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
