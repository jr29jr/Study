import java.io.*;
import java.util.*;

public class Main {
    static int N;//입력받을 숫자의 개수
    static int[] array;//입력받은 숫자들
    static int[] temp;//숫자를 적절하게 배열한 임시저장공간
    static boolean[] check;//숫자를 사용했는지 확인하는 배열
    static int result=Integer.MIN_VALUE;
    static StringBuilder sb=new StringBuilder();

    static FastReader scan = new FastReader();

    static void input(){
        N=scan.nextInt();
        array=new int[N];
        temp=new int[N];
        check=new boolean[N];
        for(int i=0;i<N;i++){
            array[i]=scan.nextInt();
        }
    }
    public static void main(String[] args) throws Exception {
        input();

        rec_func(0);

        System.out.println(result);
    }
    
    /**
     * temp에 들어있는 숫자에 대한 로직을 구현하는 메소드
     */
    static void calc(){
        int sum=0;
        for(int i=0;i<N-1;i++){
            sum+=Math.abs(temp[i]-temp[i+1]);            
        }
        result=Math.max(result,sum);
    }
    /**
     * 1~N번중 index번째에 숫자를 넣는 함수 
     */
    static void rec_func(int index){
        //M번까지 넣었으면 끝내자.
        if(index == N){
            //한개의 리스트가 완성됐다
            calc();
        }
        //temp[index]에 array[i]를 넣는 부분
        else{
            for(int i=0;i<N;i++){
                if(check[i]==false){
                    temp[index]=array[i];
                    check[i]=true;
                    rec_func(index+1);
                    check[i]=false;
                }                 
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

   
