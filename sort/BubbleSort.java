import java.util.Arrays;

public class BubbleSort {
    /** 
     * 전달인자 int[]을 버블소트로 오름차순 정렬한다.
     */
    public static void bubblesort(int[] array,int n){
        //부분 정렬을 몇번할지 n-1개 해야한다.
        for(int i=0;i<n-1;i++){
            //비교해서 정렬할 범위
            //1번 정렬할때마다 정렬할 수가 줄어든다.
            for(int j=0;j<n-1-i;j++){
                if(array[j] > array[j+1])
                    swap(array,j,j+1);
            }
            System.out.println(Arrays.toString(array));
        }
    }
    /**
     * array의 index1의 값과 index2의 값을 변경
     */
    private static void swap(int[] array,int index1,int index2){
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }

}
