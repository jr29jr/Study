import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static StringBuilder result=new StringBuilder();
    static FastReader scan = new FastReader();

    static void input(){
        N=scan.nextInt();
        M=scan.nextInt();
    }
    public static void main(String[] args) throws Exception {
        input();
        int[] array=new int[M+1];
        rec_func(1,array);

        System.out.println(result.toString());
    }
    /**
     * 1~M번중 index번째에 숫자를 넣는 함수 
     */
    static void rec_func(int index,int[] array){
        //M번까지 넣었으면 끝내자.
        if(index == M+1){
            //한개의 리스트가 완성됐다
            //그 리스트를 결과 string에 넣어주자
            for(int i=1;i<=M;i++)
                result.append(array[i]).append(' ');
            result.append('\n');
            return ;
        }
            
        for(int i=1;i<=N;i++){
            array[index]=i;
            rec_func(index+1,array);
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

   
