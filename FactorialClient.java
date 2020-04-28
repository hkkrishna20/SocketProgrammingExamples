import java.io.Writer;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.InetAddress;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

class FactorialClient
{
    public static void main(final String[] array) {
        final int n = 9999;
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            final Socket socket = new Socket(InetAddress.getByName(null), n);
            final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.print("Enter a Number :  ");
            printWriter.println(bufferedReader.readLine());
            printWriter.flush();
            final String line = bufferedReader2.readLine();
            System.out.println("Answer from server : ");
            System.out.println(line);
        }
        catch (Exception ex) {}
    }
}
