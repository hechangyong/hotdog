package com.hotdog.base.nio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FastCopyFile {
    private static Logger logger = LoggerFactory.getLogger(FastCopyFile.class);

    static public void main(String args[]) throws Exception {

        FileInputStream fin = new FileInputStream("D:\\person\\javaProject\\data\\pom.xml");
        FileOutputStream fout = new FileOutputStream("D:\\person\\javaProject\\data\\pom_new.xml");

        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();

        /**
         * 创建直接缓冲区。
         * 给定一个直接字节缓冲区，Java 虚拟机将尽最大努力直接对它执行本机 I/O 操作。
         * 也就是说，它会在每一次调用底层操作系统的本机 I/O 操作之前(或之后)，
         * 尝试避免将缓冲区的内容拷贝到一个中间缓冲区中(或者从一个中间缓冲区中拷贝数据)。
         */
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);

        while (true) {
            logger.info("循环copy文件");
            buffer.clear();
            int r = fcin.read(buffer);
            if (r == -1) {
                break;

            }
            buffer.flip();
            fcout.write(buffer);
        }
    }
}