import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    //와 long으로 했으면 다 고쳐야하는데 처음에 int로 해서 바로 못찾았엇다.
    static int k;
    static long min=Long.MAX_VALUE,max=Long.MIN_VALUE;
    static String minS,maxS;
    static int[] ans,check;
    static int[] operator;//0 == '<', 1== '>'
    static void input() {
        k=scan.nextInt();
        operator=new int[k+1];
        for(int i=1;i<=k;i++){
            if('<' == scan.next().charAt(0)){
                operator[i]=0;
            }
            else{
                operator[i]=1;
            }
        }
        ans=new int[k+2];
        check=new int[11];
        for(int i=1;i<=k+1;i++){
            ans[i]=-1;//0이 입력값이기 때문
        }
    }

    //부등호가 성립하냐?
    static boolean validCheck(){
        for(int i=1;i<=k;i++){
            //'>'인경우
            if(operator[i]==1 ){
                if(ans[i] < ans[i+1])
                    return false;
            }
            //'<' 경우
            else{
                if(ans[i] > ans[i+1])
                    return false;
            }
        }
        return true;
    }

    //최대값,최소값 변경
    static void calc(long num){
        if(min > num){
            min=num;
            minS=sb.toString();
        }
        if(max < num){
            max=num;
            maxS=sb.toString();
        }

    }

    static void rec_func(int order){
        if(order == k+2){
            if(validCheck()){
                for(int i=1;i<=k+1;i++){
                    sb.append(ans[i]);
                }
                long num=Long.parseLong(sb.toString());
                calc(num);
                //초기화
                sb.setLength(0);
            }
        }
        else{
            for(int i=1;i<=10;i++){
                if(check[i]==0){
                    ans[order]=i-1;
                    check[i]=1;
                    rec_func(order+1);
                    check[i]=0;
                    ans[order]=-1;
                }

            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        sb.setLength(0);//sb 초기화
        sb.append(maxS).append('\n').append(minS);
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
