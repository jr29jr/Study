package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2447 {

    public static void main(String[] args) {
        input();
        process(size);
    }
    
    static int size;
    static void input(){
        FastReader fr=new FastReader();
        size=fr.nextInt();
    }
   
    static void process(int size){
        char[][] map=new char[size][size];

        divideMap(map, 0, 0, size);

        print(map, size);
    }   

    static void print(char[][] map,int size){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(map[i][j]== '*'){
                    sb.append('*');
                }
                else{
                    sb.append(' ');
                }
            }
            sb.append('\n');
            
        }
        System.out.println(sb.toString());
    }
    static void divideMap(char[][] map,int startRow,int startCol,int size){
        //3*3까지 쪼개진 경우
        if(size == 3){
            fillMap(map, startRow, startCol);
            return ;
        }
        size=size/3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){                
                if( i == 1 && j == 1)
                    continue;
                divideMap(map,startRow + i*size, startCol + j*size, size);
            }

        }
    }
    static void fillMap(char[][] map,int row,int col){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if( i == 1  && j == 1)
                    continue;
                map[row+i][col+j]='*';
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
