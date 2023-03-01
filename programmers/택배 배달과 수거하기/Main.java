package programmers.택배배달과수거하기;

public class Main {

    public static void main(String[] args) {
        int cap=4;
        int n=5;
        int[] deliveries={1,0,3,1,2};
        int[] pickups={0,40,0,4,0};
        Solve solve=new Solve();
        solve.solution(cap, n, deliveries, pickups);
    }
}
class Solve{
    public int[] calcStartAndEnd(int cap,int end,int[] list){
        int[] result=new int[2];//start,end 저장
        int arrive=-1,start=-1;
        for(int i=end;i>=0;i--){
            //어디까지 갈지 정해야한다.
            if(list[i] != 0){
                //택배를 배달하는 과정
                arrive=i;
                while(cap > 0){
                    //여기까지만 배달인 경우
                    if(list[i] >=cap){
                        list[i]-=cap;
                        cap=0;
                    }
                    else if( cap > list[i]){
                        cap-=list[i];
                        list[i]=0;
                        i--;
                        if( i == -1)
                            break;
                    }
                }
                //남으면 -1까지 갈 수 있을것이다.
                start=i;
                break;
            }
        }
        result[0]=start;
        result[1]=arrive;
        return result;

    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long result=0;
        int darrive=-1,parrive=0;
        //처음엔 마지막 지점 계산해주자.
        for(int i=n-1;i>=0;i--){
            if(deliveries[i] != 0){
                darrive=i;
                break;
            }
        }

        for(int i=n-1;i>=0;i--){
            if(pickups[i] != 0){
                parrive=i;
                break;
            }
        }

        while(true){
            //뒤에서부터 처리한다는 마인드
            int[] dInfo=calcStartAndEnd(cap,darrive, deliveries);
            darrive=dInfo[0];
            int[] pInfo=calcStartAndEnd(cap,parrive, pickups);
            parrive=pInfo[0];
            result+=(Math.max(dInfo[1],pInfo[1])+1)*2;
            if( dInfo[0] == -1 && pInfo[0] == -1){
                break;
            }
        }        
       
        return result;
    }
}