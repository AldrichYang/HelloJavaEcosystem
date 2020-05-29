package nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by yh on 2018/5/30.
 */
public class ScatteringAndGathering {
    public static void main(String[] args) throws IOException {

        scatteringRead();
        gatheringWrite();
    }

    private static void scatteringRead() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);


        ByteBuffer[] bufferArray = {header, body};
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        channel.read(bufferArray);
    }

    private static void gatheringWrite() throws IOException {
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);

        //write data into buffers

        ByteBuffer[] bufferArray = {header, body};
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel channel = aFile.getChannel();
        channel.write(bufferArray);
    }
}
