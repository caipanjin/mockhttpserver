/**
 *
 *     平安付
 * Copyright (c) 2013-2014 PingAnFu,Inc.All Rights Reserved.
 */
package com.caipanjin.mockhttpserver.mockhttpserver;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


/**
 * MockHttpServer
 * Author: 蔡盘进 (email:caipanjin125@pingan.com.cn)
 * Date: 14-3-20
 * Time: 下午10:24
 */
public class MockHttpServer {
    private final int port;
    private final String configFilePath;

    public MockHttpServer(int port, String configFilePath) {
        this.port = port;
        this.configFilePath = configFilePath;
    }

    public void run() throws Exception {
        // Configure the server.
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerInitializer());

            Channel ch = b.bind(port).sync().channel();
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        /*int port;
        String configFilePath;
        if (args.length > 1) {
            port = Integer.parseInt(args[0]);
            configFilePath = args[1];
            new MockHttpServer(port, configFilePath).run();

        } else {
            System.out.println("Usage: java MockHttpServer <port> <configFilePath>");
        }*/
        new MockHttpServer(8080, null).run();

    }
}
