package backjoon;

import java.io.*;
import java.util.*; 

public class bac_2251{

    public static void main(String[] args) {
        input();
        progress();
    }
    static int BACKET_NUMBER=3;
    static int MAX_AMOUNT=200;
    static int[] size;//a,b,c양동이의 부피
    static boolean[][][] visit;//a,b,c의 양일때 방문했는가 저장하는 함수
    static void input(){
        FastReader fr=new FastReader();

        size=new int[BACKET_NUMBER];//a,b,c 3종류다
        for(int i=0;i<BACKET_NUMBER;i++)
            size[i]=fr.nextInt();
    }

    static ArrayList<Integer> amountList;//a가 0일때 c물의 양 리스트
    static int[] backet;//물통에 담겨진 물의 양
    static void progress(){
        visit=new boolean[MAX_AMOUNT+1][MAX_AMOUNT+1][MAX_AMOUNT+1];
        backet=new int[BACKET_NUMBER];//a,b,c 3개다
        amountList=new ArrayList<Integer>();

        //물통은 c만 가득찬 상태로 시작
        backet[0]=0;
        backet[1]=0;
        backet[2]=size[2];
        dfs(backet);
        Collections.sort(amountList);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<amountList.size();i++)
            sb.append(amountList.get(i)).append(' ');

        System.out.println(sb.toString());
    }
    /**
     * 물을 이동시키는 함수
     * @param from 옮기려는 물통
     * @param to 받는 물통
     * @param backet a,b,c물통에 있는 물의 양(0,1,2)
     */
    static void move(int from,int to,int[] backet){
        //줄 수 있는 물의 양 계산
        //min(옮기려는 물통에 있는 물의 양과 ,받는 물통의 사이즈 - 받는 물통에 남은 물)
        int amount=Math.min(backet[from],size[to]-backet[to]);
        //옮긴다.
        backet[from]-=amount;
        backet[to]+=amount;

    }
    /**
     * a,b,c 3중 1개에서 a,b,c중 남은 2개로 이동하면서 물의 양을 확인하는 함수
     * @param backet a,b,c물의 담겨진 물통배열
     */
    static void dfs(int[] backet){
        int a=backet[0],b=backet[1],c=backet[2];
        //방문했다.
        visit[a][b][c]=true;
        //이때 a의 물이 0이면 c의 물의 양을 측정하자.
        if(a == 0)
            amountList.add(c);

        //i에서 j로 물을 옮긴다.
        for(int i=0;i<BACKET_NUMBER;i++){
            for(int j=0;j<BACKET_NUMBER;j++){
                //같은 물통으로 안 옮긴다.
                if(i == j)
                    continue;
                //i의 물이 없어도 안 옮긴다.
                if(backet[i] == 0)
                    continue;
                
                //이미 방문한 곳일까봐 바켓을 임시로 저장해둔다.
                int[] temp=new int[BACKET_NUMBER];
                for(int t=0;t<BACKET_NUMBER;t++){
                    temp[t]=backet[t];
                }
                //물을 옮긴다.
                move(i,j,temp);
                //이미 방문한 곳이면 원래대로 돌린다.
                if(visit[temp[0]][temp[1]][temp[2]]){
                    continue;
                }
                dfs(temp);                
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

