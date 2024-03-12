import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[][] relation) {
        List<Set<Integer>> candidateKeys = new ArrayList<>();
        
        int col = relation[0].length;
        int row = relation.length;
        
       
        
        //조합 1부터 col개 까지 돌려서 부분집합 생성
        for(int i=1; i<=col; i++){
            //확인할 예비후보키 조합
            List<Set<Integer>> result = new ArrayList<>();
             //조합 완탐때 사용할 Set
            Set<Integer> list = new HashSet<>();
            combi(result,list,0,i,col,0);
        
        
            for(Set<Integer> cols : result){
                boolean check = true;
            //최소성 확인
            for(Set<Integer> key : candidateKeys){
                if(cols.containsAll(key)){
                    check = false;
                    break;
                }
            }
                if(!check){
                    continue;
                }
            //유일성 확인
            HashSet<String> hashsb = new HashSet<>();
            for(int r=0; r<row; r++){
                StringBuilder sb = new StringBuilder();
                for(Integer c : cols){
                    sb.append(relation[r][c]);
                }
                hashsb.add(sb.toString());
            }
            if(hashsb.size()==row){
                candidateKeys.add(new HashSet<>(cols));
                System.out.println(candidateKeys);
            }
        }
     }
        return candidateKeys.size();
    }
    void combi(List<Set<Integer>> result , Set<Integer> list, int k, int n, int col, int start){
        if(k == n){
            result.add(new HashSet<>(list));
            return;
        }
        for(int i=start; i<col;i++){
            list.add(i);
            combi(result,list,k+1,n,col,i+1);
            list.remove(i);
        }
    }
}