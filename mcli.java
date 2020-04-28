import java.util.StringTokenizer;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 
// Decompiled by Procyon v0.5.36
// 

class mcli
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
        System.out.println("enter username");
        printWriter.println(bufferedReader.readLine());
        printWriter.flush();
        if (bufferedReader2.readLine().equals("fail")) {
            System.out.println("user doesn't exist");
        }
        else {
            System.out.println("enter password");
            printWriter.println(bufferedReader.readLine());
            printWriter.flush();
            if (bufferedReader2.readLine().equals("fail")) {
                System.out.println("wrong password");
            }
            else {
                int i;
                do {
                    System.out.println("Enter choice");
                    System.out.println(" 1.Inbox\n 2.compose");
                    final int int1 = Integer.parseInt(bufferedReader.readLine());
                    printWriter.println(int1);
                    printWriter.flush();
                    switch (int1) {
                        case 1: {
                            final int int2 = Integer.parseInt(bufferedReader2.readLine());
                            System.out.println("From      Content");
                            for (int j = 0; j < int2; ++j) {
                                final StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader2.readLine(), " ");
                                stringTokenizer.nextToken();
                                System.out.print(stringTokenizer.nextToken() + "      ");
                                while (stringTokenizer.hasMoreTokens()) {
                                    System.out.print(stringTokenizer.nextToken() + " ");
                                }
                                System.out.println();
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("enter to username");
                            printWriter.println(bufferedReader.readLine());
                            printWriter.flush();
                            System.out.println("enter content");
                            printWriter.println(bufferedReader.readLine());
                            printWriter.flush();
                            break;
                        }
                    }
                    System.out.println("enter 1 to exit");
                    i = Integer.parseInt(bufferedReader.readLine());
                    printWriter.println(i);
                    printWriter.flush();
                } while (i != 1);
            }
        }
        socket.close();
    }
}
