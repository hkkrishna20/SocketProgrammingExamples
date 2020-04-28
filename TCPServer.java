import java.net.*;
            import java.util.*;
            import java.io.*;

            public class TCPServer
            {
public static void main(String args[]) throws IOException
            {
            try
            {
            int Port;
BufferedReader Buf =new BufferedReader(new
InputStreamReader(System.in));
            System.out.print(" Enter the Port Address : " );
            Port=Integer.parseInt(Buf.readLine());
            ServerSocket ss = new ServerSocket(Port);
            System.out.println(" Wait Client Socket is Connecting ..... ");
            Socket s=ss.accept();
            if(s.isConnected()==true)
            System.out.println(" Client Socket is Connected Succecfully. ");
            OutputStream out = s.getOutputStream();
            PrintWriter p=new PrintWriter(out);
            Date d=new Date();
            p.print(" Current Server Time is : " + d);
            p.flush();
            out.close();
            System.out.println(" Message send Successfully. " );
            }
            catch(Exception e)
                        {
                                      System.out.println(" Error : " + e.getMessage());
                          }
              }
            }