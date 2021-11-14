package Week2_JVMAnalyze;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 作业5 选作
 *
 *
 */
public class HttpServer2 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8082);

        while(true)
        {
            try {
                final Socket socket = serverSocket.accept();

                new Thread(()->{
                    try {
                        service(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();

            }
            catch (IOException e)
            {
                e.printStackTrace();
            }

        }



    }

    private static void service(Socket socket) throws IOException {

        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("HTTP/1.1 200 OK");
        printWriter.println("Content-Type:text/html;charset=utf-8");
        String body = "hello nio1";
        printWriter.println("Content-Length:" +body.getBytes().length);
        printWriter.println();
        printWriter.write(body);
        printWriter.close();
        socket.close();

    }
}
