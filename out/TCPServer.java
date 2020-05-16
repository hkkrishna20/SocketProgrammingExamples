import java.net.Socket;
import java.io.DataOutputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;

// 
// Decompiled by Procyon v0.5.36
// 

class TCPServer
{
    public static void main(final String[] array) throws Exception {
        final ServerSocket serverSocket = new ServerSocket(6789);
        while (true) {
            final Socket accept = serverSocket.accept();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
            final DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
            final String line = bufferedReader.readLine();
            System.out.println("Received: " + line);
            dataOutputStream.writeBytes(line.toUpperCase() + '\n');
        }
    }
}
