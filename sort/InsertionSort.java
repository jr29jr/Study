import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] array={3,2,10,302,9,15,1,7,2};
        InsertionSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
    /**
     * array를 삽입정렬로 오름차순으로 정렬
     * @param array 정렬할 int 배열
     */
    public static void sort(int[] array){
        //삽입정렬은 2번째방부터 진행한다.
        for(int i=1;i<array.length;i++){
            //i1번과 비교를 시작해서 0번까지 진행한다
            for(int j=i;j>0;j--){
                //앞이 클 경우
                if(array[j-1] > array[j])
                    swap(j-1,j,array);
                //앞이 크지않을 경우
                else
                    break;
            }
        }
    }
    /**
     * index1,index2번째 방의 값을 스왑하는 함수
     * @param index1 스왑할 index 번호
     * @param index2 스왑할 index 번호
     * @param array 스왑할 배열
     */
    private static void swap(int index1,int index2,int[] array){
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
        
    }
}
