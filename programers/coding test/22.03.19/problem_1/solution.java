import java.util.*;
public class Solution {
    //문자열의 부분배열을 구하는 함수
    static List<String> subString(String str){
        List<String> list=new ArrayList<String>();
        //1~N개까지
        for(int i=1;i<=str.length();i++){
            for(int j=0;j<=str.length()-i;j++){
                list.add(str.substring(j,j+i));
            }
        }
        return list;
    }
    //차집합을 구하면된다.
    public List<List<String>> solve(List<List<String>> list){
        List<List<String>> result=new ArrayList<List<String>>();
        for(int i=0;i<list.size();i++){
            //원본은 놔두고 복사해서 해야한다.
            List<String> temp=new ArrayList<String>(list.get(i));
            for(int j=0;j<list.size();j++){
                if(i == j)
                    continue;
                //원본은 놔두고 복사해서 넣어야한다.
                temp.removeAll(list.get(j));
            }
            result.add(temp);
        }
        return result;
    }
    //최소 크기만 남기기,중복 제거,소트
    public void cut(List<List<String>> list){
        //최소 크기 남기기
        for(int i=0;i<list.size();i++){
            List<String> item=list.get(i);
            //최사 사이즈 구함
            if(item.size() > 0){
                int min=item.get(0).length();
                for(int j=0;j<item.size();j++){
                    if(item.get(j).length() > min){
                        //거기부터 다 삭제하고 끝내자
                        item.remove(j);
                        j--;
                    }
                }
            }

        }
        //소트
        for(int i=0;i<list.size();i++)
            Collections.sort(list.get(i));
        //중복제거
        for(int i=0;i<list.size();i++){
            int j=1;
            List<String> item=list.get(i);
            if(list.get(i).size() >= 2){
                String operand1,operand2;
                while(j<item.size()){
                    operand1=item.get(j);
                    operand2=item.get(j-1);
                    if(operand1.equals(operand2)){
                        list.get(i).remove(j);
                        continue;
                    }
                    j++;
                }
            }
        }


    }
    public String[] solution(String[] goods) {
        List<List<String>> subList=new ArrayList<List<String>>();
        for(int i=0;i<goods.length;i++){
            subList.add(subString(goods[i]));
        }

        List<List<String>> ans=solve(subList);
        cut(ans);

        //출력 처리과정
        String[] answer=new String[subList.size()];
        for(int i=0;i<ans.size();i++){
            List<String> item=ans.get(i);
            if(item.size() == 0 ){
                answer[i]="None";
            }
            else{
                String temp="";
                for(int j=0;j<item.size();j++){
                    temp=temp+item.get(j)+" ";
                }
                answer[i]=temp.trim();
            }
        }
        return answer;
    }
}
