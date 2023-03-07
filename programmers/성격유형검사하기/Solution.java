package programmers.성격유형검사하기;

/**
 * 문제링크
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class Solution {

    public static void main(String[] args) {
        Solve solve=new Solve();
    }
}
class Solve{
    public String solution(String[] survey,int[] choices) {
        String answer="";
        int[] score=new int[26];//a~z까지 만들고 r,t,c,f,j,m,a,n에만 저장하자
        for(int i=0;i<choices.length;i++){
            if(choices[i] < 4){
                score[survey[i].charAt(0) - 'A'] += 4 - choices[i] ;
            }
            else if (choices[i] > 4){
                score[survey[i].charAt(1) - 'A'] += choices[i] - 4;
            }
        }
        //문자열 만들자.
        StringBuilder sb=new StringBuilder();
        sb.append(getType(score, 'R', 'T'));
        sb.append(getType(score, 'C', 'F'));
        sb.append(getType(score, 'J', 'M'));
        sb.append(getType(score, 'A', 'N'));
        answer=sb.toString();
        return answer;
    }
    public char getType(int[] score,char type1,char type2){
        if(score[type1 - 'A'] >= score[type2 -'A']){
            return type1;
        }
        else{
            return type2;
        }
    }
}
