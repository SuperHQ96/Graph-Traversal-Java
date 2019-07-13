package com.company;

import java.util.Scanner;
import java.util.*;

public class Main {
    public static int no_of_edges;

    public static String cities[] = {"Singapore","Hong Kong", "Beijing", "Perth", "Shanghai", "Tokyo","Jakarta","Seoul","Kuala Lumpur","Taipei"
            ,"Mumbai","Dhaka","Osaka","Hanoi","Manila","Guangzhou","Kyoto","Karachi","Baghdad","Ho Chi Minh",
            "Tehran","Shenzhen","Tianjin","Chongqing","Pyongyang","Macau","Chennai","Phnom Penh","Riyadh","Chengdu",
            "Ankara","Nagoya","Wuhan","Nanjing","Hangzhou","Kobe","Incheon","Kabul","Xi An","Istanbul",
            "Lahore","Suzhou","Yokohoma","Busan","Zhengzhou","Dongguan","Astana","New Delhi","Dubai","Kunming",
            "Bangkok","Doha","Jeju","Bangalore","Changsha","Abu Dhabi","Jeddah","Antalya","Fukuoka","Qingdao",
            "Sapporo","Denpasar","Haikou","Surabaya","Urumqi","Naha","Sanya","Narita","Taoyuan","Sepang"
            ,"Sai Gon","Leh","Hokkaido","Yamagata","Kagoshima","Oita","Ehime","Miyazaki","Kochi","Niigata",
            "Nagasaki","Yamaguchi","Aomori","Fukui","Iwate","Hyogo","Srinagar","Shimla","Kangra","Akita",
            "Kozushima","Saga","Mizoram","Tottori","Lakshadweep","Hyderabad","Toyama","Aichi","Gifu","Saitama"};

