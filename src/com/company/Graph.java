package com.company;

import com.sun.istack.internal.localization.NullLocalizable;

import java.util.*;

public class Graph
{
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
    Map<Node, LinkedList<Node>> adjlist;

    private static Queue<Node> queue = new LinkedList<Node>();

    public static class Node{
        String city;
        boolean visited;
        int level = -1;
        Node(String city){
            this.city = city;
            this.visited = false;
        }
        public String getCity() {
            return city;
        }
        public int getLevel() {return level;}
        public String toString(Node node) {
            return node.getCity();
        }
    }

    public Graph() {
        adjlist = new HashMap<Node, LinkedList<Node>>();
    }

    public void addNode(Node nodes){
        adjlist.putIfAbsent(nodes, new LinkedList<Node>());
    }

    public boolean addNeighbor(Node v1,Node v2) {
        boolean flag = true;
        if(adjlist.get(v1) == null) {
            adjlist.put(v1, new LinkedList<Node>());
        }
        if(v1 == v2) {
            flag = false;
        }
        for (int i = 0; i < adjlist.get(v1).size(); i++) {
            if(adjlist.get(v1).get(i) == v2)
                flag = false;
        }
        if(flag == true) {
            adjlist.get(v1).add(v2);
        }
        return flag;
    }

    public void getKeyValuePairs(){
        for (Node node: adjlist.keySet()) {
            String key = node.getCity();
            System.out.print(key + ": ");
            LinkedList<Node> value = adjlist.get(node);
            for (Node nodeValue: value) {
                String keyValue = nodeValue.getCity();
                System.out.print(keyValue + ",");
            }
            System.out.println();
        }
    }

    public int getSize(){
        return adjlist.size();
    }

    public String[] getValues(int size) {
        String[] cities = new String[size];
        int i = 0;
        for(Node node: adjlist.keySet()) {
            cities[i] = node.getCity();
            i++;
        }
        return cities;
    }

    public void clearMap() {
        adjlist.clear();
    }

    public boolean containsKey(String city) {
        boolean contain = false;
        for (Node node: adjlist.keySet()) {
            String key = node.getCity();
            if (key.equals(city)) {
                contain = true;
            }
        }
        return contain;
    }

    public long bfs(String departure, String destination){
        queue.clear();
        for(Node node: adjlist.keySet()) {
            node.level = -1;
            node.visited = false;
        }
        for (Node node: adjlist.keySet()) {
            String key = node.getCity();

            if (key.equals(departure)) {
                queue.add(node);
                node.visited=true;
                node.level = 0;
            }
        }
        long start = System.nanoTime();
        Boolean destinationFound = Boolean.FALSE;
        while (!destinationFound){
            Node element = queue.remove();
            int node_level = -1;
            for(Node node: adjlist.keySet()){
                if (node.getCity().equals(element.getCity())) {
                    node_level = node.getLevel();
                }
            }
            LinkedList<Node> neighbours = adjlist.get(element);
            for (Node nodeNeighbour: neighbours) {
                String neighbourvalue = nodeNeighbour.getCity();
                for(Node node: adjlist.keySet()){
                    if (node.getCity().equals(neighbourvalue)) {
                        if(!node.visited){
                            node.level = node_level + 1;
                            node.visited = true;
                            queue.add(node);
                        }
                    }
                }
                if (neighbourvalue.equals(destination)) {
                    for(Node node: adjlist.keySet()){
                        if (node.getCity().equals(neighbourvalue)) {
                            node.level = node_level + 1;
                            node.visited = true;
                        }
                    }
                    destinationFound = Boolean.TRUE;
                    break;
                }
            }
        }
        long run_time = System.nanoTime() - start;
        showShortestPath(departure, destination);
        queue.clear();
        return run_time;
    }
    public void showShortestPath (String departure, String destination) {
        String city;
        Deque<String> stack = new ArrayDeque<String>();
        Node n = new Graph.Node("");
        int current_level = 0;
        for (Node node: adjlist.keySet()) {
            String key = node.getCity();
            if (key.equals(destination)) {
                n = node;
                current_level = node.getLevel();
                city = n.getCity();
                break;
            }
        }
        int max_level = current_level;
        System.out.println("Shortest Path: ");
        while(current_level >= 0) {
            city = n.getCity();
            stack.push(city);
            int next_level = current_level - 1;
            LinkedList<Node> neighbours = adjlist.get(n);
            for(Node nodeNeighbour : neighbours) {
                String neighbourvalue = nodeNeighbour.getCity();
                for(Node node : adjlist.keySet()){
                    if(node.getCity().equals(neighbourvalue)) {
                        if(node.getLevel() == next_level){
                            n = node;
                            break;
                        }
                    }
                }
            }
            current_level = next_level;
        }
        System.out.println(departure + " -> " + destination);
        for(int i = 0; i <= max_level; i++){
            String cities = stack.pop();
            System.out.println("City " + i + ": " + cities);
        }
    }
}