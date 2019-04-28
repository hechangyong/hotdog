package com.hotdog.netty.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChatServerInitializer extends ChannelInitializer<Channel> {
     private static Logger logger = LoggerFactory.getLogger(Test1ChannelInboundHandler.class);

    public ChatServerInitializer() {
    }

    @Override
    //将所有需要的 ChannelHandler 添加到 ChannelPipeline 中
    protected void initChannel(Channel ch) throws Exception {
        logger.info("ChatServerInitializer ---- initChannel ");
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new Test1ChannelInboundHandler());
        pipeline.addLast(new Test2ChannelInboundHandler());
        pipeline.addLast(new Test3ChannelInboundHandler());

    }
}