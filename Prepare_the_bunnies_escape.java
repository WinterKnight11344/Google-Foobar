package com.google.challenges;

import java.util.ArrayList;
import java.util.List;

public class Prepare_the_bunnies_escape {
	
    public static int answer(int[][] maze) { 
    	

    } 
    
    public static List<Node> arrayToMaze(int[][] array){
    	List<Node> nodes = new ArrayList<>();
    	int id = 0;
    	for(int i = 0; i < array.length; i++){
    		for(int j = 0; j < array[i].length; j++){
    			if(i == 0 && j == 0)
    				nodes.add(new Node(0            , 0            , 0            , 0            , id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i == 0 && j - 1 >= 0 && j + 1 <= array[i].length)
    				nodes.add(new Node(0            , array[i][j+1], array[i+1][j], array[i][j-1], id));
    			if(i - 1 >= 0 && i + 1 <= array.length && j - 1 >=0 && j + 1 <= array[i].length)
    				nodes.add(new Node(array[i-1][j], array[i][j+1], array[i+1][j], array[i][j-1], id));
    			id++;
    		}
    	}
    }
}

class Node {
	int nWeight;
	int eWeight;
	int sWeight;
	int wWeight;
	int distance;
	int myWeight;
	int id;
	
	
	
	public Node(int nWeight, int eWeight, int sWeight, int wWeight, int distance, int id) {
		super();
		this.nWeight = nWeight;
		this.eWeight = eWeight;
		this.sWeight = sWeight;
		this.wWeight = wWeight;
		this.distance = distance;
		this.id = id;
	}
	public Node(int nWeight, int eWeight, int sWeight, int wWeight, int id) {
		super();
		this.nWeight = nWeight;
		this.eWeight = eWeight;
		this.sWeight = sWeight;
		this.wWeight = wWeight;
		this.id = id;
	}
	public int getnWeight() {
		return nWeight;
	}
	public void setnWeight(int nWeight) {
		this.nWeight = nWeight;
	}
	public int geteWeight() {
		return eWeight;
	}
	public void seteWeight(int eWeight) {
		this.eWeight = eWeight;
	}
	public int getsWeight() {
		return sWeight;
	}
	public void setsWeight(int sWeight) {
		this.sWeight = sWeight;
	}
	public int getwWeight() {
		return wWeight;
	}
	public void setwWeight(int wWeight) {
		this.wWeight = wWeight;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
