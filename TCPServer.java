package Main;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;

public class TCPServer {

    ProcessingQueue TCPQ;

    TCPServer(ProcessingQueue TCPQ) {
        this.TCPQ = TCPQ;
    }

    public void run() {
        try {
            ServerSocket ss = new ServerSocket(81);
            while (true) {
                Socket s = ss.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                while (true) {
                    String working = in.readLine();
                    System.out.println("received: " + working);
                    if (!working.isEmpty()) {
                        //TCPQ.addItem();
                        // need to finish this here
                    }
                    out.writeBytes("200\n");
                    out.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
