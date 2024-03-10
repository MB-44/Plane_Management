import java.util.Scanner;
import java.io.IOException;

public class PlaneManagement {
    public static void main(String[] args) {

    }

    static Scanner scanner = new Scanner(System.in);
    static int[] seatRowA = new int[14];
    static int[] seatRowB = new int[12];
    static int[] seatRowC = new int[12];
    static int[] seatRowD = new int[14];
    static int[][] allRows = {
                            seatRowA,
                            seatRowB,
                            seatRowC,
                            seatRowD
                            };
    static int exit = 0;
    static int ticketCount = 0;




    public static void show_menu_options() {
        System.out.println(
                """
                        1) Buy a seat
                        2) Cancel a seat
                        3) Find first available seat
                        4) Show seating plan
                        5) Print tickets information and total sales
                        6) Search Ticket
                        7) Quit
                ************************************************************
                        """
        );

        int option = get_valid_input();
        switch (option) {
            case 1:
                buy_seat();
                break;
            case 2:
                cancel_seat();
                break;
            case 3:
                find_first_available_seat();
                break;
            case 4:
                show_seating_plan();
                break;
            case 5:
                print_ticket_info();
                break;
            case 6:
                search_ticket();
                break;
            case 0:
                exit = 1;

        }
    }

    public static int get_valid_input() {
        int option = 0;
        try {
            System.out.print("Enter a option: ");
            option = scanner.nextInt();

            if (option < 0 || option > 6) {
                System.err.println("Invalid option, Please Enter a option between 0 - 7");
                show_menu_options();
            }
        } catch (Exception event) {
            scanner.nextLine();
            System.err.println("Invalid type, please enter a number");
            show_menu_options();
        }
        return option;
    }

//    public static void buy_process(String row, int[])

//    function for menu options
    public static void buy_seat() {
        System.out.print("Row letter: ");
        String row = scanner.next().toUpperCase();

        switch (row) {
            case "A":

        }
    }
    public static void cancel_seat(){}
    public static void find_first_available_seat() {}
    public static void show_seating_plan() {}
    public static void print_ticket_info() {}
    public static void search_ticket() {}


}
