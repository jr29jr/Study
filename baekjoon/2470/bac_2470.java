package backjoon;
import java.io.*;
import java.util.*; 

public class bac_2470 {

    public static void main(String[] args) {
        input();
        process();
    }
    static int N;//용액의 개수
    static int[] list,result;//N개의 용액리스트,결과 용액 2개 저장할 배열
    static int min=Integer.MAX_VALUE;
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        list=new int[N];

        for(int i=0;i<N;i++)
            list[i]=fr.nextInt();

    }
    
    static void process(){
        //용액을 오름차순 정렬하자.
        Arrays.sort(list);
        result=new int[2];
        //마지막 방은 안해도된다.
        for(int i=0;i<N-1;i++){
            //list[i]와 합쳤을때 0에 제일 가까운 값을 찾야야한다.
            //그럼 -list[i]와 제일 가까운 값을 찾으면된다.
            //i+1부터 하는 이유는 이전 반복문에서 i-1전까지는 확인하기 때문이다.
            //위처럼 하면 자기자신과 비교하거나 불필요한 중복제거가 쉽다.
            int num=binarySearch(i+1, N-1, -list[i], list);
            //num,num+1 두개를 비교해야한다.
            //용액간의 거리 임시저장
            int temp=Math.abs(list[i] + list[num]),temp2;
            if(num+1 < N){
                temp2=Math.abs(list[i]+list[num+1]);
                //temp2가 더 적합할 경우
                if(temp > temp2){
                    temp=temp2;
                    num+=1;
                }
            }
            
            //0이면 종료
            if(temp == 0){
                result[0]=list[i];
                result[1]=list[num];
                break;
            }
            //0에 더 가까우면 갱신한다.
            if(min > temp){
                result[0]=list[i];
                result[1]=list[num];
                min=temp;
            }
        }

        StringBuilder sb=new StringBuilder();
        sb.append(result[0]).append(' ').append(result[1]);
        System.out.println(sb.toString());
    }
    /**
     * array에서 result랑 가까운값을 가지는 index를 반환
     * @param start 배열의 시작
     * @param end 배열의 끝
     * @param result 비교할 값
     * @param array 배열
     * @return 가까운 index
     */
    static int binarySearch(int start,int end,int result,int[] array){
        
        //뭘 리턴할지 고민해라 제대로
        //result보다 작은값중 제일 큰거
        //result보다 작은값이 없을 경우는?
        int index=start;
        while(start <= end){
            int mid=(start+end)/2;
            if(array[mid] <= result ){
                index=mid;
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return index;
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
