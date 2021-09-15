package Main;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.Scanner;

public class ProcessingRunnable implements Runnable{
    private TCPQueue queue;

    public ProcessingRunnable(TCPQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("processing runnable is now running");
        LocalTime time = LocalTime.now();
        String fileName = "/Users/nickcliffel/Documents/InnovationCenter/Inventory.rtf";
        File inventoryFile = new File(fileName);

        while (queue.size() > 0 || ((time.getHour() >= 8) && (time.getHour() < 21))) {
            if (queue.size() <= 0);
            if (queue.size() > 0) {
                System.out.println("processingThread has made it past the while loop and wait statement");
                String working = queue.get();
                int barcode = Integer.parseInt(working);
                System.out.println("Is this incoming or outgoing? I for incoming O for outgoing X for continue.");
                Scanner scanner = new Scanner(System.in);
                boolean pass = false;
                if (scanner.hasNextLine()) {
                    String incoming = scanner.nextLine();
                    if (incoming.trim().equalsIgnoreCase("X")) {
                        continue;
                    } else if (incoming.trim().equalsIgnoreCase("I")) {
                        int amount = getAmount();
                        String name = getName();
                        InventoryIn inventoryIn = new InventoryIn(barcode, amount, name);
                        InventoryInDatabaseDriver.addInventoryIn(inventoryIn);
                        Inventory inv = InventoryDatabaseDriver.getInventoryFromName(name);
                        if (inv != null) {
                            int newAmount = inv.getAmount() + amount;
                            InventoryDatabaseDriver.updateAmount(inv.getId(), newAmount);
                        }
                    } else if (incoming.trim().equalsIgnoreCase("O")) {
                        InventoryIn outgoing = InventoryInDatabaseDriver.getInventoryIn(barcode, true);
                        Inventory inv = InventoryDatabaseDriver.getInventoryFromName(outgoing.getName());
                        if (outgoing != null && inv != null) {
                            InventoryDatabaseDriver.updateAmount(inv.getId(), inv.getAmount() - outgoing.getAmount());
                        }
                    }
                }
            }
            time = LocalTime.now();
        }
    }

    public int getAmount() {
        System.out.println("How many?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            try {
                int amount = Integer.parseInt(scanner.nextLine().trim());
                return amount;
            } catch (Exception e) {
                e.printStackTrace();
                return -1000000;
            }
        }
        return -1000000;
    }

    public String getName() {
        System.out.println("What is the name?");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextLine()) {
            String name = scanner.nextLine().trim();
            return name;
        }
        return null;
    }
}
