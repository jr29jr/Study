
public class MyBST {
  public class Node {
    Node left;
    Node right;
    int value;
    public Node (int data) {
        this.value = data;
        this.left = null;
        this.right = null;
    }
  }
  Node head = null;
  
  public boolean insertNode(int data){
      //노드가 없는 경우
      if(this.head == null){
          head=new Node(data);
      }
      else {
          Node findNode=this.head;
          while(true){
              //노드가 왼쪽
              if(data<findNode.value){
                  //비었을 경우
                  if(findNode.left == null){
                      findNode.left=new Node(data);
                      break;
                  }
                  //있을 경우
                  else{
                      findNode=findNode.left;
                  }
              }
              //노드가 오른쪽
              else{
                  //비었을 경우
                  if(findNode.right == null){
                      findNode.right=new Node(data);
                      break;
                  }
                  //있을 경우
                  else{
                      findNode=findNode.right;
                  }
              }                
          }
      }
      return true;
  }

  public void printValue(int value){
    Node result=search(value);
    if (result != null){
      System.out.println(result.value);
    }
    else
      System.out.println("-1");
  }
  public Node search(int data){
      if(this.head != null){
          Node findNode=this.head;
          while(findNode != null){
              if(findNode.value == data)
                  return findNode;
              else if(data < findNode.value){
                  findNode=findNode.left;
              }
              else{
                  findNode=findNode.right;
              }
          }
          //데이터가 없을 경우
          return null;
      }
      else{
          //빈 bst일 경우
          return null;
      }
  }
  
   public boolean delete(int value) {
        Node currentNode=this.head;
        Node parentNode=null;
        Integer location=0;//1이면 왼쪽,2면 오른쪽
        if(this.head == null){
            return false;
        }
        else{
            //삭제할 노드 찾는 과정
            while(currentNode != null){
                if(currentNode.value == value){
                    break;
                }
                else if(currentNode.value > value){
                    parentNode=currentNode;
                    currentNode=currentNode.left;
                    location=1;
                }
                //value가 더 클 경우
                else{
                    parentNode=currentNode;
                    currentNode=currentNode.right;
                    location=2;
                }
            }
            //value가 있을 경우
            if(currentNode !=null){
                //리프일 경우
                if(currentNode.left == null && currentNode.right == null){
                    //리프면서 헤드일 경우
                    if(currentNode == this.head){
                        this.head=null;
                        return true;
                    }
                    //헤드 아닐 경우
                    else{
                        if(location == 1){
                            parentNode.left=null;
                        }
                        else{
                            parentNode.right=null;
                        }
                        return true;
                    }
                }
                //차일드가 1개일 경우
                else if(currentNode.left == null || currentNode.right == null){
                    //왼쪽 자식
                    if(currentNode.left != null){
                      //헤드가 아닐 경우
                      if(parentNode != null){
                        if(location == 1){
                            parentNode.left=currentNode.left;
                        }
                        else{
                            parentNode.right=currentNode.left;
                        }
                      }
                      //헤드일 경우
                      else{
                        this.head=currentNode.left;                                        
                      }
                        
                    }
                    //오른쪽 자식
                    else{
                      if(parentNode !=null){
                        if(location == 1){
                            parentNode.left=currentNode.right;
                        }
                        else{
                            parentNode.right=currentNode.right;
                        }
                      }
                      else{
                        this.head=currentNode.right;
                      }
                        
                    }
                    return true;
                }
                //차일드가 2개일 경우
                else{                   
                    Node currentNodeLeft=currentNode.left;
                    Node currentNodeRight=currentNode.right;
                    Node leftParent=currentNode;//새로 들어갈 노드의 부모
                    currentNode=currentNode.right;
                    //오른쪽 노드의 왼쪽 자식이 없을 경우
                    if(currentNode.left == null){
                      currentNodeRight=currentNode.right;
                    }
                    else{
                      //맨 왼쪽 찾음.
                      while(currentNode.left != null){
                          leftParent=currentNode;
                          currentNode=currentNode.left;
                      }
                      //leftParent 자식을 연결
                      leftParent.left=currentNode.right;
                    }                   
                   
                    //제거된 노드의 부모와 left를 연결
                    if(parentNode != null){
                      if(location ==1)
                        parentNode.left=currentNode;
                      else
                        parentNode.right=currentNode;
                    }
                    else{
                      this.head=currentNode;
                    }  
                    //새 노드의 왼쪽 연결
                    currentNode.left=currentNodeLeft;
                    //새 노드의 오른쪽 연결
                    currentNode.right=currentNodeRight;
                    
                    return true;
                    
                }
            }
            //value가 없을 경우
            else{
                return false;
            }
        }
    }
}
