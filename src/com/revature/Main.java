package com.revature;

import java.util.*;
import com.revature.Solution;

public class Main {

    public static void main(String args[]) {

        ArrayList<String> answer= new ArrayList<String>();
        System.out.println("How many projects are there?");
        Scanner scan = new Scanner(System.in);
        int projects = scan.nextInt();
        System.out.println("Enter the projects one character at a time.");
        for (int i = 0; i < projects+1; i++){
            answer.add(scan.nextLine());
        }

        int vertices = answer.size();
        Solution.Graph graph = new Solution.Graph(vertices);
        System.out.println("Please enter the amount of dependecies.");
        int dependencies = scan.nextInt();

        //Necessary for next blank line to be omitted
        scan.nextLine();
        System.out.println("Enter the value press enter then its dependency and press enter.");
        try {
            for (int i = 0; i < dependencies; i++){
                graph.addEgde(scan.nextLine(), scan.nextLine(), answer);
            }
            graph.topologicalSorting(answer);
        }
        catch (Exception e){
            System.out.println("Could not find a solution!");
        }

    }

}
