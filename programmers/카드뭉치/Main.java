package programmers.카드뭉치;

public class Main {

    public static void main(String[] args) {
        String[] card1={"a","b","c"};
        String[] card2={"d","e"};
        String[] res={"b", "c","d","e"};
        String result=solution(card1, card2, res);
        System.out.println(result);
    }
    
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int card1Index=0,card2Index=0;
        for(String item : goal){
            //중간부터 쓰는게 불가능
           if(card1Index < cards1.length && cards1[card1Index].equals(item)){
               card1Index++;
               continue;
           }
            if(card2Index < cards2.length && cards2[card2Index].equals(item)){
               card2Index++;
                continue;
           }
            answer="No";
            break;
        }
        return answer;
    }
}
