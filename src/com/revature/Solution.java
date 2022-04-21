package com.revature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    static class Node {
        String placement;
        String value;

        Node(String value, String placement) {
            this.placement = placement;
            this.value = value;
        }
    }

    static class Graph{
        int vertices;
        LinkedList<Node>[] adjustList;

        Graph(int vertices){
            this.vertices = vertices;
            adjustList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++){
                adjustList[i] = new LinkedList<Node>();
            }
        }

        public void addEgde(String value, String placement, ArrayList<String> answer){
            Node node = new Node(value, placement);
            adjustList[answer.indexOf(value)].addFirst(node);

        }

        public void topologicalSorting(ArrayList<String> answer){
            boolean[] visited = new boolean[vertices];
            Stack<String> stack = new Stack<String>();
            try {
                for (int i = 0; i < vertices; i++){
                    if (!visited[i]) {
                        topologicalSortUtil(answer.get(i), visited, stack, answer);
                    }
                }
                System.out.println("Answer is: ");
                int size = stack.size();
                for (int i = 0; i < size; i++) {
                    System.out.print(stack.pop() + " ");
                }
            }
            catch (Exception e) {
                System.out.println("Dependency issue please check the accuracy of your input, one dependency may " +
                        "have an issue");
            }

        }
        public void topologicalSortUtil(String test, boolean[] visited, Stack<String> stack, ArrayList<String> answer){
            int index = answer.indexOf(test);
            visited[index] = true;
            for (int i = 0; i < adjustList[answer.indexOf(test)].size(); i++){
                Node node = adjustList[index].get(i);
                    for (int j = i+1; j < adjustList[answer.indexOf(test)].size(); j++){
                        System.out.println("Checking dependencies...");
                        if(adjustList[index].get(j).placement != node.value &&
                            adjustList[index].get(j).value != node.placement){
                            System.out.println(node.value + node.placement + " duplicate value entered");
                        }

                    }

                if(!visited[answer.indexOf(node.placement)])
                    topologicalSortUtil(node.placement, visited, stack, answer);
            }
            stack.push(test);
        }



    }

}
