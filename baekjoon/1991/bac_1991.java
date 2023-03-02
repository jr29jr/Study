package backjoon;

import java.io.*;
import java.util.*; 

public class bac_1991 {

    public static void main(String[] args) {
        input();
        process(tree);

    }
    
    static int SIZE=3,nodeCount;
    static String[][] tree;//루트,왼쪽,오른족
    static void input(){
        FastReader fr=new FastReader();
        nodeCount=fr.nextInt();

        tree=new String[nodeCount][SIZE];
        for(int i=0;i<nodeCount;i++){
            for(int j=0;j<SIZE;j++)
                tree[i][j]=fr.next();
        }

    }

    static void process(String[][] tree){
        //A부터 시작한다
        beforeVisit(0,tree);
        System.out.println();
        middleVisit(0, tree);
        System.out.println();
        afterVisit(0, tree);
    }

    /** 
     * 전위 방문
     */
    static void beforeVisit(int visitIndex,String[][] tree){
        System.out.print(tree[visitIndex][0]);
        //다음 방문노드 결정
        int first,second;
        first=searchNode(tree, tree[visitIndex][1]);
        second=searchNode(tree,tree[visitIndex][2]);
        if(first != -1)
            beforeVisit(first, tree);
        if(second != -1)
            beforeVisit(second, tree);

    } 

    /** 
     * 중위 방문
     */
    static void middleVisit(int visitIndex,String[][] tree){
        //다음 방문노드 결정
        int first,second;
        first=searchNode(tree, tree[visitIndex][1]);
        second=searchNode(tree,tree[visitIndex][2]);
        if(first != -1)
            middleVisit(first, tree);
        //왼쪽갓다온뒤 출력
        System.out.print(tree[visitIndex][0]);

        if(second != -1)
            middleVisit(second, tree);

    } 

    /** 
     * 후위 방문
     */
    static void afterVisit(int visitIndex,String[][] tree){
        //다음 방문노드 결정
        int first,second;
        first=searchNode(tree, tree[visitIndex][1]);
        second=searchNode(tree,tree[visitIndex][2]);
        if(first != -1)
            afterVisit(first, tree);
        if(second != -1)
            afterVisit(second, tree);
        System.out.print(tree[visitIndex][0]);

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
