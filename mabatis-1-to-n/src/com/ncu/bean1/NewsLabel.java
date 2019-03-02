package com.ncu.bean1;
//新闻栏目：当前的新闻栏目被看作的hi一方,即父栏目

import java.util.Set;

public class NewsLabel {

	private Integer  id;
	private String name;
	private Set<NewsLabel> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<NewsLabel> getChildren() {
		return children;
	}
	public void setChildren(Set<NewsLabel> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", children=" + children + "]";
	}
	
}
