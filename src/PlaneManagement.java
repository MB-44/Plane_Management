import java.util.Scanner;

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

    public static void showMenuOptions() {
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

        int option = getValidInput();
        switch (option) {
            case 1:
                buySeat();
                break;
            case 2:
                cancelSeat();
                break;
            case 3:
                findFirstAvailableSeat();
                break;
            case 4:
                showSeatingPlan();
                break;
            case 5:
                printTicketInfo();
                break;
            case 6:
                searchTicket();
                break;
            case 0:
                exit = 1;

        }
    }

    public static void buySeat() {}
    public static void cancelSeat(){}
    public static void findFirstAvailableSeat() {}
    public static void showSeatingPlan() {}
    public static void printTicketInfo() {}
    public static void searchTicket() {}

    public static int getValidInput() {
        int option = 0;
        try {
            System.out.print("Enter a option: ");
            option = scanner.nextInt();

            if (option < 0 || option > 6) {
                System.err.println("Invalid option, Please Enter a option between 0 - 7");
                showMenuOptions();
            }
        } catch (Exception event) {
                scanner.nextLine();
                System.err.println("Invalid type, please enter a number");
                showMenuOptions();
            }
        return option;
        }
}
