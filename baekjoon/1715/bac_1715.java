package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1715 {

    public static void main(String[] args) {
        input();
        process();
    }
    
    static int totalCount;//총개수
    static PriorityQueue<Integer> cardSizes;//카드 뭉치의 크키 배열
    static void input(){
        FastReader fr=new FastReader();
        totalCount=fr.nextInt();

        //우선순위 큐에 넣자.
        cardSizes=new PriorityQueue<>();
        for(int i=0;i<totalCount;i++){
            cardSizes.add(fr.nextInt());
        }
    }

    
    static void process(){
        int result=0;//결과
        //카드 뭉치1,카드뭉치2
        //첫 카드뭉치는 맨 처음꺼로 초기화해준다.2번째는 반복문을 통해서 얻는다.
        //1개 남을때까지 한다.
        while(cardSizes.size() > 1){
            int first=cardSizes.poll(),second=cardSizes.poll();
            result+=first+second;
            cardSizes.add(first+second);
        }

        System.out.println(result);
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

