

public class BSTree{


	class BSTNode{
		 
		public String data; 
		public BSTNode left; 
		public BSTNode right;
		

		public BSTNode(String value) {
			data = value; 
			left = null; 
			right = null;
			
		} 
	
	}
	
	private BSTNode root; 
	
	BSTree() { 
        root = null; 
    }
	
public boolean find(String value){
	return find(value, root); 
}

public boolean find (String value, BSTNode node){
	if(node == null){
		return false; 
	}
	
	if(value.compareTo(node.data)==0)
		return true; 
	else if (value.compareTo(node.data)<0)
		return find (value, node.left); 
	else 
		return find (value, node.right); 
	
}

public void insert(String value){
	
	root = insert(value, root); 
}

public BSTNode insert (String value, BSTNode node){
	
	if(node==null)
		return new BSTNode(value); 
	
	if(value.compareTo(node.data)<0){
		node.left = insert(value, node.left); 
		return node; 
		}
	else{
		node.right = insert(value, node.right);
		return node;
		}

}

public void delete (String value){
	root = delete(value, root);
}

public BSTNode delete (String value, BSTNode node){
	if (node == null)
		return null; 
	
	if(node.data.compareTo(value)==0){
	
		if(node.left==null){
			return node.right; 
		}
		else if (node.right==null){
			return node.left; 
			
		}
		
	}
		
	if(node.right.left==null){
		node.data = node.right.data;
		node.right = node.right.right; 
		return node;
	}
	else{
		node.data = removeSmallest(node.right);
		return node; 
	}
			
}

private String removeSmallest(BSTNode node){
	if(node.left.left==null){
		String smallest = node.left.data;
		node.left = node.left.right;
		return smallest; 
	}
	return removeSmallest(node.left); 
}

public String toStringInOrder() {
	String output = "";
	return toStringInOrder(root, output).trim();
}

public String toStringInOrder(BSTNode node, String output){ 
	
	if (node != null){
		output = toStringInOrder(node.left, output);
		output = output + node.data + " " ;  
		output = toStringInOrder(node.right, output); 
		
	return output;
	}
	return output; 
}

public String toStringPreOrder(){
	String output = "";
	return toStringPreOrder(root, output).trim(); 
}


public String toStringPreOrder(BSTNode node, String output){
	 
	
	if (node != null){ 

		output = output + node.data + " ";
		output = toStringPreOrder(node.left, output);  
		output = toStringPreOrder(node.right, output); 
		
	return output;
	}
	return output; 
}


}//BSTree Class ends