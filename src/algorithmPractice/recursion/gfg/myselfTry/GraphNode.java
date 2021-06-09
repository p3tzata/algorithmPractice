package algorithmPractice.recursion.gfg.myselfTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GraphNode {
	
	int data;
	List<GraphNode> childList;
	public GraphNode(int data) {
		super();
		this.data = data;
		childList=new ArrayList<>();
	}
	
	public void addChild(GraphNode child) {
		
		childList.add(child);
	}
	
	public List<GraphNode> getChilds(){
		
		return Collections.unmodifiableList(childList);
	}

	public int getData() {
		return data;
	}
	
	
	
	
	
}
