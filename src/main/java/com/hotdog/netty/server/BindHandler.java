package com.hotdog.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class BindHandler {

    private final int port;

    public BindHandler(int port) {
        this.port = port;
    }

    public static void main(String[] args) throws Exception {
        new BindHandler(9000).start();
    }

    public void start() throws Exception {
         //(1) 创建EventLoopGroup
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //(2) 创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(group)
                    //(3) 指定所使用的 NIO 传输 Channel
                    .channel(NioServerSocketChannel.class)
                    //(4) 使用指定的端口设置套接字地址
                    .localAddress(new InetSocketAddress(port))
                    //(5) 添加一个EchoServerHandler到于Channel的 ChannelPipeline
                    .childHandler(new ChatServerInitializer() );
            //(6) 异步地绑定服务器；调用 sync()方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();

            //(7) 获取 Channel 的CloseFuture，并且阻塞当前线程直到它完成
            f.channel().closeFuture().sync();
        } finally {
            //(8) 关闭 EventLoopGroup，释放所有的资源
            group.shutdownGracefully().sync();
        }
    }
}
