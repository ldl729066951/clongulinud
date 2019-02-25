package com.castor.zk.test;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;

public class ConfigWatcher implements Watcher{

	private static final int SESSION_TIMEOUT=5000;
	private ZooKeeper zk = null;
	private static final String HOST = "192.168.3.23:2181";
	private CountDownLatch connectedSignal = new CountDownLatch(1);

	@Override
	public void process(WatchedEvent event) {
		if(event.getState() == Event.KeeperState.SyncConnected){
			connectedSignal.countDown();
		}
		if(event.getType() == Event.EventType.NodeDataChanged){
      		System.out.println("发现变化了。。");
		}
	}

	public void connect(String hosts) throws IOException, InterruptedException {
		zk = new ZooKeeper(hosts, SESSION_TIMEOUT, this);
		connectedSignal.await();
	}

	public void subscribe(String path) throws KeeperException, InterruptedException {
		if(zk.exists(path, false) != null){
      		System.out.println(new String(zk.getData(path, true, null), Charset.forName("UTF-8")));
		}
	}

	public void create(String path) throws KeeperException, InterruptedException {
		zk.create(path, null, ZooDefs.Ids.CREATOR_ALL_ACL, CreateMode.PERSISTENT);
	}


    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
	    ConfigWatcher configWatcher = new ConfigWatcher();
		configWatcher.connect(ConfigWatcher.HOST);
		configWatcher.create("/tmp");
		Thread.sleep(Long.MAX_VALUE);

    }
}
