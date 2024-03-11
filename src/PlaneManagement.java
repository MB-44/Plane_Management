import java.util.Scanner;

public class PlaneManagement {
    public static void main(String[] args) {

    }

    static Scanner scanner = new Scanner(System.in);
    static int[] seat_row_A = new int[14];
    static int[] seat_row_B = new int[12];
    static int[] seat_row_C = new int[12];
    static int[] seat_row_D = new int[14];
    static int[][] all_rows = {
                            seat_row_A,
                            seat_row_B,
                            seat_row_C,
                            seat_row_D
                            };
    static int exit = 0;
    static int ticket_count = 0;
    static Person person;
    static Ticket[] tickets = new Ticket[52];





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

    public static void buy_process(String row, int[] seat_row) {
        System.out.print("Seat Number: ");
        int ticket_price;
        scanner.nextLine();
        if (scanner.hasNextInt()) {
            try {
                int seat_num = scanner.nextInt();
                int current_seat = seat_row[seat_num - 1];
                if (seat_num <= 14 &&  current_seat == 0) {
                    seat_row[seat_num - 1] = 1;
                    person = get_person_details();

                    if (seat_num <= 5) {
                        ticket_price = 200;
                    } else if (seat_num < 10) {
                        ticket_price = 150;
                    } else {
                        ticket_price = 180;
                    }

                    Ticket ticket = new Ticket(row, seat_num, ticket_price, person);
                    tickets[ticket_count++] = ticket;


                }
            }
        }
    }

    public static void cancel_process(int[] seat_row, String row) {

    }
//    function for menu options
    public static void buy_seat() {
        System.out.print("Row letter: ");
        String row = scanner.next().toUpperCase();

        switch (row) {
            case "A":
                buy_process("A", seat_row_A);
                break;
            case "B":
                buy_process("B", seat_row_B);
                break;
            case "C":
                buy_process("C", seat_row_C);
                break;
            case "D":
                buy_process("D", seat_row_D);
                break;
            default:
                {
                    System.out.println("Invalid row, please enter a correct row");
                    buy_seat();
                }
        }
    }
    public static void cancel_seat(){
        System.out.println("Row letter: ");
        String row = scanner.next().toUpperCase();

        switch (row) {

        }
    }
    public static void find_first_available_seat() {}
    public static void show_seating_plan() {}
    public static void print_ticket_info() {}
    public static void search_ticket() {}


}
