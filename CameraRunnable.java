package Main;

import java.time.LocalTime;
import java.util.Scanner;
import java.util.Random;

public class CameraRunnable implements Runnable {
    private ProcessingQueue queue;

    public CameraRunnable(ProcessingQueue queueIn) {
        queue = queueIn;
    }

    @Override
    public void run() {
        System.out.println("camera runnable is running");
        LocalTime time = LocalTime.now();
        boolean hasBarcode = true;
        while (time.getHour() >= 8 && time.getHour() < 24 && hasBarcode) {
            Random rand = new Random();
            int productNumber = rand.nextInt(11);
            Scanner inputScanner = new Scanner(System.in);
            String finalInput = "";
            boolean correct = false;
            char dirChar;
            int number = 0;
            do {
                System.out.println("If it is incoming type I, if it is outgoing type O:");
                String direction = inputScanner.nextLine();
                dirChar = direction.trim().charAt(0);
                while (dirChar != 'I' && dirChar != 'i' && dirChar != 'O' && dirChar != 'o') {
                    System.out.println("You did not input a I or O. Please input an I for incoming inventory "
                            + "or a O for out going inventory.");
                    direction = inputScanner.nextLine();
                    dirChar = direction.trim().charAt(0);
                }
                boolean digits;
                do {
                    System.out.println("Input the number of the incoming or outgoing inventory.");
                    String numberString = inputScanner.nextLine();
                    digits = allNumbers(numberString);
                    if (digits) {
                        number = Integer.parseInt(numberString.trim());
                    } else {
                        System.out.println("You did not input a number please input the number of "
                                + "incoming or outgoing inventory.");
                    }
                } while (!digits);
                if (dirChar == 'I' || dirChar == 'i') {
                    System.out.println("There are " + number + " incoming items. Put in a T for true, an F for false or a X for escape.");
                } else {
                    System.out.println("There are " + number + " out going items. Put in a T for true, and F for false or a X for escape.");
                }
                finalInput = inputScanner.nextLine();
                if (finalInput.trim().charAt(0) == 'T' || finalInput.trim().charAt(0) == 't' || finalInput.trim().charAt(0) == 'X' || finalInput.trim().charAt(0) == 'x') {
                    correct = true;
                } else {
                    correct = false; // add an else if to make the program more user friendly
                }
            } while (!correct);
            if (finalInput.trim().charAt(0) == 'T' || finalInput.trim().charAt(0) == 't') {
                Barcode barcode = new Barcode(dirChar, number, productNumber);
                queue.addItem(barcode);
                System.out.println(barcode.toString());
                hasBarcode = false; // put here for testing
            }
            time = LocalTime.now();
        }
    }

    public boolean allNumbers(String input) {
        String working = input.trim();
        boolean result = true;
        for (int i = 0; i < working.length(); i++) {
            if (!Character.isDigit(working.charAt(i))) {
                result = false;
                break;
            }
        }
        return result;
    }
}
