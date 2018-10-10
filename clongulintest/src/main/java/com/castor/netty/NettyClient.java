package com.castor.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.nio.charset.Charset;
import java.util.Date;

public class NettyClient {
	public static void main(String[] args) throws InterruptedException {
		Bootstrap bootstrap = new Bootstrap();
		NioEventLoopGroup group = new NioEventLoopGroup();

		bootstrap.group(group)
				.channel(NioSocketChannel.class)
				.handler(new ChannelInitializer<NioSocketChannel>() {
					@Override
					protected void initChannel(NioSocketChannel ch) {
						//ch.pipeline().addLast(new StringEncoder());
						ch.pipeline().addLast(new FirstClientHandler());
					}
				});

		Channel channel = bootstrap.connect("127.0.0.1", 8000).channel();

		/*while (true) {
			channel.writeAndFlush(new Date() + ": hello world!");
			Thread.sleep(2000);
		}*/
	}
}

class FirstClientHandler extends ChannelInboundHandlerAdapter {
	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		System.out.println(new Date() + ": 客户端写出数据");

		// 1. 获取数据
		ByteBuf buffer = getByteBuf(ctx);

		// 2. 写数据
		ctx.channel().writeAndFlush(buffer);
		System.out.println();
	}

	private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
		// 1. 获取二进制抽象 ByteBuf
		ByteBuf buffer = ctx.alloc().buffer();

		// 2. 准备数据，指定字符串的字符集为 utf-8
		byte[] bytes = "你好，闪电侠!".getBytes(Charset.forName("utf-8"));

		// 3. 填充数据到 ByteBuf
		buffer.writeBytes(bytes);

		return buffer;
	}
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) {
		ByteBuf byteBuf = (ByteBuf) msg;

		System.out.println(new Date() + ": 客户端读到数据 -> " + byteBuf.toString(Charset.forName("utf-8")));
	}
}