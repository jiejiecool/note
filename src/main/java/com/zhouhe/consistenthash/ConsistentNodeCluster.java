package com.zhouhe.consistenthash;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.IntStream;

/**
 * hash一致性缓存集群
 * @author jiejiecool
 *
 */
public class ConsistentNodeCluster {
	//不同的hash值对应的节点(虚拟节点，每个节点对应512个虚拟节点)
	private SortedMap<Integer, Node> virNodes = new TreeMap<>();
	
	protected List<Node> nodes = new ArrayList<Node>();
	
	private static final int VIR_NODE_COUNT = 512;
	
	public void addNode(Node node) {
		this.nodes.add(node);
		IntStream.range(0, VIR_NODE_COUNT).forEach(index -> {
			int hash = hash(node.getIp()+"#"+index);
			virNodes.put(hash, node);
		});
	}
	
	public void remove(Node node) {
		nodes.removeIf(o -> 
			o.getIp().equals(node.getIp())
		);
		
		IntStream.range(0, VIR_NODE_COUNT).forEach(index -> {
			int hash = hash(node.getIp()+"#"+index);
			virNodes.remove(hash);
		});
	}
	
	//哈希一致性去redis集群中某个节点拿数据,返回取数据的节点
	public Node get(String key) {
		int hash = hash(key);
		SortedMap<Integer, Node> subMap = hash > virNodes.lastKey() ? virNodes.tailMap(0) : virNodes.tailMap(hash);
		 if (subMap.isEmpty()) {
	            return null;
	        }
		return subMap.get(subMap.firstKey());
	}
	
	int hash(String key) {
		return key.hashCode() >0 ? key.hashCode() : (0-key.hashCode());
	}
	
}
