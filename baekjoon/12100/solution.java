import java.io.*;
import java.util.*;

class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,moveCnt=0;
    static int[][] board;
    static int[] calcArray;
    static int max=Integer.MIN_VALUE;
    static void input() {
        N=scan.nextInt();
        board=new int[N+1][N+1];
        calcArray=new int[N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                board[i][j]=scan.nextInt();
            }
        }

    }
    static void copyArray(int[][] original,int[][] copy,int size){
        for(int i=1;i<=size;i++){
            for(int j=1;j<=size;j++){
                copy[i][j]=original[i][j];
            }
        }

    }
    static int calcBoard(int[][] board){
        int num=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                num=Math.max(num,board[i][j]);
            }
        }
        return num;
    }
    static void moveBoard(int direction,int[][] board){
        int index,operand1,operand2;
        //위로
        if(direction == 1) {
            for (int i = 1; i <= N; i++) {
                index = 1;
                operand1 = 0;
                operand2 = 0;
                for (int j = 1; j <=N; j++) {
                    if (board[j][i] == 0)
                        continue;
                    else {
                        //숫자 1개 찾은경우
                        if (operand1 == 0) {
                            operand1 = board[j][i];
                            board[j][i] = 0;
                        }
                        //숫자 2개 찾은 경우
                        else {
                            operand2 = board[j][i];
                            board[j][i] = 0;
                            //같은경우
                            if (operand1 == operand2) {
                                board[index][i] = operand1 + operand2;
                                index++;
                                operand1 = 0;
                                operand2 = 0;
                            }
                            //다를 경우
                            else {
                                board[index][i] = operand1;
                                operand1 = operand2;
                                operand2 = 0;
                                index++;
                            }
                        }
                    }
                }
                //피연산자가 1개 남은 경우
                if(operand1 != 0){
                    board[index][i]=operand1;
                    operand1=0;
                }
            }
        }
        //아래
        else if(direction == 2){
            for (int i = 1; i <= N; i++) {
                index = N;
                operand1 = 0;
                operand2 = 0;
                for (int j = N; j >=1; j--) {
                    if (board[j][i] == 0)
                        continue;
                    else {
                        //숫자 1개 찾은경우
                        if (operand1 == 0) {
                            operand1 = board[j][i];
                            board[j][i] = 0;
                        }
                        //숫자 2개 찾은 경우
                        else {
                            operand2 = board[j][i];
                            board[j][i] = 0;
                            //같은경우
                            if (operand1 == operand2) {
                                board[index][i] = operand1 + operand2;
                                index--;
                                operand1 = 0;
                                operand2 = 0;
                            }
                            //다를 경우
                            else {
                                board[index][i] = operand1;
                                operand1 = operand2;
                                operand2 = 0;
                                index--;
                            }
                        }
                    }
                }
                //피연산자가 1개 남은 경우
                if(operand1 != 0){
                    board[index][i]=operand1;
                    operand1=0;
                }
            }
        }
        //왼쪽
        else if(direction == 3){
            for (int i = 1; i <= N; i++) {
                index = 1;
                operand1 = 0;
                operand2 = 0;
                for (int j = 1; j <=N; j++) {
                    if (board[i][j] == 0)
                        continue;
                    else {
                        //숫자 1개 찾은경우
                        if (operand1 == 0) {
                            operand1 = board[i][j];
                            board[i][j] = 0;
                        }
                        //숫자 2개 찾은 경우
                        else {
                            operand2 = board[i][j];
                            board[i][j] = 0;
                            //같은경우
                            if (operand1 == operand2) {
                                board[i][index] = operand1 + operand2;
                                index++;
                                operand1 = 0;
                                operand2 = 0;
                            }
                            //다를 경우
                            else {
                                board[i][index] = operand1;
                                operand1 = operand2;
                                operand2 = 0;
                                index++;
                            }
                        }
                    }
                }
                //피연산자가 1개 남은 경우
                if(operand1 != 0){
                    board[i][index]=operand1;
                    operand1=0;
                }
            }
        }
        //오른쪽
        else {
            for (int i = 1; i <= N; i++) {
                index = N;
                operand1 = 0;
                operand2 = 0;
                for (int j = N; j >= 1; j--) {
                    if (board[i][j] == 0)
                        continue;
                    else {
                        //숫자 1개 찾은경우
                        if (operand1 == 0) {
                            operand1 = board[i][j];
                            board[i][j] = 0;
                        }
                        //숫자 2개 찾은 경우
                        else {
                            operand2 = board[i][j];
                            board[i][j] = 0;
                            //같은경우
                            if (operand1 == operand2) {
                                board[i][index] = operand1 + operand2;
                                index--;
                                operand1 = 0;
                                operand2 = 0;
                            }
                            //다를 경우
                            else {
                                board[i][index] = operand1;
                                operand1 = operand2;
                                operand2 = 0;
                                index--;
                            }
                        }
                    }
                }
                //피연산자가 1개 남은 경우
                if (operand1 != 0) {
                    board[i][index] = operand1;
                    operand1 = 0;
                }
            }
        }
    }
    //v는 이동횟수,게임판
    static void rec_func(int v,int[][] board){
        //끝나는 조건 최대 5번 이동
        if(moveCnt==6){
            return ;
        }
        else{
            //이동하기전에 보드판의 최대값을 계산해서 비교
            max=Math.max(max,calcBoard(board));
            for(int i=1;i<=4;i++){
                //복사본 이동해서 주자.
                int[][] temp= new int[N+1][N+1];
                copyArray(board,temp,N);
                moveBoard(i,temp);
                moveCnt++;
                rec_func(v+1,temp);
                moveCnt--;
            }
        }
    }
    public static void main(String[] args) {
        input();
        rec_func(1,board);
        sb.append(max).append('\n');
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
