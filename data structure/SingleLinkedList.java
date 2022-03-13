public class SingleLinkedList<T>{
  public Node<T> head=null;
  
  public class Node<T>{
    T data;
    Node<T> next=null;
    
    public Node(T data){
      this.data=data;
    }
  }
  
  public void add(T data){
    if(head == null){
      head=new Node<T>(data);
    }
    else{
      Node<T> node=this.head;
      while(node.next != null){
        node=node.next;
      }
      node.next=new Node<T>(data);
    }
  }
  //frontData가 있는 노드뒤에 연결
  public void addNodeBefore(T data,T frontData){
    Node<T> searchNode=this.search(frontData);
    if(searchNode == null){
      this.add(data);
    }
    else{
      Node<T> next=searchNode.next;
      searchNode.next=new Node<T>(data);
      searchNode.next.next=next;        
    }
  }
  //data가 있는 노드 찾음
  public Node<T> search(T data){
    if(this.head == null)
      return null;
    
    Node<T> target=this.head;
    while(target.next != null){
      if(target.data == data)
        //break;
        return target;
      else
        target=target.next;
    }
    return null;
  }
  //같은게 다중일 경우 앞의 1개만 제거
  public boolean delNode(T data){
    //빈 리스트일 경우
    if(this.head == null)
      return false;
    
    Node<T> node=this.head;
    //헤드일 경우
    if(node.data == data){
      this.head=node.next;
      return true;      
    }
    //중간일 경우
    while(node.next != null){
      //내가 한거 생각보다 복잡하게 했다
      /*
      Node<T> front=node;
      node=node.next;      
      if(node.data == data){
        front.next=node.next;
        return true;
      }
      */
      //강의에 나온거 나도 이게 낫다고 생각. 
      if(node.next.data==data){
        node.next=node.next.next;
        return true;
      }
      node=node.next;
    }      
    //노드가 없을 경우
    return false;  
  }
  
  //모든 노드 출력하는 함수
  public void printAll(){
    if(head != null){
      Node<T> node=this.head;
      System.out.println(node.data);
      while(node.next != null){
        node=node.next;
        System.out.println(node.data);
      }
    }
  }
  
}
