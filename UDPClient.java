import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.DatagramSocket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

class UDPClient
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final DatagramSocket datagramSocket = new DatagramSocket();
        final InetAddress byName = InetAddress.getByName("localhost");
        final byte[] array2 = new byte[1024];
        final byte[] array3 = new byte[1024];
        final byte[] bytes = bufferedReader.readLine().getBytes();
        datagramSocket.send(new DatagramPacket(bytes, bytes.length, byName, 9876));
        final DatagramPacket datagramPacket = new DatagramPacket(array3, array3.length);
        datagramSocket.receive(datagramPacket);
        System.out.println("FROM SERVER:" + new String(datagramPacket.getData()));
        datagramSocket.close();
    }
}
