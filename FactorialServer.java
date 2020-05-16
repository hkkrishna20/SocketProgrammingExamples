import java.io.Writer;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

// 
// Decompiled by Procyon v0.5.36
// 

class FactorialServer implements Runnable
{
    Socket s;
    int id;
    
    public static void main(final String[] array) {
        final int n = 9999;
        final int n2 = 0;
        try {
            final ServerSocket serverSocket = new ServerSocket(n);
            System.out.println("Waiting for client");
            while (true) {
                new Thread(new FactorialServer(serverSocket.accept(), n2)).start();
            }
        }
        catch (Exception ex) {
            System.out.println("Error");
        }
    }
    
    FactorialServer(final Socket s, final int id) {
        this.s = s;
        this.id = id;
    }
    
    @Override
    public void run() {
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.s.getInputStream()));
            final PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(this.s.getOutputStream()));
            final int int1 = Integer.parseInt(bufferedReader.readLine());
            long n = 1L;
            System.out.println("Number sent by client: " + int1);
            for (int i = 2; i <= int1; ++i) {
                n *= i;
            }
            printWriter.println("Factorial is : " + n);
            printWriter.flush();
        }
        catch (Exception ex) {
            System.out.println("Thread: Error");
        }
    }
}
