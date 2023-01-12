import java.util.Arrays;

public class SelectionSort{
    /**
     * 오름차순 선택정렬한다.
     * @param start 부분정렬 시작점
     * @param end 끝점
     * @param array 정렬할 리스트
     * 
     * 오름차순 선택정렬은 부분정렬이 끝나면 맨앞부터 정렬된다.
     * start부터 end까지 정렬할때까지 재귀호출한다.
     */
    public static void sort(int start,int end,int[] array){
        //모든 정렬 끝
        if(start == end)
            return ;
        int min=Integer.MAX_VALUE,minIndex=-1;//작은 값과 그 방의 index 저장
    
        for(int i=start;i<=end;i++){
            //가장 작은 값과 그 방의 index구하는 부분
            if(min > array[i]){
                min=array[i];
                minIndex=i;
            }
        }
        //가장 작은 값과 start 지점을 swap
        int temp=array[start];
        array[start]=array[minIndex];
        array[minIndex]=temp;  
        System.out.println(Arrays.toString(array));
        //start가 끝났으니 start+1부터 end까지 비교해서 정렬
        sort(start+1, end, array);
    }
}