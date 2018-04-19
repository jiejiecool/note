package com.zhouhe.tree;

import java.util.List;

public class TreeNode {
	private String name;
	private List<TreeNode> childrens;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<TreeNode> getChildrens() {
		return childrens;
	}
	public void setChildrens(List<TreeNode> childrens) {
		this.childrens = childrens;
	}
	public TreeNode(String name, List<TreeNode> childrens) {
		super();
		this.name = name;
		this.childrens = childrens;
	}
	public TreeNode(String name) {
		super();
		this.name = name;
	}
	
	
	
	
}
