package com.company.arsh_goyal.week1;

import java.util.*;

class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }

}
public class number_of_ways_arriving_at_destination {
    public static int mod= (int) (1e9+7);
    public static void main(String[] args) {
        int[][] edges = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        System.out.println(countPaths(7,edges));
    }
    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i :roads){
            adj.get(i[0]).add(new Pair(i[1],i[2]));
            adj.get(i[1]).add(new Pair(i[0],i[2]));
        }
        int []steps=new int[n];
        int []distance=new int[n];
        Arrays.fill(distance,(int)Math.pow(10,9));
        distance[0]=0;
        steps[0]=1;
        PriorityQueue<Pair>q= new PriorityQueue<>((x,y)-> x.i- y.i);
        q.add(new Pair(0,0));
        while (!q.isEmpty()){
            Pair t=q.poll();
            int curr=t.j;
            int dist=t.i;
            for(Pair op:adj.get(curr)){
                int new_curr=op.i;
                int new_dist=op.j;
                if(distance[new_curr]==dist+new_dist){
                    steps[new_curr]=(steps[curr]+steps[new_curr])%(mod);
                }
                else if(distance[new_curr]>dist+new_dist){
                    distance[new_curr]=dist+new_dist;
                    q.add(new Pair(new_dist+dist,new_curr));
                    steps[new_curr]=steps[curr];
                }
            }
        }
        System.out.println(Arrays.toString(steps));
        return steps[n-1];
    }
}
