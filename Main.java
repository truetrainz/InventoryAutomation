package Main;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;

public class Main {

    public static final boolean runEntryScripts = true;

    public static void main(String[] args) {
        printStatement();
        DatabaseSetup dbset = new DatabaseSetup();
        dbset.createInTable();
        dbset.createInventoryTable();
        dbset.createInTableSequence();
        dbset.createInventoryTableSequence();
        ProcessingQueue UDPQ = new ProcessingQueue();
        /**
        Connection conn = Database.getConnection();
        if (conn != null) {
            System.out.println("The connection was established");
        } else {
            System.out.println("The connection failed to establish");
        }
                ProcessingQueue queue = new ProcessingQueue();
                ProcessingRunnable processing = new ProcessingRunnable(queue);
                CameraRunnable camera = new CameraRunnable(queue);
                Webcam webcam = new Webcam();
                Thread webcamThread = new Thread(webcam);
                Thread processingThread = new Thread(processing);
                Thread cameraThread = new Thread(camera);
                //webcamThread.start();
                processingThread.start();
                cameraThread.start();
        }*/
    }

    public static void printStatement() {
        System.out.println("------- |\\      |  -------- \\            /   /\\       ------- -------  --------  |\\      |");
        System.out.println("   |    | \\     | |        | \\          /   /  \\         |       |    |        | | \\     |");
        System.out.println("   |    |  \\    | |        |  \\        /   /    \\        |       |    |        | |  \\    |");
        System.out.println("   |    |   \\   | |        |   \\      /   /------\\       |       |    |        | |   \\   |");
        System.out.println("   |    |    \\  | |        |    \\    /   /        \\      |       |    |        | |    \\  |");
        System.out.println("   |    |     \\ | |        |     \\  /   /          \\     |       |    |        | |     \\ |");
        System.out.println("------- |      \\|  --------       \\/   /            \\    |    -------  --------  |      \\|");
        System.out.println("");
        System.out.println("");
        System.out.println(" ------  ----- |\\      | -------  -----  ---");
        System.out.println("|       |      | \\     |    |    |      |   \\");
        System.out.println("|       |      |  \\    |    |    |      |    |");
        System.out.println("|       |----- |   \\   |    |    |----- |   /");
        System.out.println("|       |      |    \\  |    |    |      |--");
        System.out.println("|       |      |     \\ |    |    |      |  \\");
        System.out.println(" ------  ----- |      \\|    |     ----- |   \\");
    }
}
