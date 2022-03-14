import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int[][] board;
    static int SIZE=10;
    static int[][] rowCheck,colCheck;
    static int[][][] recCheck;//3x3 사각체크
    static boolean finish;

    static void input() {
        board=new int[SIZE][SIZE];
        rowCheck=new int[SIZE][SIZE];
        colCheck=new int[SIZE][SIZE];
        recCheck=new int[3][3][SIZE];
        for(int i=1;i<=9;i++){
            for(int j=1;j<=9;j++){
                board[i][j]=scan.nextInt();
                //여기서 check 함수 채우자
                rowCheck[board[i][j]][i]=1;
                colCheck[board[i][j]][j]=1;
                recCheck[(i-1)/3][(j-1)/3][board[i][j]]=1;
            }
        }
    }
    static boolean vaildCheck(int row,int col,int value){
        //가로
        if(rowCheck[value][row] == 1)
            return false;
        //세로
        if(colCheck[value][col] == 1)
            return false;
        //네모
        if(recCheck[(row-1)/3][(col-1)/3][value] == 1){
            return false;
        }
        return true;
    }

    static void updateCheck(int row,int col,int value,int change){
        rowCheck[value][row]=change;
        colCheck[value][col]=change;
        recCheck[(row-1)/3][(col-1)/3][value]=change;
    }
    //가로세로 순으로 이동
    static void rec_func(int row,int col){
        if(row== 10 && col == 1){
            for(int i=1;i<=9;i++){
                for(int j=1;j<=9;j++){
                    sb.append(board[i][j]).append(' ');
                }
                sb.append('\n');
            }
            sb.append('\n');
            finish=true;
        }
        else{
            if(finish==true)
                return ;

            if(board[row][col] != 0){
                if(col < 9){
                    rec_func(row,col+1);
                }
                else{
                    rec_func(row+1,1);
                }
            }
            else{
                for(int i=1;i<=9;i++){
                    if(vaildCheck(row,col,i)){
                        board[row][col]=i;
                        //check 갱신해야한다 ㅋㅋ
                        updateCheck(row,col,i,1);
                        if(col < 9){
                            rec_func(row,col+1);
                        }
                        else{
                            rec_func(row+1,1);
                        }
                        board[row][col]=0;
                        updateCheck(row,col,i,0);
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        input();
        rec_func(1,1);
        System.out.println(sb.toString());
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
