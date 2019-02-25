package com.castor.zk;

import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ConfigUpdater {

	private static final String HOST ="192.168.3.23:2181";

	public static final String PATH = "/config";

	private ActiveKeyValueStore store;
	private Random random=new Random();

	public ConfigUpdater(String hosts) throws IOException, InterruptedException {
		store = new ActiveKeyValueStore();
		store.connect(hosts);
	}

	public void run() throws InterruptedException, KeeperException {
		while(true){
			String value=random.nextInt(100)+"";
			store.write(PATH, value);
			System.out.println("Set "+PATH+" to "+value+"\n");
			TimeUnit.SECONDS.sleep(1);

		}
	}

	public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
		ConfigUpdater configUpdater = new ConfigUpdater(HOST);
		configUpdater.run();
	}


}
