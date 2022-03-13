import java.util.ArrayList;

public class MyStack<T>{
  private ArrayList<T> myStack;
  public MyStack(){
    myStack=new ArrayList<T>();
  }
  public MyStack(int size){
    myStack=new ArrayList<T>(size);
  }
  public void push(T num){
    myStack.add(num);
  }
  public T pop(){
    if(myStack.isEmpty())
      return null;
    return myStack.remove(myStack.size()-1);
  }
  public boolean isEmpty(){
    return myStack.isEmpty();
  }
  public int size(){
    return myStack.size();
  }
}
