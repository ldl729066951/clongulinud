package com.castor.zk;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

@SuppressWarnings("all")
public class ConnectionWatcher implements Watcher {

	private static final int SESSION_TIMEOUT=5000;
	protected ZooKeeper zk;
	private CountDownLatch connectedSignal = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent event) {
		if(event.getState() == Event.KeeperState.SyncConnected){
			connectedSignal.countDown();
		}
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
		String createdPath=zk.create(path, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
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

	protected void connect(String hosts) throws IOException, InterruptedException {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
		connectedSignal.await();
	}

}
