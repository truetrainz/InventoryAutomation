package Main;

public class Main {
    public static void main(String[] args) {
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
    }
}
