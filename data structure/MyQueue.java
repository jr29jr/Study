import java.util.ArrayList;
class MyQueue<T> {
  private ArrayList<T> queue=new ArrayList<T>();
  
  public void enqueue(T num){
    queue.add(num); 
  }
  
  public T dequeue(){
    if(queue.isEmpty())
      return null;
    return queue.remove(0);
  }
  
  public boolean isEmpty(){
    return queue.isEmpty();
  }  
  
}
