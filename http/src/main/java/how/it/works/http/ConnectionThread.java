package how.it.works.http;

import java.io.*;
import java.net.Socket;

public class ConnectionThread extends Thread {
    Socket client; // Connect to the Web browser socket Word
    int counter; // Counter

    public ConnectionThread(Socket cl, int c) {
        client = cl;
        counter = c;
    }

    public void run() // Thread form
    {
        try {
            String destIP = client.getInetAddress().toString(); // The client IP address
            int destport = client.getPort(); // Client port number
            System.out.println("Connection " + counter + ":connected to " + destIP + " on port " + destport + ".");
            PrintStream outstream = new PrintStream(client.getOutputStream());
            DataInputStream instream = new DataInputStream(client.getInputStream());
            String inline = instream.readLine(); // Read your Web browser to submit the requested information
            System.out.println("Received:" + inline);
            if (getrequest(inline)) { // If a get request
                String filename = getfilename(inline);
                File file = new File(filename);
                if (file.exists()) { // If the file exists, the file is sent Web Browser
                    System.out.println(filename + " requested.");
                    outstream.println("HTTP/1.0 200 OK");
                    outstream.println("MIME_version:1.0");
                    outstream.println("Content_Type:text/html");
                    int len = (int) file.length();
                    outstream.println("Content_Length:" + len);
                    outstream.println("");
                    sendfile(outstream, file); // Send file
                    outstream.flush();
                } else { // When the file does not exist
                    String notfound = "HTTP/1.0 404 no found";
                    outstream.println();
                    outstream.println("Content_Type:text/html");
                    outstream.println("Content_Length:" + notfound.length() + 2);
                    outstream.println("");
                    outstream.println(notfound);
                    outstream.flush();
                }
            }
            long m1 = 1;
            while (m1 < 11100000) {
                m1++;
            } // Delay
            client.close();
        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }
    }

    /* Gets the request type is "GET" */
    boolean getrequest(String s) {
        if (s.length() > 0) {
            if (s.substring(0, 3).equalsIgnoreCase("GET")) return true;
        }
        return false;
    }

    /* Gets the name of the file you want to access */
    String getfilename(String s) {
        String f = s.substring(s.indexOf(' ') + 1);
        f = f.substring(0, f.indexOf(' '));
        try {
            if (f.charAt(0) == '/')
                f = f.substring(1);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception:" + e);
        }
        if (f.equals("")) f = "index.html";
        return f;
    }

    /* To specify a file sent to a Web browser */
    void sendfile(PrintStream outs, File file) {
        try {
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int len = (int) file.length();
            byte buf[] = new byte[len];
            in.readFully(buf);
            outs.write(buf, 0, len);
            outs.flush();
            in.close();
        } catch (Exception e) {
            System.out.println("Error retrieving file.");
            System.exit(1);
        }
    }
}
