package backjoon;

import java.io.*;
import java.util.*; 

public class bac_3055 {

    public static void main(String[] args) {
        input();
        int result=bfs();
        if(result >= 0)
            System.out.println(result);
        else
            System.out.println("KAKTUS");
    }
    static int R,C;//맵의 행과 열 정보
    static char[][] map;//빈곳 .,비는 *,돌은 x,목적지는 D,시작점은 S
    static int[] start,end;//시작점과 도착점 받는다.
    static boolean[][] visit;//고슴도치가 방문한 위치
    static Queue<int[]> rains;//비를 저장하는 배열
    static void input(){
        FastReader fr=new FastReader();   
        
        R=fr.nextInt();
        C=fr.nextInt();

        rains=new LinkedList<int[]>();
        map=new char[R][C];
        start=new int[2];
        end=new int[2];
        visit=new boolean[R][C];

        for(int i=0;i<R;i++){
            String temp=fr.nextLine();
            for(int j=0;j<C;j++){
                map[i][j]=temp.charAt(j);
                //도착지면
                if(map[i][j]=='D'){
                    end[0]=i;
                    end[1]=j;
                }
                //출발지
                else if(map[i][j]=='S'){
                    start[0]=i;
                    start[1]=j;
                }
                //비 위치
                else if(map[i][j]=='*'){
                    rains.add(new int[]{i,j});
                }
                    
            }
        }
    }
    //고슴도치의 이동경로 클래스
    static class Load{
        int row,col,minute;//이동한 행과 열,거기까지 가는데 걸린 시간
        Load(int row,int col,int minute){
            this.row=row;
            this.col=col;
            this.minute=minute;
        }
    }
    /**
     * 시작점에서 출발해서 도착지까지 진행하는 함수
     * @return 도착지까지의 시간(분),불가능하면 -1
     */
    static int bfs(){
        int minute=-1;
        //고슴도치를 넣자
        Queue<Load> loads=new LinkedList<Load>();
        loads.add(new Load(start[0],start[1],0));
        visit[start[0]][start[1]]=true;
        //고슴도치가 이동못할때까지 진행한다.
        while(!loads.isEmpty()){
            //상하좌우 방향성 배열
            int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
            //고슴도치도 현재 load개수만큼 해야한다.
            int loadCount=loads.size();
            for(int count=0;count<loadCount;count++){
                Load now=loads.poll();
                //끝나는 순간
                if(now.row == end[0] && now.col == end[1]){
                    minute=now.minute;
                    return minute;
                }
                    
                //고슴도치가 이동
                for(int i=0;i<4;i++){
                    
                    int nowRow=now.row+direction[i][0],nowCol=now.col+direction[i][1];
                    //배열안에 포함되나?
                    if(nowRow < 0 || nowCol < 0 || nowRow >= R || nowCol >= C)
                        continue;
                    //다음에 비가 오냐?
                    if(canRain(nowRow,nowCol))
                        continue;
                    //이미 비가 오거나 바위면 안간다.
                    if(map[nowRow][nowCol] == 'X' || map[nowRow][nowCol] == '*')
                        continue;
                    //빈 땅이거나 목적지면 가자.
                    else if(map[nowRow][nowCol] == '.' || map[nowRow][nowCol] == 'D'){
                        loads.add(new Load(nowRow,nowCol,now.minute+1));
                        map[nowRow][nowCol]='S';
                        visit[nowRow][nowCol]=true;
                    }
                }
            }            
            //비가 이동
            //현재 들어있는 비 개수만큼만 이동
            int nowCount=rains.size();
            for(int count=0;count<nowCount;count++){
                int[] nowRain=rains.poll();
                //비가 이동
                for(int i=0;i<4;i++){                  
                    int nowRow=nowRain[0]+direction[i][0],nowCol=nowRain[1]+direction[i][1];
                    //배열안에 포함되나?
                    if(nowRow < 0 || nowCol < 0 || nowRow >= R || nowCol >= C)
                        continue;
                    //이미 비가 오거나 바위면 안간다.
                    if(map[nowRow][nowCol] == 'X' || map[nowRow][nowCol] == '*' || map[nowRow][nowCol] == 'D')
                        continue;
                    //빈 땅이거나 고슴도치가 지나온 곳이면
                    else if(map[nowRow][nowCol] == '.' || map[nowRow][nowCol] == 'S'){
                        rains.add(new int[]{nowRow,nowCol});
                        map[nowRow][nowCol]='*';
                    }
                }
            }
            
        }
        return minute;
    }
    /**
     * row,col에 다음에 비가 오나 확인하는 함수
     * @param row
     * @param col
     * @return 비가 올지 여부
     */
    static boolean canRain(int row,int col){
        //목적지는 절대 비가 안온다.
        if(map[row][col] == 'D')
            return false;
        int[][] direction={{-1,0},{1,0},{0,-1},{0,1}};
        for(int i=0;i<4;i++){
            int nowRow=row+direction[i][0],nowCol=col+direction[i][1];
            //맵 밖이라 무시
            if(nowRow < 0 || nowCol < 0 || nowRow >= R || nowCol >= C)
                continue;
            //맵 내부일 경우
            else{
                if(map[nowRow][nowCol] == '*')
                    return true;
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
