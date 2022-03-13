
class Solution {
	int money;
 	int[] costs,moneys={1,5,10,50,100,500};
	int min=Integer.MAX_VALUE;
  public int solution(int money, int[] costs) {
    this.money=money;
    this.costs=costs;
    make_eff();
    rec_func(5,0);    
    return min;
	}
  void rec_func(int k ,int cost ){
    if(k == -1){
     if(0 == money)
        min=Math.min(min,cost);        
    }
    else{
      //큰 동전부터하자.
      int i=money/moneys[k];
      money=money-i*moneys[k];
      cost=cost+i*costs[k];
      rec_func(k-1,cost);
    }
  }
  void make_eff(){
    for(int i=0;i<moneys.length;i++){
      for(int j=0;j<moneys.length;j++){
        if((float)costs[i]/moneys[i] > (float)costs[j]/moneys[j]){
          int temp=moneys[i];
          moneys[i]=moneys[j];
          moneys[j]=temp;
          int tempC=costs[i];
          costs[i]=costs[j];
          costs[j]=tempC;
        }
      }
    }
  }
}
