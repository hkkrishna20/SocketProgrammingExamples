import java.io.PrintWriter;
import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

class cli
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter port number");
        final Socket socket = new Socket("localhost", Integer.parseInt(bufferedReader.readLine()));
        if (socket.isConnected()) {
            System.out.println("connetion success");
        }
        final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        String line = "hai";
        while (!line.equals("BYE")) {
            System.out.println(bufferedReader2.readLine());
            System.out.print("Client:  ");
            line = bufferedReader.readLine();
            printWriter.println(line);
            printWriter.flush();
        }
        System.out.println("disconnected");
        socket.close();
    }
}
