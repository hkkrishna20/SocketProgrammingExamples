import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

public class EchoClient
{
    public static void main(final String[] array) throws Exception {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(" Enter the Port Address : ");
            final Socket socket = new Socket("localhost", Integer.parseInt(bufferedReader.readLine()));
            if (socket.isConnected()) {
                System.out.println(" Server Socket is Connected Succecfully. ");
            }
            final InputStream inputStream = socket.getInputStream();
            final PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(System.in));
            final BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream));
            System.out.print(" Enter the Message : ");
            printWriter.println(bufferedReader2.readLine());
            printWriter.flush();
            System.out.println(" Message Send Successfully. ");
            System.out.println(" Message From Server : " + bufferedReader3.readLine());
        }
        catch (Exception ex) {
            System.out.println(" Error : " + ex.getMessage());
        }
    }
}
