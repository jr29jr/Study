public class DoubleLinkedList<T>{
  public Node<T> head=null;
  public Node<T> tail=null;

  public class Node<T>{
    T data;
    Node<T> prev=null;
    Node<T> next=null;

    public Node(T data){
      this.data=data;
    }
  }

  public void addNode(T data){
    if(this.head==null){
      this.head=new Node<T>(data);
      this.tail=this.head;
    }
    else{
      Node<T> node=this.head;
      while(node.next != null){
        node=node.next;
      }
      node.next=new Node<T>(data);
      node.next.prev=node;
      this.tail=node.next;
      
    }
  }
  public void printAll(){
    if(this.head == null)
      return ;

    Node<T> node=this.head;
    while(node != null){
      System.out.println(node.data);
      node=node.next;
    }
  }

   public void printAllFromTail(){
    if(this.head == null)
      return ;

    Node<T> node=this.tail;
    while(node != null){
      System.out.println(node.data);
      node=node.prev;
    }
  }
  public T searchFromHead(T data){
    if(this.head == null)
      return null;
    else{
       Node<T> node=this.head;
      while(node != null){
        if(node.data == data){
          return node.data;
        }
        else{
          node=node.next;
        }
      }
      return null;
    }
  }

  public T searchFromTail(T data){
    if(this.head == null)
      return null;
    else{
      Node<T> node=this.tail;
      while(node != null){
        if(node.data == data){
          return node.data;
        }
        else{
          node=node.prev;
        }
      }
      return null;
    }
  }

  public boolean insertToFront(T data,T target){
    if(this.head == null){
      this.head=new Node<T>(data);
      this.tail=this.head;
      return true;
    }
    else if(this.head.data == target){
      Node<T> insert=new Node<T>(data);
      insert.next=this.head;
      this.head.prev=insert;
      this.head=insert;
      return true;
    }
    else{
      Node<T> node=searchNode(target);
      //없는 노드엔 추가 불가능
      if(node == null)
        return false;
      Node<T> insert=new Node<T>(data);
      node.prev.next=insert;
      insert.prev=node.prev;
      insert.next=node;
      node.prev=insert;
      return true;
    }
  }

  public Node<T> searchNode(T data){
    Node<T> node=this.head;
    while(node != null){
      if(node.data==data)
        return node;
      node=node.next;
    }
    return null;
  }
}
