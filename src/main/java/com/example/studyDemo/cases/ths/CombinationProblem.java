package com.example.studyDemo.cases.ths;

import java.util.ArrayList;

/**
 * @Author: hao wu
 * @Date： 2023/2/24 14:01
 */
public class CombinationProblem {

    public static ArrayList<ArrayList<String>> getSetCombination(ArrayList<ArrayList<String>> input) {

        ArrayList<ArrayList<String>> result = new ArrayList<>();
        int numSets = input.size();
        if (numSets == 0) {
            return result;
        }
        //记录当前每个集合中被选择的元素的下标
        int[] index = new int[numSets];
        //记录所有子集合的大小
        int[] subSize = new int[numSets];
        for (int i = 0; i < numSets; i++) {
            subSize[i] = input.get(i).size();
        }
        while (true) {
            ArrayList<String> combination = new ArrayList<>();
            for (int i = 0; i < numSets; i++) {
                combination.add(input.get(i).get(index[i]));
            }
            result.add(combination);
            int j = numSets - 1;
            //从深到浅，每层遍历
            while (j >= 0 && index[j] == subSize[j] - 1) {
                index[j] = 0;
                j--;
            }
            if (j < 0) {
                break;
            }
            index[j]++;
        }
        return result;
    }


    public static void main(String[] args) {
        //TODO some test case
        ArrayList<ArrayList<String>> cases=new ArrayList<>();
        ArrayList<String> sub1 = new ArrayList<>();
        sub1.add("a");
        sub1.add("b");
        sub1.add("c");
        cases.add(sub1);
        ArrayList<String> sub2 = new ArrayList<>();
        sub2.add("1");
        sub2.add("2");
        sub2.add("3");
        sub2.add("4");
        sub2.add("5");
        sub2.add("6");
        cases.add(sub2);
        ArrayList<String> sub3 = new ArrayList<>();
        sub3.add("A");
        sub3.add("B");
        sub3.add("C");
        sub3.add("D");
        cases.add(sub3);
        ArrayList<String> sub4 = new ArrayList<>();
        sub4.add("X");
        sub4.add("Y");
        sub4.add("Z");
        cases.add(sub4);
        System.out.println(getSetCombination(cases));
    }


}
