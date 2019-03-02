package com.castor.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class CreateGroup implements Watcher {

	private static final int SESSION_TIMEOUT=5000;
	private static final String HOST1="192.168.3.23:2181";

	private ZooKeeper zk;
	private CountDownLatch connectedSignal = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent watchedEvent) {
		if(watchedEvent.getState() == Event.KeeperState.SyncConnected){
			connectedSignal.countDown();
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		CreateGroup createGroup = new CreateGroup();
		createGroup.connect(HOST1);
		//createGroup.create("a");
		//createGroup.join("a", "aa");
		//createGroup.list("");
		//createGroup.delete("a");
		createGroup.join("c", "cc1");
		createGroup.join("c", "cc1");
		createGroup.close();
	}

	private void close() throws InterruptedException {
		zk.close();
	}

	private void create(String groupName) throws KeeperException, InterruptedException {
		String path = "/"+groupName;
		if(zk.exists(path, false) == null){
			zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
    	System.out.println("Created:"+ path);
	}

	public void join(String groupName,String memberName) throws KeeperException, InterruptedException{
		String path="/"+groupName+"/"+memberName;
		String createdPath=zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
		System.out.println("Created:"+createdPath);
	}

	public void list(String groupNmae) throws KeeperException, InterruptedException{
		String path ="/"+groupNmae;
		try {
			List children = zk.getChildren(path, false);
			if(children.isEmpty()){
				System.out.println("Group "+groupNmae+" does not exist \n");
				System.exit(1);
			}
			Iterator it=children.iterator();
			while(it.hasNext()){
				String child=(String)it.next();
				System.err.println(child);
			}
		} catch (KeeperException.NoNodeException e) {
			System.out.println("Group "+groupNmae+" does not exist \n");
			System.exit(1);
		}
	}

	public void delete(String groupName) throws InterruptedException, KeeperException{
		String path="/"+groupName;
		List children;
		try {
			children = zk.getChildren(path, false);
			Iterator it=children.iterator();
			while(it.hasNext()){
				zk.delete(path+"/"+(String)it.next(), -1);
			}

			zk.delete(path, -1);
		} catch (KeeperException.NoNodeException e) {
			System.out.println("Group "+groupName+" does not exist \n");
			System.exit(1);
		}
	}

	private void connect(String hosts) throws IOException, InterruptedException {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
		connectedSignal.await();
	}

}
