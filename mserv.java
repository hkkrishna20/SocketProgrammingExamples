import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

class mserv
{
    public static void main(final String[] array) throws Exception {
        final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter port number");
        final BufferedReader bufferedReader2 = new BufferedReader(new FileReader("user.txt"));
        final BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("user.txt", true));
        final ServerSocket serverSocket = new ServerSocket(Integer.parseInt(bufferedReader.readLine()));
        System.out.println("waiting....");
        final Socket accept = serverSocket.accept();
        if (accept.isConnected()) {
            System.out.println("connection successful");
        }
        final InputStream inputStream = accept.getInputStream();
        final PrintWriter printWriter = new PrintWriter(accept.getOutputStream());
        final BufferedReader bufferedReader3 = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader3.readLine();
        Object nextToken = null;
        Boolean b = true;
        while (b) {
            final String line = bufferedReader2.readLine();
            if (line == null) {
                b = false;
                break;
            }
            final StringTokenizer stringTokenizer = new StringTokenizer(line, " ");
            final String nextToken2 = stringTokenizer.nextToken();
            nextToken = stringTokenizer.nextToken();
            if (s.equals(nextToken2)) {
                printWriter.println("success");
                printWriter.flush();
                break;
            }
        }
        if (b) {
            if (bufferedReader3.readLine().equals(nextToken)) {
                printWriter.println("success");
                printWriter.flush();
                do {
                    switch (Integer.parseInt(bufferedReader3.readLine())) {
                        default: {
                            continue;
                        }
                        case 1: {
                            final BufferedReader bufferedReader4 = new BufferedReader(new FileReader("mail.txt"));
                            final Boolean value = true;
                            int n = 0;
                            while (value) {
                                final String line2 = bufferedReader4.readLine();
                                if (line2 == null) {
                                    break;
                                }
                                if (!s.equals(new StringTokenizer(line2, " ").nextToken())) {
                                    continue;
                                }
                                ++n;
                            }
                            printWriter.println(n);
                            printWriter.flush();
                            final BufferedReader bufferedReader5 = new BufferedReader(new FileReader("mail.txt"));
                            while (value) {
                                final String line3 = bufferedReader5.readLine();
                                final String s2;
                                if ((s2 = line3) == null) {
                                    break;
                                }
                                if (!s.equals(new StringTokenizer(line3, " ").nextToken())) {
                                    continue;
                                }
                                printWriter.println(s2);
                                printWriter.flush();
                            }
                            continue;
                        }
                        case 2: {
                            final BufferedWriter bufferedWriter2 = new BufferedWriter(new FileWriter("mail.txt", true));
                            s = bufferedReader3.readLine() + " " + s + " " + bufferedReader3.readLine();
                            bufferedWriter2.write(s);
                            bufferedWriter2.newLine();
                            bufferedWriter2.flush();
                            continue;
                        }
                    }
                } while (Integer.parseInt(bufferedReader3.readLine()) != 1);
            }
            else {
                printWriter.println("fail");
                printWriter.flush();
            }
        }
        else {
            printWriter.println("fail");
            printWriter.flush();
        }
        accept.close();
    }
}
