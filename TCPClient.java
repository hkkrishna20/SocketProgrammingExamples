import java.net.*;
            import java.io.*;
           
            public class TCPClient
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
            Socket s = new Socket("localhost",Port);
            if(s.isConnected()==true)
            System.out.println(" Server Socket is Connected Succecfully. ");
            InputStream in = s.getInputStream();
            BufferedReader buf=new BufferedReader(new
InputStreamReader(in));
            String str = buf.readLine();
            System.out.println(" Message Received From Server. " );
            System.out.println(str);
            in.close();
            s.close();
               }
            catch(Exception e)
                        {
                              System.out.println(" Error : " + e.getMessage());
                        }
             }
            }

