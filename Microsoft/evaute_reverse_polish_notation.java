package com.company.arsh_goyal.week1;

import java.util.Objects;
import java.util.Stack;

public class evaute_reverse_polish_notation {
    public static void main(String[] args) {
        String []tokens = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        Stack<String>s=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            System.out.println(s);
            if(Objects.equals(tokens[i], "*") || Objects.equals(tokens[i], "-") || Objects.equals(tokens[i], "/") || Objects.equals(tokens[i], "+")){
                int res=0;
                String str1=s.pop();
                String str2=s.pop();
                int a=Integer.parseInt(str1);
                int b=Integer.parseInt(str2);
                if(Objects.equals(tokens[i], "*")){
                    res=res+a*b;
                }
                else if(Objects.equals(tokens[i], "+")){
                    res=res+a+b;
                }
                else if(Objects.equals(tokens[i], "-")){
                    res=res+b-a;
                }
                else if(Objects.equals(tokens[i], "/")){
                    res=res+b/a;
                }
                s.push(String.valueOf(res));
            }
            else{
                s.push(tokens[i]);
            }
        }
        return Integer.parseInt(s.pop());
    }
}
