import java.io.DataOutputStream;
import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

class TCPClient
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        final Socket socket = new Socket("localhost", 6789);
        final DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        dataOutputStream.writeBytes(bufferedReader.readLine() + '\n');
        System.out.println("FROM SERVER: " + bufferedReader2.readLine());
        socket.close();
    }
}
