import java.io.InputStream;
import java.net.Socket;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

public class EchoServer
{
    public static void main(final String[] array) throws Exception {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(" Enter the Port Address : ");
            final ServerSocket serverSocket = new ServerSocket(Integer.parseInt(bufferedReader.readLine()));
            System.out.println(" Server is Ready To Receive a Message. ");
            System.out.println(" Waiting ..... ");
            final Socket accept = serverSocket.accept();
            if (accept.isConnected()) {
                System.out.println(" Client Socket is Connected Succecfully. ");
            }
            final InputStream inputStream = accept.getInputStream();
            final PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
            final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
            final BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" Message Received From Client : " + bufferedReader2.readLine());
            printWriter.println(bufferedReader3.readLine());
            printWriter.flush();
        }
        catch (Exception ex) {
            System.out.println(" Error : " + ex.getMessage());
        }
    }
}
