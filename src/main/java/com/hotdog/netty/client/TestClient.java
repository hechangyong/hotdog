package com.hotdog.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * 代码清单 2-4 客户端的主类
 *
 * @author <a href="mailto:norman.maurer@gmail.com">Norman Maurer</a>
 */
public class TestClient {
    private final String host;
    private final int port;

    public TestClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start()
        throws Exception {
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            //创建 Bootstrap
            Bootstrap b = new Bootstrap();
            //指定 EventLoopGroup 以处理客户端事件；需要适用于 NIO 的实现
            b.group(group)
                //适用于 NIO 传输的Channel 类型
                .channel(NioSocketChannel.class)
                //设置服务器的InetSocketAddress
                .remoteAddress(new InetSocketAddress(host, port))
                //在创建Channel时，向 ChannelPipeline中添加一个 EchoClientHandler实例
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                        throws Exception {
                    }
                });
            //连接到远程节点，阻塞等待直到连接完成
            ChannelFuture f = b.connect().sync();
            //阻塞，直到Channel 关闭
            f.channel().closeFuture().sync();
        } finally {
            //关闭线程池并且释放所有的资源
            group.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args)
            throws Exception {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

        new TestClient("127.0.0.1", 9000).start();
    }
}

