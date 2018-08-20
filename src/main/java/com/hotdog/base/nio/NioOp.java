package com.hotdog.base.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 通道与流的不同之处在于通道是双向的。而流只是在一个方向上移动(一个流必须是 InputStream 或者 OutputStream 的子类)， 而 通道 可以用于读、写或者同时用于读写。
 */
public class NioOp {


    public static void main(String[] args) throws Exception {
        /**
         * 所有数据都通过 Buffer 对象来处理。
         * 您永远不会将字节直接写入通道中,相反，您是将数据写入包含一个或者多个字节的缓冲区.
         * 您不会直接从通道中读取字节，而是将数据从通道读入缓冲区，再从缓冲区获取这个字节。
         */
        copyFile();


        slice();
    }


    public static void copyFile() throws IOException {
        FileInputStream fin = new FileInputStream("D:\\person\\javaProject\\data\\pom.xml");
        FileOutputStream fout = new FileOutputStream("D:\\person\\javaProject\\data\\pom_new.xml");
        RandomAccessFile s =   new RandomAccessFile("D:\\person\\javaProject\\data\\pom.xml", "rw");

        FileChannel fcin = fin.getChannel(); // 获取通道。我们从 FileInputStream 获取通道：
        FileChannel fcout = fout.getChannel();
        /**
         * 读取和写入都是使用同一个buffer
         */
        ByteBuffer buffer = ByteBuffer.allocate(1024); // 分配一个具有指定大小的底层数组，并将它包装到一个缓冲区对象中
        MappedByteBuffer mbb =s.getChannel().map( FileChannel.MapMode.READ_WRITE,0,50 );

        for(int i=0; i< mbb.capacity(); i++){
            System.out.print((char) mbb.get());
        }

        while (true) {
            buffer.clear();
            int r = fcin.read(buffer);
            if (r == -1) {
                break;
            }
            buffer.flip();
            fcout.write(buffer);
        }
    }


    /**
     * 缓冲区分片 以及 数据共享
     * 0
     * 1
     * 2
     * 33
     * 44
     * 55
     * 66
     * 7
     * 8
     * 9
     */
    public static void slice() {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); ++i) {
            buffer.put((byte) i);
        }
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        for (int i = 0; i < slice.capacity(); ++i) {
            byte b = slice.get(i);
            b *= 11;
            slice.put(i, b);
        }

        buffer.position( 0 );
        buffer.limit( buffer.capacity() );

        while (buffer.remaining()>0) { // Returns the number of elements between the current position and the  limit.
            System.out.println( buffer.get() );
        }

    }

    static public void main1() throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(30);
        buffer.putLong(7000000000000L);
        buffer.putInt(302);
        buffer.putDouble(Math.PI);

        buffer.flip();

        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getDouble());
    }
}
