import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.IOError;
import java.util.Scanner;

public class PlaneManagement {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to the Plane Management application\n");
        System.out.print("""
                **********************************
                *          MENU OPTIONS          *
                **********************************
                """);
        while(true) {
            selectMenuOptions();
        }
    }


    public static int getInput() {
        int input = 0;
        try {
            input = scanner.nextInt("Enter a number between 0 - 7 : ");

            if (input < 0 || input > 6) {
                System.err.println("Please enter option between 0 - 7");
                selectMenuOptions();
            }

        }
        catch (Exception Event) {
    }

    public static void selectMenuOptions() {
        System.out.println(
                """
                   1) Buy a seat
                   2) Cancel a seat
                   3) Find first available seat
                   4) Show seating plan
                   5) Print tickets information and total sales
                   6) Search Ticket
                   7) Quit     
                *************************************************        
                """
        );
        int selectedOption = getInput();
    }
}
}
