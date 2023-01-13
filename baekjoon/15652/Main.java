import java.io.*;
import java.util.*; 

public class Main {
    static int N,M;
    static int[] list;//M개의 숫자를 1~M번방까지 배치할 공간
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) {
        input();

        rec_func(1,1);

        System.out.println(sb.toString());
    }

    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();
        list=new int[M+1];
    }
    /**
     * number부터 M번까지 숫자를 중복있게 배치하자.다만 비내림차순으로 정렬
     * @param number 숫자를 배치할 위치
     * @param lastUse N이전에 사용한 가장큰 숫자.
     */
    static void rec_func(int number,int lastUse){
        //종료조건 M까지 배치한다
        if(number == M+1){
            //sb에 넣자.
            for(int i=1;i<=M;i++){
                sb.append(list[i]).append(' ');
            }
            sb.append('\n');
        }  
        //number번째에 숫자를 배치하는 로직
        else{
            for(int i=lastUse;i<=N;i++){
                list[number]=i;
                rec_func(number+1,i);
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
