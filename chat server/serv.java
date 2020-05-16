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

class serv
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter port number");
        String line = "hai";
        final ServerSocket serverSocket = new ServerSocket(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("waiting....");
        final Socket accept = serverSocket.accept();
        if (accept.isConnected()) {
            System.out.print("connection successful");
        }
        final InputStream inputStream = accept.getInputStream();
        final PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
        while (!line.equals("BYE")) {
            System.out.print("server:  ");
            printWriter.println(bufferedReader.readLine());
            printWriter.flush();
            line = bufferedReader2.readLine();
            System.out.println(line);
        }
        System.out.print("disconnected");
        accept.close();
    }
}
