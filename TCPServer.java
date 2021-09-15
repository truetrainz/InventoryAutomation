package Main;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.time.LocalTime;

public class TCPServer implements Runnable {

    private TCPQueue queue;

    TCPServer(TCPQueue queue) {
        this.queue = queue;
    }

    public void run() {
        LocalTime time = LocalTime.now();
        try {
            ServerSocket ss = new ServerSocket(81);
            while (queue.size() > 0 || (time.getHour() >= 8) && (time.getHour() < 21)) {
                Socket s = ss.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                while (true) {
                    String working = in.readLine();
                    System.out.println("received: " + working);
                    if (!working.isEmpty()) {
                        queue.add(working);
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
