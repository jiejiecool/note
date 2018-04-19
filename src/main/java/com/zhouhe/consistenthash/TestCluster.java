package com.zhouhe.consistenthash;

import java.util.stream.IntStream;

import org.junit.Test;

public class TestCluster {
	private static int DATA_COUNT = 50001;
	private static String PREFIX = "redis_";
	//@Test
	public void testNormal() {
		NormalNodeCluster cluster = new NormalNodeCluster();
		cluster.addNode(new Node("www.jiejiecool1.com","192.168.0.1"));
		cluster.addNode(new Node("www.jiejiecool2.com","192.168.0.2"));
		cluster.addNode(new Node("www.jiejiecool3.com","192.168.0.3"));
		cluster.addNode(new Node("www.jiejiecool4.com","192.168.0.4"));
		
		//模拟缓存初始化
		for (int i=0;i<DATA_COUNT;i++) {
			Node node = cluster.get(PREFIX + i);
			node.put(PREFIX + i, "test");
			}
		
		//查看数据分布情况
		cluster.nodes.forEach(node -> {
			System.out.println("IP:"+node.getIp()+"   数据量:"+node.getData().size());
		});
		
		//增加一个节点
		cluster.addNode(new Node("www.jiejiecool5.com","192.168.0.5"));
		
		int hitCount = 0;
		for (int i=0;i<DATA_COUNT;i++) {
			Node node = cluster.get(PREFIX+i);
			if (node.getData().containsKey(PREFIX+i)) {
				hitCount++;
			}
		}
		
		System.out.println("命中数="+hitCount+"----命中率="+hitCount/(DATA_COUNT+0.00));
	}
	
	
	@Test
	public void testConsistent() {
		ConsistentNodeCluster cluster = new ConsistentNodeCluster();
		cluster.addNode(new Node("www.jiejiecool1.com","192.168.0.1"));
		cluster.addNode(new Node("www.jiejiecool2.com","192.168.0.2"));
		cluster.addNode(new Node("www.jiejiecool3.com","192.168.0.3"));
		cluster.addNode(new Node("www.jiejiecool4.com","192.168.0.4"));
		
		//模拟缓存初始化
		for (int i=0;i<DATA_COUNT;i++) {
			Node node = cluster.get(PREFIX + i);
			node.put(PREFIX + i, "test");
			}
		
		//查看数据分布情况
		cluster.nodes.forEach(node -> {
			System.out.println("IP:"+node.getIp()+"   数据量:"+node.getData().size());
		});
		
		//增加一个节点
		cluster.addNode(new Node("www.jiejiecool5.com","192.168.0.5"));
		
		int hitCount = 0;
		for (int i=0;i<DATA_COUNT;i++) {
			Node node = cluster.get(PREFIX+i);
			if (node.getData().containsKey(PREFIX+i)) {
				hitCount++;
			}
		}
		
		System.out.println("命中数="+hitCount+"----命中率="+hitCount/(DATA_COUNT+0.00));
	}
}
