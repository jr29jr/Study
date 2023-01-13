import java.io.*;
import java.util.*; 

public class Main {
    static int OPERATOR_NUM=4;//연산자는 4종류

    static int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
    static int N,operSum;//숫자개수,연산자개수
    static int[] operList;//+,-,*,/ 연산자의 개수를 저장
    static int[] numberList;//연산할 숫자 리스트
    static int[] list;//M개의 연산자를 1~M번방까지 배치할 공간

    static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) {
        input();

        rec_func(1);

        System.out.println(max+"\n"+min);
    }

    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        numberList=new int[N+1];
        for(int i=1;i<=N;i++)
            numberList[i]=fr.nextInt();

        operList=new int[OPERATOR_NUM];//연산자는 4종류다.
        operSum=0;
        for(int i=0;i<OPERATOR_NUM;i++){
            operList[i]=fr.nextInt();
            operSum+=operList[i];
        }
            
    
        list=new int[operSum+1];
    }
    /**
     * number부터 M번까지 연산자를 배치한다.
     * @param number 숫자를 배치할 위치
     */
    static void rec_func(int number){
        //종료조건 M까지 배치한다4 2
        if(number == operSum+1){
            //숫자의 연산 처리 결과다.
            int calcResult=calc();
            max=Math.max(max,calcResult);
            min=Math.min(min,calcResult);
        }  
        //연산자가 남아있나 확인후 배치
        else{
            for(int i=0;i<OPERATOR_NUM;i++){
                //연산자가 남아있다.
                if(operList[i] != 0){
                    list[number]=i;
                    operList[i]--;
                    rec_func(number+1);
                    //썻으면 반납
                    operList[i]++;
                }
            }
        }
    
    }
    /**
     * 연산자 순서대로 계산하고 그 값을 반환한다
     * @return numberList에 있는 숫자를 list에 있는 연산자 순으로 계산한다.
     */
    static int calc(){
        int sum=0;
        sum+=numberList[1];//맨 처음방은 무조건 더한다.
        //숫자 개수가 연산자보다 1개 많다.
        for(int i=2;i<=N;i++){
            switch(list[i-1]){
                //+의 경우
                case 0:
                    sum+=numberList[i];
                    break;
                //-의 경우
                case 1:
                    sum-=numberList[i];
                    break;
                // *의 경우
                case 2:
                    sum*=numberList[i];
                    break;
                // /의 경우
                case 3:
                    sum/=numberList[i];
                    break;

            }
        }
        return sum;
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
