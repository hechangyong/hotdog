package com.hotdog.netty.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test3ChannelInboundHandler implements ChannelInboundHandler {
    private static Logger logger = LoggerFactory.getLogger(Test1ChannelInboundHandler.class);

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> channelRegistered");
    }

    @Override
    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> channelUnregistered");

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> channelActive");

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> channelInactive");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        logger.info("3 --------> channelRead");

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> channelReadComplete");

    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        logger.info("3 --------> userEventTriggered");

    }

    @Override
    public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> channelWritabilityChanged");

    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> handlerAdded");

    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        logger.info("3 --------> handlerRemoved");

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("3 --------> exceptionCaught");

    }
}
