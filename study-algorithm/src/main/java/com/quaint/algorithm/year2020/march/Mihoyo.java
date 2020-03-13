package com.quaint.algorithm.year2020.march;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author quaint
 */
public class Mihoyo {


    public static void main(String[] args) {

        String s = minRemove("(mi(h(o)yo)");
        System.out.println(s);

    }
    /**
     *
     * @param s string字符串 
     * @return string字符串
     */
    public static String minRemove (String s) {
        // write code here
        Stack<String> stack = new Stack<>();

        char[] chars = s.toCharArray();
        List<Integer> ids = new ArrayList<>();
        List<Integer> rmIds = new ArrayList<>();


        for (int i = 0; i < chars.length; i++) {

            if (chars[i]=='('){
                stack.push("(");
                ids.add(i);
            }
            if (chars[i]==')'){
                ids.add(i);
                if (stack.isEmpty()){
                    rmIds.add(i);
                }else {
                    String pop = stack.pop();
                    if (pop.equals(")")){
                        rmIds.add(i);
                    }
                }
            }
        }

        int num = 0;
        if (!stack.isEmpty()){
            num = stack.size();
        }

        for (int k = ids.size()-1;k > ids.size()-num-1; k--){
            rmIds.add(ids.get(k));
        }

        String outPut = "";
        for(int i = 0 ;i<chars.length;i++){
            if (!rmIds.contains(i)){
                outPut = outPut + chars[i];
            }

        }

        return outPut;
    }
}