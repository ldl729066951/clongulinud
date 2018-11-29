package com.castor.arithmetic;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.jetty.xml.XmlParser;

import java.util.Hashtable;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LRU {

	private static Map<String, Node> cache = new Hashtable<>();
	private static final Node head = Node.head();
	private static final Node tail = Node.tail();
	private static final int size = 3;
	private static volatile int count;

	public static void main(String[] args) {

		init();

    	System.out.println("get key1 = "+  Optional.ofNullable(get("key1")).orElse(0));

    	set("key1", 1);
		System.out.println("get key1 = "+  Optional.ofNullable(get("key1")).orElse(0));

		nodeToString();
		set("key2", 2);
		set("key3", 3);
		nodeToString();
		set("key4", 4);
		nodeToString();
		System.out.println("get key3 = "+  Optional.ofNullable(get("key3")).orElse(0));
		nodeToString();
	}

	private static void init(){
		head.setLast(tail);
		tail.setPre(head);
	}

	private static void set(String key, Integer data){

		Node node = cache.get(key);
		if(!Objects.isNull(node)){
			//移动至头部
			insertOrMoveHead(node);
		}else{
			Node newNode = Node.newNode(data);
			cache.put(key, newNode);
			if(count >= size){
				removeTail();
			}
			//插入或移动至头部
			insertOrMoveHead(newNode);
		}

	}

	private static Integer get(String key){
  	    if(count == 0){
  	    	return null;
		}

		Node node = cache.get(key);
  	    if(Objects.isNull(node)){
  	    	return null;
		}

		//移动到头部
		//判断是不是在头部
		if(node.getPre().isHead()){
  	    	return node.getData();
		}

		insertOrMoveHead(node);

  		return node.getData();
	}

	public static void removeTail(){
		Node tmp = tail.getPre().getPre();
		tmp.setLast(tail);
		tail.setPre(tmp);
		count--;
	}

	//插入链表头部
	public static void insertOrMoveHead(Node node){

		if(node.getPre() != null && node.getLast() != null){
			node.getPre().setLast(node.getLast());
			node.getLast().setPre(node.getPre());
			count--;
		}

		node.setLast(head.getLast());
		node.setPre(head);
		head.getLast().setPre(node);
		head.setLast(node);
		count++;
	}

	public static void nodeToString(){
		Node node = head;
		StringBuilder stringBuilder = new StringBuilder();
		while(!node.isTail()){
			if(!node.isHead()){
				stringBuilder.append(node.getData() + "  ");
			}
			node = node.getLast();
		}
    	System.out.println("===================================");
    	System.out.println("node :" +  stringBuilder.toString());
		System.out.println("===================================");
	}

}


@Getter
@Setter
class Node{

	private boolean isHead;
	private boolean isTail;
	private Integer data;
	private Node pre;
	private Node last;

	public static Node newNode(){
		Node node = new Node();
		node.data = null;
		node.pre = null;
		node.last = null;
		return node;
	}

	public static Node newNode(Integer data){
		Node node = new Node();
		node.data = null;
		node.pre = null;
		node.last = null;
		node.setData(data);
		return node;
	}

	public static Node head(){
		Node node = new Node();
		node.data = null;
		node.pre = null;
		node.last = null;
		node.setHead(true);
		return node;
	}

	public static Node tail(){
		Node node = new Node();
		node.data = null;
		node.pre = null;
		node.last = null;
		node.setTail(true);
		return node;
	}

}


