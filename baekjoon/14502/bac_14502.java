import java.io.*;
import java.util.*; 

public class bac_14502 {

    public static void main(String[] args) {
        input();
        //빈곳과 바이러스의 위치를 저장한다.
        preprocess();
        //벽을 세우고 바이러스를 퍼트리는 과정을 반복
        dfs(0,0);
        System.out.println(max);
    }
    static int max=Integer.MIN_VALUE;//안전구역의 최댓값
    static int N,M;//맵의 행열값
    static int[][] map;//연구소 지도
    static boolean[][] visit;//방문여부
    static ArrayList<int[]> blanks;//빈곳을 저장하는 배열 row,col 순으로
    static ArrayList<int[]> virusList;//바이러스 저장하는 배열
    //입력을 처리하는 함수
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();

        map=new int[N][M];
        
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=fr.nextInt();
            }
        }
    }
    
    //바이러스 정보와 빈곳 정보를 초기화하는 과정
    static void preprocess(){
        blanks=new ArrayList<int[]>();
        virusList=new ArrayList<int[]>();
        visit=new boolean[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                //빈 곳일 경우
                if(map[i][j] == 0){
                    blanks.add(new int[]{i,j});
                }
                //바이러스일 경우
                if(map[i][j]==2){
                    virusList.add(new int[]{i,j});
                }
            }
        }
    }
    /**
     * dfs로 벽을 3개 짓고 바이러스 퍼트린뒤 안전구역 개수 비교하는 함수
     * @param count 몇번째 벽을 세우는 건가
     * @param blankIndex 몇번째 빈곳에 벽을 세우는건가
     */
    static void dfs(int count,int blankIndex){
        //벽을 3개 세우면 이제 바이러스 퍼트리자.
        if(count == 3){
            //바이러스 퍼트리고 안전구역 확인
            int result=calc();
            if(result>max)
                max=result;
            //max=Math.max(max,calc());
            //종료(벽을 4개 이상 지으면 안되니)
            return ;
        }

        //모든 빈곳을 확인한 경우(벽이 2개 이하면서)
        if(blankIndex == blanks.size()){
            return ;
        }
        //빈곳을 한개 꺼내서 벽을 세울지말지 결정
        //벽을 세운 경우
        map[blanks.get(blankIndex)[0]][blanks.get(blankIndex)[1]]=1;
        dfs(count+1,blankIndex+1);
        //벽을 안세운 경우
        map[blanks.get(blankIndex)[0]][blanks.get(blankIndex)[1]]=0;
        dfs(count,blankIndex+1);
    }
    /**
     * 바이러스를 뿌리고 안전구역을 계산해서 반환하는 함수
     * @return 안전구역 수를 반환
     */
    static int calc(){
        //맵의 원본을 저장
        int[][] temp=new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                temp[i][j]=map[i][j];
            }
        }

        for(int i=0;i<virusList.size();i++){
            spreadVirus(virusList.get(i)[0],virusList.get(i)[1]);
        }
        //안전 구역을 계산
        int safeArea=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 0)
                    safeArea++;
            }
        }

        //다하고 맵 복원하고 방문배열 초기화
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                map[i][j]=temp[i][j];
                visit[i][j]=false;
            }
        }
        
        return safeArea;
    }
    /**
     * row,col에서 시작하는 바이러스 퍼트리는 함수
     * @param row
     * @param col
     */
    static void spreadVirus(int row,int col){
        //방문해서 해야할일
        visit[row][col]=true;
        //바이러스 확산
        map[row][col]=2;
        //상하좌우를 확인해서 방문한다.
        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<4;i++){
            int nowRow=row+direction[i][0],nowCol=col+direction[i][1];
            //배열 범위 벗어나는 경우
            if( nowRow < 0 || nowCol < 0 || nowRow >= N || nowCol >=M)
                continue;
            //이미 방문한 경우
            if(visit[nowRow][nowCol])
                continue;
            
            //벽이나 이미 감염된 지역인 경우
            if( map[nowRow][nowCol] == 1 || map[nowRow][nowCol] == 2)
                continue;

            //빈 곳일 경우 - 퍼지면된다.
            spreadVirus(nowRow, nowCol);
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
