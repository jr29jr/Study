import java.util.*;

public class BubbleSort {
    //오름차순
    static void sort(int[] array,int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<=size-2-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }
}
