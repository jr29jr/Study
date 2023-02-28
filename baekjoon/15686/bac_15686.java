package backjoon;

import java.io.*;
import java.util.*; 

class Location{
    int row;
    int col;
    
    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }
    
}
public class bac_15686 {

    public static void main(String[] args) {
        input();
        process(map, N, M);
        System.out.println(answer);
    }
    
    static int N,M;
    static int[][] map;
    static void input(){
        FastReader fr=new FastReader();
        N=fr.nextInt();
        M=fr.nextInt();

        map=new int[N][N];

        

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                map[i][j]=fr.nextInt();
            }
        }
    }
    
    static void process(int[][] map,int mapSize,int shopCount){       
        //집의 위치 리스트 
        List<Location> houses=new ArrayList<Location>();              
        //치킨집의 위치 리스트
        List<Location> shops=new ArrayList<Location>();
        //치킨집,집 위치 리스트 생성
        calcLocation(houses, shops, map, mapSize);

        List<Location> visitedShops=new ArrayList<>();
        //시작점부터 방문
        int visit=0;
        selectShops(0, shopCount, houses, shops, visit, visitedShops);
        
    }
    static int answer=Integer.MAX_VALUE;
    /**
     * 
     * @param now 현재 정해질 샵의 개수
     * @param shopCount 정해야할 개수
     * @param shops
     */
    static void selectShops(int now,int shopCount,List<Location> houses,List<Location> shops,int visit,List<Location> visitedShops){
        if(now == shopCount){
            //치킨집에서 집까지 거리의 합들 구하기
            int result=calcDistance(houses, visitedShops);
            //거리가 최소인지 확인하자.
            answer=Math.min(answer,result);
        }

        for(int i=visit;i<shops.size();i++){
            visitedShops.add(shops.get(i));
            selectShops(now+1, shopCount, houses, shops,i+1, visitedShops);
            visitedShops.remove(visitedShops.size()-1);
        }
    }
    
    static int calcDistance(List<Location> houses,List<Location> visitedShops){
        int sum=0;
        for(Location house : houses){
            int min=Integer.MAX_VALUE;
            for (Location shop : visitedShops){
                int distance = Math.abs(house.row - shop.row) + Math.abs(house.col - shop.col);
                min=Math.min(min,distance);
            }
            sum+=min;
        }

        return sum;
    }

    static void calcLocation(List<Location> houses,List<Location> shops,int[][] map,int mapSize){
        for(int i=0;i<mapSize;i++){
            for(int j=0;j<mapSize;j++){
                if(map[i][j]== 1)
                    houses.add(new Location(i, j));
                else if(map[i][j] == 2)
                    shops.add(new Location(i, j));
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

