import java.net.InetAddress;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

// 
// Decompiled by Procyon v0.5.36
// 

class UDPServer
{
    public static void main(final String[] array) throws Exception {
        final DatagramSocket datagramSocket = new DatagramSocket(9876);
        final byte[] array2 = new byte[1024];
        final byte[] array3 = new byte[1024];
        while (true) {
            final DatagramPacket datagramPacket = new DatagramPacket(array2, array2.length);
            datagramSocket.receive(datagramPacket);
            final String s = new String(datagramPacket.getData());
            System.out.println("RECEIVED: " + s);
            final InetAddress address = datagramPacket.getAddress();
            final int port = datagramPacket.getPort();
            final byte[] bytes = s.toUpperCase().getBytes();
            datagramSocket.send(new DatagramPacket(bytes, bytes.length, address, port));
        }
    }
}
