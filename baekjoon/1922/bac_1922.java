package backjoon;

import java.io.*;
import java.util.*; 

class Edge implements Comparable<Edge>{
    int[] node;//연결된 노드정보
    int distance;//연결거리

    public Edge(int node1,int node2, int distance) {
        this.node=new int[2];
        this.node[0] = node1;
        this.node[1] = node2;
        this.distance = distance;
    }

    public int[] getNode() {
        return this.node;
    }

    public void setNode(int[] node) {
        this.node = node;
    }

    public int getDistance() {
        return this.distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    @Override
    public String toString() {
        return "{" +
            " node='" + getNode()[0]+", "+getNode()[1] + "'" +
            ", distance='" + getDistance() + "'" +
            "}";
    }

    @Override
    public int compareTo(Edge o) {
        return Comparator.comparingInt(Edge::getDistance).compare(this, o);
    }
}

public class bac_1922 {
   
    public static void main(String[] args) {
        input();
        process();
    }
    
    static int edgeCount,nodeCount;
    static PriorityQueue<Edge> edges;
    static void input(){
        FastReader fr=new FastReader();
        nodeCount = fr.nextInt();
        edgeCount = fr.nextInt();

        edges=new PriorityQueue<>();
        for(int i=0;i<edgeCount;i++){
            //a,b같은경우는 무시하자.
            int node1=fr.nextInt(),node2=fr.nextInt();
            int distance=fr.nextInt();
            edges.add(new Edge(node1, node2, distance));
        }
    }

    static void process(){
        //크루스칼 알고리즘
        //가장 짧은 노드를 뽑아다가 연결하는거 반복이다.
        int result=kruskal(edges);
        System.out.println(result);
    }
    static int kruskal(PriorityQueue<Edge> edges){
        int result=0;
        //부모 배열을 만들자.
        int[] parents=new int[nodeCount+1];
        for(int i=0;i<parents.length;i++)
            parents[i]=i;

        
        while(!edges.isEmpty()){
            Edge now=edges.poll();
            int node1=now.node[0],node2=now.node[1];
            int distance=now.distance;
            //자기자신 확인
            if(node1 == now.node[1])
                continue;
            
            //사이클을 존재
            if(hasCycle(parents, node1,node2))
                continue;
            else{
                //부모설정
                setParents(parents, node1, node2);
                //거리 계측
                result+=distance;
            }
            
        }   
        return result;
    }
    static boolean hasCycle(int[] parents,int node1,int node2){
        //두 노드의 부모가 같으면 사이클이 존재한다.
        if(getParent(parents, node2) == getParent(parents, node1))
            return true;

        return false;
    }
    //연결된 노드의 부모를 갱신
    static void setParents(int[] parents,int node1,int node2){
        int parent1=getParent(parents, node1);
        int parent2=getParent(parents, node2);
        //자기랑 엮인 애들을 다 바꿔주자.
        if(parent1 < parent2){
            for(int i=0;i<parents.length;i++)
                if(parents[i] == parent2)
                    parents[i]=parent1;
            //난 여기서 반복문이 맞다봤다.
        }
        else{
            for(int i=0;i<parents.length;i++)
                if(parents[i] == parent1)
                    parents[i]=parent2;
            //난 여기서 반복문이 맞다봤다.
        }
    }
    //여기서 그래서 갱신하는건가?
    static int getParent(int[] parents,int node){
        if(parents[node] == node)
            return node;
        else
            return getParent(parents, parents[node]);
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

