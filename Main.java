package Main;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static final boolean runEntryScripts = true;

    public static void main(String[] args) {
        printStatement();
        DatabaseSetup dbset = new DatabaseSetup();
        dbset.createInTable();
        dbset.createInventoryTable();
        dbset.createInTableSequence();
        dbset.createInventoryTableSequence();
        TCPQueue queue = new TCPQueue();
        Inventory testInventory = new Inventory("this is a test", 100, "test", 12345);
        InventoryDatabaseDriver.addInventory(testInventory);
        System.out.println("Run?");
        Scanner scan = new Scanner(System.in);
        if (scan.hasNextLine()) {
            if (scan.nextLine().trim().equalsIgnoreCase("R")) {
                Tester tester = new Tester(queue);
                ProcessingRunnable pRun = new ProcessingRunnable(queue);
                pRun.run();
            }
        }
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
