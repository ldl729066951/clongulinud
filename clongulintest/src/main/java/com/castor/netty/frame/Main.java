package com.castor.netty.frame;

import top.crossoverjie.cicada.server.CicadaServer;

public class Main {

	public static void main(String[] args) throws Exception {
		CicadaServer.start(Main.class,"/cicada-example");
	}
}