    public static void main(String[] args) {
        int choice=0;
        Graph g = new Graph();
        Random rand = new Random();
        Graph.Node[] nodes;
        long start = 0;
        String departure , destination;

        while(choice != 9)
        {
            System.out.println("1. Create a graph of 5 nodes");
            System.out.println("2. Create a graph of 25 nodes");
            System.out.println("3. Create a graph of 50 nodes");
            System.out.println("4. Create a graph of 100 nodes");
            System.out.println("5. Print out the graph");
            System.out.println("6. Use BFS to find fastest route");
            System.out.println("7. Find the average CPU time for the entire graph");
            System.out.println("8. Create a custom graph");
            System.out.println("9. Exit");

            System.out.println("Enter the number of your choice: ");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    no_of_edges = 0;
                    g.clearMap();
                    nodes = new Graph.Node[5];
                    for(int i=0;i<5;i++) {
                        nodes[i] = new Graph.Node(cities[i]);
                        g.addNode(nodes[i]);
                    }
                    for(int i=0;i<4;i++) {
                        if(g.addNeighbor(nodes[i], nodes[i+1])){no_of_edges++;}
                        if(g.addNeighbor(nodes[i+1], nodes[i]));
                    }
                    int temp1,temp2;
                    for(int i=0;i<6;i++) {
                        temp1 = rand.nextInt(5);
                        temp2 = rand.nextInt(5);
                        if(g.addNeighbor(nodes[temp1], nodes[temp2])){no_of_edges++;}
                        if(g.addNeighbor(nodes[temp2], nodes[temp1]));
                    }
                    break;

                case 2:
                    no_of_edges = 0;
                    g.clearMap();
                    nodes = new Graph.Node[25];
                    for(int i=0;i<25;i++) {
                        nodes[i] = new Graph.Node(cities[i]);
                        g.addNode(nodes[i]);
                    }
                    for(int i=0;i<24;i++) {
                        if(g.addNeighbor(nodes[i], nodes[i+1])){no_of_edges++;}
                        if(g.addNeighbor(nodes[i+1], nodes[i]));
                    }
                    int temp3,temp4;
                    for(int i=0;i<76;i++) {
                        temp3 = rand.nextInt(25);
                        temp4 = rand.nextInt(25);
                        if(g.addNeighbor(nodes[temp3], nodes[temp4])){no_of_edges++;}
                        if(g.addNeighbor(nodes[temp4], nodes[temp3]));
                    }
                    break;

                case 3:
                    no_of_edges = 0;
                    g.clearMap();
                    nodes = new Graph.Node[50];
                    for(int i=0;i<50;i++) {
                        nodes[i] = new Graph.Node(cities[i]);
                        g.addNode(nodes[i]);
                    }
                    for(int i=0;i<49;i++) {
                        if(g.addNeighbor(nodes[i], nodes[i+1])){no_of_edges++;}
                        if(g.addNeighbor(nodes[i+1], nodes[i]));
                    }
                    int temp5,temp6;
                    for(int i=0;i<951;i++) {
                        temp5 = rand.nextInt(50);
                        temp6 = rand.nextInt(50);
                        if(g.addNeighbor(nodes[temp5], nodes[temp6])){no_of_edges++;}
                        if(g.addNeighbor(nodes[temp6], nodes[temp5]));
                    }
                    break;

                case 4:
                    g.clearMap();
                    no_of_edges = 0;
                    nodes = new Graph.Node[100];
                    for(int i=0;i<100;i++) {
                        nodes[i] = new Graph.Node(cities[i]);
                        g.addNode(nodes[i]);
                    }
                    for(int i=0;i<99;i++) {
                        if(g.addNeighbor(nodes[i], nodes[i+1])){no_of_edges++;}
                        if(g.addNeighbor(nodes[i+1], nodes[i]));
                    }
                    int temp7,temp8;
                    for(int i=0;i<3401;i++) {
                        temp7 = rand.nextInt(100);
                        temp8 = rand.nextInt(100);
                        if(g.addNeighbor(nodes[temp7], nodes[temp8])){no_of_edges++;}
                        if(g.addNeighbor(nodes[temp8], nodes[temp7]));
                    }
                    break;

                case 5:
                    g.getKeyValuePairs();
                    System.out.println("\nNumber of edges: " + no_of_edges);
                    System.out.println();
                    break;

                case 6:
                    String dummy1 = sc.nextLine();
                    System.out.println("Enter the departure place: ");
                    departure = sc.nextLine();
                    System.out.println("Enter the destination place: ");
                    destination = sc.nextLine();
                    while (!g.containsKey(departure) | !g.containsKey(destination)){
                        System.out.println("Please enter valid departure and destination.");
                        System.out.println("Enter the departure place: ");
                        departure = sc.nextLine();
                        System.out.println("Enter the destination place: ");
                        destination = sc.nextLine();
                    }
                    long run_time = 0;
                    run_time = g.bfs(departure, destination);
                    System.out.println("Runtime: " + run_time);
                    break;
                case 7:
                    try{
                    System.out.println("Calculating...");
                    System.out.println("======================================");
                    System.out.println("Paths:");
                    long total_time = 0;
                    int graph_length = g.getSize();
                    String[] cities1 = g.getValues(graph_length);
                    long counter = 0;
                    for(int i = 0; i < graph_length ; i++){
                        for(int j = i+1; j < graph_length; j++){
                            departure = cities1[i];
                            destination = cities1[j];
                            total_time += g.bfs(departure, destination);
                            counter++;
                        }
                    }
                    long result = total_time/counter;
                    System.out.println("\n=========================================");
                    System.out.println("Average run time is " + result);
                    System.out.println("\n");
                    break;}
                    catch (ArithmeticException e) {
                        System.out.println("Please make sure that you have generated your graph.");
                        break;
                    }
                case 8:
                    int no_of_nodes = 0;
                    String dummy2 = sc.nextLine();
                    System.out.println("Enter the number of nodes (From 1 to 100): ");
                    no_of_nodes = sc.nextInt();
                    while(!(1<=no_of_nodes & no_of_nodes <= 100)){
                        System.out.println("Please input a number from 1 to 100: ");
                        System.out.println("Enter the number of nodes (From 1 to 100): ");
                        no_of_nodes = sc.nextInt();
                    }
                    int max_edges = (no_of_nodes*(no_of_nodes-1))/2 - 1;
                    int min_edges = no_of_nodes - 1;
                    int max_no_of_edges;
                    System.out.println("Enter the maximum number of edges (From " + min_edges + " to " + max_edges + "): ");
                    max_no_of_edges = sc.nextInt();
                    while(!(min_edges<=max_no_of_edges & max_no_of_edges <= max_edges)){
                        System.out.println("Please input a number from " + min_edges + " to " + max_edges + ": ");
                        System.out.println("Enter the number of maximum edges (From " + min_edges + " to " + max_edges + "): ");
                        max_no_of_edges= sc.nextInt();
                    }
                    g.clearMap();
                    nodes = new Graph.Node[no_of_nodes];
                    no_of_edges = 0;
                    for(int i=0;i<no_of_nodes;i++) {
                        nodes[i] = new Graph.Node(cities[i]);
                        g.addNode(nodes[i]);
                    }
                    for(int i=0;i<no_of_nodes-1;i++) {
                        if(g.addNeighbor(nodes[i], nodes[i+1])){no_of_edges++;}
                        if(g.addNeighbor(nodes[i+1], nodes[i]));
                    }
                    int temp9,temp10;
                    for(int i=0;i<max_no_of_edges-no_of_nodes+1;i++) {
                        temp9 = rand.nextInt(no_of_nodes);
                        temp10 = rand.nextInt(no_of_nodes);
                        if(g.addNeighbor(nodes[temp9], nodes[temp10])){no_of_edges++;}
                        if(g.addNeighbor(nodes[temp10], nodes[temp9]));
                    }
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default: break;
            }
        }
    }

}

