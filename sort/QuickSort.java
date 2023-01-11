public class QuickSort {
    public void quicksort(int start,int end,int[] array){
        //부분 정렬하고 part2의 시작점을 반환한다.
        int part2Start = partition(start,end,array);
        //작은값 부분
        //System.out.println(Arrays.toString(array));
        if(start < part2Start-1)
            quicksort(start, part2Start-1, array);
        //큰값 부분 
        if(part2Start < end){
            quicksort(part2Start, end, array);
        }
        
    }
    /**
     * pivot을 정해서 pivot보다 작은값들(part1),pivot , pivot보다 큰값들(part2)으로 부분정렬하는 함수
     * @param start 배열의 시작
     * @param end 배열의 끝
     * @param array 배열
     * @return 큰값의 시작점
     */
    private int partition(int start,int end,int[] array){
        //pivot은 중앙값으로 설정
        int pivot=array[(start+end)/2];
        //start 지점이 end 지점보다 작거나 같을때까지(같은 경우가 빠지면 문제가 생긴다.)
        while(start <= end){
            //array[start]가 pivot보다 큰거나 같은 값을 찾는다.
            while(array[start] < pivot){
                start++; 
            }
            //array[end] 가 pivot보다 작거나 같을때까지
            while(array[end] > pivot){
                end--;
            }
            //start가 end보다 작거나 같을경우.
            if(start <= end){
                swap(start,end,array);
                //스왑을 했으면 start증가,end를 감소시킨다.
                start++;
                end--;
            }
        }
        return start;
    }
    private void swap(int start,int end,int[] array){
        int temp=array[start];
        array[start]=array[end];
        array[end]=temp;
    }
}

