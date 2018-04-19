package com.zhouhe.consistenthash;

import java.util.ArrayList;
import java.util.List;

/**
 * 一般的取模算法来进行路由
 * @author jiejiecool
 *
 */
public class NormalNodeCluster {
	protected List<Node> nodes = new ArrayList<Node>();
	
	public void addNode(Node node) {
		this.nodes.add(node);
	}
	
	public void remove(Node node) {
		nodes.removeIf(o -> 
			o.getIp().equals(node.getIp())
		);
	}
	
	//取模法去redis集群中某个节点拿数据
	public Node get(String key) {
		int hash = key.hashCode() >0 ? key.hashCode() : (0-key.hashCode());
		int index = hash % nodes.size();
		//System.out.println("key="+key+"-----hash="+hash+"-------------index="+index);
		return nodes.get(index);
	}
}
