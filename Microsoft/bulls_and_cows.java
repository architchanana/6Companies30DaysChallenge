package com.company.arsh_goyal.week1;

import java.util.HashMap;

public class bulls_and_cows {
    public static void main(String[] args) {
        String secret = "1807", guess = "7810";
        System.out.println(getHint(secret,guess));
    }
    public static String getHint(String secret, String guess) {
        int correct=0;
        int incorrect=0;
        HashMap<Character,Integer>s=new HashMap<>();
        for(int i=0;i<secret.length();i++){
            s.put(secret.charAt(i),s.getOrDefault(secret.charAt(i),0)+1);
        }
        boolean []oy=new boolean[guess.length()];
        int m=Math.min(secret.length(),guess.length());
        for(int i=0;i<m;i++){
            if(secret.charAt(i)==guess.charAt(i) && s.containsKey(guess.charAt(i))){
                correct++;
                oy[i]=true;
                int t=s.get(secret.charAt(i));
                s.remove(secret.charAt(i));
                if(t>1){
                    s.put(secret.charAt(i),t-1);
                }
            }
            System.out.println(s);
        }
        for(int i=0;i<m;i++){
            if(!oy[i] && s.containsKey(guess.charAt(i))){
                incorrect++;
                oy[i]=true;
                int t=s.get(guess.charAt(i));
                s.remove(guess.charAt(i));
                if(t>1){
                    s.put(guess.charAt(i),t-1);
                }

            }
        }
        System.out.println(s);
        return String.valueOf(correct)+"A"+String.valueOf(incorrect)+"B";
    }

}
