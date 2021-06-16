package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

public class ProcessingRunnable implements Runnable{
    private ProcessingQueue queue;

    public ProcessingRunnable(ProcessingQueue queueIn) {
        queue = queueIn;
    }

    @Override
    public void run() {
        System.out.println("processing runnable is now running");
        LocalTime time = LocalTime.now();
        String fileName = "/Users/nickcliffel/Documents/InnovationCenter/Inventory.rtf";
        File inventoryFile = new File(fileName);

        while (queue.queueSize() > 0 || ((time.getHour() >= 8) && (time.getHour() < 21))) {
            if (queue.queueSize() <= 0);
            if (queue.queueSize() > 0) {
                System.out.println("processingThread has made it past the while loop and wait statement");
                Barcode barcode = queue.getItem();
                int productNumber = barcode.getProductNumber();
                if (inventoryFile != null) {
                    readFile(inventoryFile, barcode);
                }
            }
            time = LocalTime.now();
        }
    }

    public void readFile(File file, Barcode barcode) {
    }

    public void wrightToFile(String name) {

    }
}
