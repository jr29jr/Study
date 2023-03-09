package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2468 {

    public static void main(String[] args) {
        input();
        int result=process(map);
        System.out.println(result);
    }
    
    static int size;
    static int[][] map;
    static void input(){
        FastReader fr=new FastReader();
        size=fr.nextInt();
        
        map=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                map[i][j]=fr.nextInt();
            }
        }
    }
    static int RAIN_MAX=100;
    static int process(int[][] map){
        int max=0;
        int[][] check=new int[map.length][map.length];
        for(int rain=0;rain <= RAIN_MAX;rain++){
            int sum=0;//안전역역의 합
            for(int i=0;i<map.length;i++){
                for(int j=0;j<map[i].length;j++){
                    //방문 안한곳이랑 비에 안 잠긴곳 방문
                    if( check[i][j] == 0 && map[i][j] > rain ){
                        checkSafe(map, check, i, j, rain);
                        sum++;
                    }
                }
            }
            //check를 초기화하자.
            check=new int[map.length][map.length];
            max=Math.max(max,sum);
        }
       
        return max;
    }

    static void checkSafe(int[][] map,int[][] check,int row,int col,int rain){
        //좌표가 범위 초과할 경우
        if( 0 > row || row >= map.length || 0 > col || col >= map.length ){
            return ;
        }
        //좌표가 잠길 경우
        if(map[row][col] <= rain){
            return ;
        }

        //이미 방문한 경우
        if(check[row][col] == 1)
            return ;
        
        check[row][col]=1;//방문했다.
        int[] rowDir = { -1,1,0,0};//상하좌우 row값
        int[] colDir = { 0, 0, -1,1};//col 좌표 추가

        for(int i=0;i<4;i++){
            //상하좌우를 방문하자.
            checkSafe(map, check, row+rowDir[i], col+colDir[i], rain);
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

