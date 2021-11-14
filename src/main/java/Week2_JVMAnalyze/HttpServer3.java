package Week2_JVMAnalyze;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;


/**
 *  作业5 选作
 *
 *
 */
public class HttpServer3 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8083);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() + 2);
        while(true)
        {
            try {
                final Socket socket = serverSocket.accept();

                executorService.execute(()->{
                    try {
                        service(socket);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });


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
