package com.google.challenges;

import java.util.HashMap;
import java.util.Map;

public class Ion_flux_relabeling {

	
	private static Map<Integer, Node> bTree;
	
	public static int[] answer(int h, int[] q) {
		final int height = h;
		bTree = new HashMap<>();
		if(h - 1 >= 0){
			h--;
		}
		if((q.length > 0 && q.length <= 10000) && (1 <= h && h <= 1)){
			buildBinaryTree(h);
			if(h >= 1)
				return getParents(q);
			else
				return new int[] {-1};
		}
		else 
			//return new int[] {-1};
		if(h > 1){
			int[] outArray = new int[q.length];
			for(int i = 0; i < q.length; i++){
				outArray[i] = parent(height, q[i]);
			}
			return outArray;
		}else
		return new int[] {-1};
    } 
	
	//Credit to StackExchange user rolfl for this method
	private static final int parent(int height, int node) {
	    int size = (int)Math.pow(2, height) - 1;

	    if (node == size) {
	        return -1;
	    }

	    int before = 0;
	    do {
	        if (size == 0) {
	            throw new IllegalStateException();
	        }
	        // size is always odd, and halving it integer-division is also odd.
	        size = size/2;
	        int left = before + size;
	        int right = left + size;
	        int me = right + 1;
	        if (left == node || right == node) {
	            return me;
	        }
	        if (node > left) {
	            // nodes to the right have the left as offset.
	            before = left;
	        }
	    } while (true);

	}
	
	public static void buildBinaryTree(int height){
		int totalNodes = (int) (Math.pow(2, height + 1) -1);
		int count = height + 1;
		for(int i = 1; i <= totalNodes; i++){
			if(i == totalNodes)
				bTree.put(i, new Node(i, count));
			else
				bTree.put(i, new Node(i));
		}
		for(int i = totalNodes; i > 0; i--){
			if(bTree.get(i).getLevel() > 1){
				bTree.get(i).addRight(bTree.get(i - 1));
				bTree.get(i - 1).setLevel(bTree.get(i).getLevel() - 1);
				bTree.get(i).addLeft(bTree.get(bTree.get(i).getLeftValue()));
				bTree.get(bTree.get(i).getLeftValue()).setLevel(bTree.get(i).getLevel() - 1);
			}
		}
		
	}
	
	public static int[] getParents(int[] input){
		int[] out = new int[input.length];
		for(int j = 0; j < input.length; j++){
			for(int i = 1; i <= bTree.size(); i++){
				if(bTree.get(i).getLevel() > 1){
					if(input[j] >= bTree.size()){
						out[j] = -1;
					}else
					if(bTree.get(i).getLeft() != null && bTree.get(i).getLeft().getKey() == input[j]){
						out[j] = bTree.get(i).getKey();
						//out[j] = i;
					}else
					if(bTree.get(i).getRight() != null && bTree.get(i).getRight().getKey() == input[j]){
						out[j] = bTree.get(i).getKey();
						//out[j] = i;
					}
				}
			}
		}
		return out;
	}

}

class Node {
	private int key;
	private int c;
	private Node left;
	private Node right;
	
	public Node(){
		key = 0;
		left = right = null;
	}
	
	public boolean isRight() {
		return (key + (int) Math.pow(2, c+1) != (int) Math.pow(2, c+1) - 1);
	}

	public boolean isLeft() {
		return key + (int) Math.pow(2, c+1) == (int) Math.pow(2, c+1) - 1;
	}
	
	public Node(int item, int level){
		key = item;
		c = level;
		left = right = null;
	}
	
	public Node(int item){
		key = item;
		c = 1;
		left = right = null;
	}
	
	public int getLevel(){
		return c;
	}
	
	public void setLevel(int level){
		this.c = level;
	}
	
	public void setKey(int key){
		this.key = key;
	}
	
	public int getKey(){
		return this.key;
	}
	
	public void addLeft(Node left){
		this.left = left;
	}
	
	public void addRight(Node right){
		this.right = right;
	}
	
	public Node getRight(){
		return right;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public int getLeftValue(){
		return (c > 0) ? (int) (key - Math.pow(2, c - 1)) : 0;
	}
	
	@Override
	public String toString(){
		return "\nValue: " + key + "\nLevel: " + c + "\nLeft: " + ((left == null) ? "None" : left.key) + "\nRight: " + ((right == null) ? "None" : right.key) + "\n\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + key;
		result = prime * result + ((left == null) ? 0 : left.key);
		result = prime * result + ((right == null) ? 0 : right.key);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (key != other.key)
			return false;
		if (c != other.c)
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
}
