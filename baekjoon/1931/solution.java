import java.io.*;
import java.util.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,max;
    static int[][] inputs;//start,end
    static int ans[];//각 시간별 최대 회의수
    static void input() {
        N=scan.nextInt();
        inputs=new int[N+1][3];


        for(int i=1;i<=N;i++)
            for(int j=1;j<=2;j++)
                inputs[i][j]=scan.nextInt();

        //이거 무조건 정리해라,이걸 몰라서 똥꼬쇼 많이 했었다.
        Arrays.sort(inputs, new Comparator<int[]>() {
            //o1의 행이 더 작다
            @Override
            public int compare(int[] o1, int[] o2) {
                //스왑이 필요한 경우만 return 1 처리해주면 된다.
                //-1,0이나 스왑 안하는거라 똑같다
                //2번방으로 오름차순
                if(o1[2] > o2[2]){
                    return 1;
                }
                //2번방이 같을 경우 1빈방을 비교해서 오름차순
                else if(o1[2] == o2[2]){
                    if(o1[1] > o2[1]){
                        return 1;
                    }
                }
                return -1;
            }
        });

        //마지막 시간을 알아내야하네?
        ans=new int[inputs[N][2]+1];
    }
    //k를 회의수 만큼 반복
    static void solve(){
        int last=0;
        for(int i=1;i<=N;i++){
            int start,end;
            start=inputs[i][1];
            end=inputs[i][2];
            //빈곳을 채우는 로직을 넣자.
            for(int j=last+1;j<=end;j++)
                ans[j]=ans[last];
            ans[end]=Math.max(ans[end],ans[start]+1);
            last=end;
        }

    }
    public static void main(String[] args) {
        input();
        solve();
        System.out.println(ans[inputs[N][2]]);
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
