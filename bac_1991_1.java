package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1991_1 {

    public static void main(String[] args) {
        input();
        process(tree);

    }
    
    static int SIZE=2,nodeCount;
    static int[][] tree;//[루트][왼쪽,오른족]형태로 숫자로 저장 char-'A'로 해서
    static void input(){
        FastReader fr=new FastReader();
        nodeCount=fr.nextInt();

        tree=new int[nodeCount][SIZE];
        for(int i=0;i<nodeCount;i++){
            int node=fr.next().charAt(0)-'A';
            for(int j=0;j<SIZE;j++)
                tree[node][j]=fr.next().charAt(0)-'A';
        }

    }

    static StringBuilder sb;
    static void process(int[][] tree){
        sb=new StringBuilder();
        //A부터 시작한다
        beforeVisit(0,tree);
        sb.append('\n');
        middleVisit(0, tree);
        sb.append('\n');
        afterVisit(0, tree);

        System.out.println(sb.toString());
    }

    /** 
     * 전위 방문
     */
    static void beforeVisit(int visitIndex,int[][] tree){  
        //다음 방문노드 결정
        if(visitIndex < 0)
            return ;
        sb.append((char)(visitIndex + 'A'));
        beforeVisit(tree[visitIndex][0], tree);
        beforeVisit(tree[visitIndex][1], tree);

    } 
    /** 
     * 중위 방문
     */
    static void middleVisit(int visitIndex,int[][] tree){
        if(visitIndex < 0)
            return ;
        middleVisit(tree[visitIndex][0], tree);
        sb.append((char)(visitIndex + 'A'));
        middleVisit(tree[visitIndex][1], tree);
    } 

    /** 
     * 후위 방문
     */
    static void afterVisit(int visitIndex,int[][] tree){
        if(visitIndex < 0)
            return ;
        afterVisit(tree[visitIndex][0], tree);
        afterVisit(tree[visitIndex][1], tree);
        sb.append((char)(visitIndex + 'A'));

    } 
    /**
     * value가 루트인 tree의 index를 구한다.
     * @return index 
     */
    static int searchNode(String[][] tree,String value){
        int result=-1;
        for(int i=0;i<tree.length;i++){
            if(tree[i][0].equals(value)){
                result=i;
                break;
            }

        }
        return result;
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

