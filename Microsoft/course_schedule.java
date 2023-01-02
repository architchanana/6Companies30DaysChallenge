package com.company.arsh_goyal.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class course_schedule {
    public static void main(String[] args) {

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[]indegree=new int[numCourses];
        ArrayList<ArrayList<Integer>>s=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            s.add(new ArrayList<>());
        }
        for(int []i:prerequisites){
            s.get(i[0]).add(i[1]);
        }
        for(int i=0;i<s.size();i++){
            for(int j=0;j<s.get(i).size();j++){
                indegree[s.get(i).get(j)]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        while (!q.isEmpty()){
            count++;
            int t=q.poll();
            for(int i:s.get(t)){
                indegree[i]--;
                if(indegree[i]==0){
                    q.add(i);
                }
            }
        }
        return count==numCourses;
    }
}
