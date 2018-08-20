package com.hotdog.base.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SelectorTest {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking( false );

        ServerSocket ss = ssc.socket();
        InetSocketAddress address = new InetSocketAddress( 8080 );
        ss.bind( address );

        SelectionKey key = ssc.register( selector, SelectionKey.OP_ACCEPT );

        int num = selector.select();

        Set selectedKeys = selector.selectedKeys();
        Iterator it = selectedKeys.iterator();

        while (it.hasNext()) {
            SelectionKey keys = (SelectionKey)it.next();
            // ... deal with I/O event ...
        }
    }

}
