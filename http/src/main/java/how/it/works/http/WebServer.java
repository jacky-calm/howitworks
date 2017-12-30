package how.it.works.http;

import java.net.*;

public class WebServer {
    public static void main(String args[]) {
        int i = 1, PORT = 8080;
        ServerSocket server = null;
        Socket client = null;
        try {
            server = new ServerSocket(PORT);
            System.out.println("Web Server is listening on port " + server.getLocalPort());
            for (; ; ) {
                client = server.accept(); // Accept a client connection requests
                new ConnectionThread(client, i).start();
                i++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
