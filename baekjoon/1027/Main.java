import java.io.*;
import java.util.*; 

public class Main {

    public static void main(String[] args) {
        input();
        solve();
        System.out.println(sawCount);
    }

    static int N;//빌딩의 개수
    static int[] heighList;//빌딩의 높이 배열
    static int sawCount=0;//보이는 빌딩의 개수
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();

        heighList=new int[N+1];
        for(int i=1;i<=N;i++)
            heighList[i]=fr.nextInt();
    }
    /**
     * 1,2개의 빌딩을 선택해서 사이에 있는 빌딩의 개수를 구하는 함수
     * 사이에 있는 빌딩이 두 빌딩보다 낮아야한다.
     */
    static void solve(){
        //빌딩이 최소 3개여야 성립한다
        if(N < 3){
            sawCount=0;
            return ;
        }
            
        int target;//고를 빌딩 위치
        for(target=1;target<=N;target++){
            int temp=calcBuildingCount(target);
            sawCount=Math.max(sawCount, temp);
        }
        
    }
    /**
     * 첫번째,두번째 건물이 서로 보이는가?
     * @param first 첫번째 건물 위치
     * @param second 두번째 건물 위치
     * @return first랑 second가 서로 보이는 여부
     */
    static boolean canSee(int first,int second){
        //ccw의 값
        long y;
        //둘 사이에 건물이 없는 경우(무조건 보인다)
        if(Math.abs(first-second) == 1)
            return true;
        if(first < second)
            for(int i=first+1;i<second;i++){
                //ccw 공식을 써야한다.
                y=((long)second - first)*(heighList[i] - heighList[first]) - ((long)i- first )*(heighList[second] - heighList[first]);
                if(first > second && y <= 0)
                    return false;
                else if(first < second && y >= 0)
                    return false;

            }
        else
            for(int i=second+1;i<first;i++){
                //ccw 공식을 써야한다.
                y=((long)second - first)*(heighList[i] - heighList[first]) - ((long)i- first )*(heighList[second] - heighList[first]);
                if(first > second && y <= 0)
                    return false;
                else if(first < second && y >= 0)
                    return false;

            }
        //first,second사이 건물이 다 낮을 경우 보인다
        return true;        
    }
    /**
     * target에 보이는 건물의 개수를 세는 함수
     * @param target 첫번째 빌딩 위치
     * @return 타겟에서 보이는 건물개수
     */
    static int calcBuildingCount(int target){
        int count=0;//사이에 있는 빌딩 누적 변수
        for(int i=1;i<=N;i++){
            if( i == target)
                continue;

            if(canSee(target, i))
                count++;
        }
        return count;
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
