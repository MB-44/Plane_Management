import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PlaneManagement {
    public static void main(String[] args) {
        System.out.println("\nWelcome to the Plane Management application\n");
        System.out.print("""
                **********************************
                *          MENU OPTIONS          *
                **********************************
                """);
        do {
            show_menu_options();
        } while (exit != 1);
    }

    static int exit = 0;
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
    static Person person;
    static Ticket[] tickets = new Ticket[52];
    static int ticket_count = 0;

    public static void show_menu_options() {
        System.out.println
                ("""
                
                    1) Buy a seat
                    2) Cancel a seat
                    3) Find first available seat
                    4) Show seating plan
                    5) Print tickets information and total sales
                    6) Search Ticket
                    0) Quit
                """);

        int input = get_valid_input();
        switch (input) {
            case 1:
                buy_seat();
                break;
            case 2:
                cancel_seat();
                break;
            case 3:
                find_first_available();
                break;
            case 4:
                show_seating_plan();
                break;
            case 5:
                print_tickets_info();
                break;
            case 6:
                search_ticket();
                break;
            case 0:
                exit = 1;
        }
    }

    public static void buy_seat() {
        System.out.print("Enter row letter (A / B / C / D): ");
        String row = scanner.next().toUpperCase();

        switch (row) {
            case "A" -> buy_process("A", seat_row_A);
            case "B" -> buy_process("B", seat_row_B);
            case "C" -> buy_process("C", seat_row_C);
            case "D" -> buy_process("D", seat_row_D);
            default -> {
                System.out.println("Enter correct row");
                buy_seat();
            }
        }
    }

    public static void cancel_seat(){

        System.out.println("Enter row letter(A/B/C/D)");
        String row= scanner.next().toUpperCase();

        switch (row) {
            case "A" -> cancel_process(seat_row_A,row);
            case "B" -> cancel_process(seat_row_B,row);
            case "C" -> cancel_process(seat_row_C,row);
            case "D" -> cancel_process(seat_row_D,row);
            default -> {
                System.out.println("Invalid Row!");
                cancel_seat();
            }
        }
    }

    public static void find_first_available(){
        int row_name = 0;
        for(int[] row : all_rows) {
            int seat_num = 1;
            String[] row_names = {"A","B","C","D"};

            for(int i : row){
                if(i == 0) {
                    System.out.println("Row: " + row_names[row_name] + " seat number: " + seat_num + " is free.");
                    show_menu_options();
                    return;
                }
                seat_num++;

                if(row == seat_row_D && seat_num == 14) {
                    System.out.println("Sorry, Every seat is already booked!");
                    show_menu_options();
                    return;
                }
            }
            row_name++;
        }
    }
    public static void show_seating_plan(){
        int seat_index=0;
        for(int[] row : all_rows){
            for(int i : row){
                if(i == 0) {
                    System.out.print("O ");
                }
                else {
                    System.out.print("X ");
                }
                if(seat_index == 25) {
                    System.out.println();
                }
                if (seat_index == 13 || seat_index == 25|| seat_index == 37 || seat_index == 52){
                    System.out.println();
                }
                seat_index++;
            }
        }
        show_menu_options();
    }
    public static void  print_tickets_info(){
        double total_amount=0;

        try {
            for (Ticket ticket : tickets) {
                System.out.print(ticket.get_row() + ticket.get_seat() + ", ");
                total_amount = total_amount + ticket.get_price();
            }
        } catch (Exception event){
            System.out.println();
        }
        System.out.println("Total amount: " + total_amount);
        show_menu_options();
    }
    public static void search_ticket() {
        int index = 0;
        System.out.println("Enter row (A / B / C / D):");
        String row = scanner.next().toUpperCase();

        if (row.equals("A") || row.equals("D")) {
            int seat;
            System.out.println("Enter seat number (1- 14): ");
            try {
                seat = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception event) {
                System.out.println("Invalid type,Please enter a Number ");
                search_ticket();
                return;
            }

            try {
                if (seat >= 1 && seat <= 14) {
                    search_process(index, row, seat);
                } else {
                    System.out.println("Enter seat number between 1 - 14");
                    search_ticket();
                }
            }
            catch (Exception event) {
                System.out.println("Available for booking");
            }

        } else if (row.equals("C") || row.equals("B")) {
            int seat;
            System.out.println("Enter seat number (1 - 12): ");
            try {
                seat = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception event) {
                System.out.println("Invalid type,Please enter a Number");
                search_ticket();
                return;
            }

            try {
                if (seat >= 1 && seat <= 12) {
                    search_process(index, row, seat);
                } else {
                    System.out.print("Enter seat number between 1 - 12: ");
                    search_ticket();
                }
            } catch (Exception e) {
                System.out.println("Available for booking!");
            }

        } else {
            System.out.println("Enter correct row letter( A / B / C / D)");
            search_ticket();
        }
        show_menu_options();
    }
    public static void search_process(int index, String row, int seat) {
        while (index < 52 ) {
            if(tickets[index].get_row() == null || !tickets[index].get_row().equals(row) || tickets[index].get_seat() != seat) {
                index++;
            } else {
                break;
            }
        }

        if (index == 52) {
            System.out.println("Not available, please try another one");
        } else {
            tickets[index].ticket_details();
        }
    }
    public static Person get_person_details() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your E-mail: ");
        String email = scanner.nextLine();

        person = new Person(name,email);

        return person;
    }
    public static void buy_process(String row,int[] seat_row) {
        System.out.print("Enter seat number: ");
        int ticket_price;
        scanner.nextLine();

        if (scanner.hasNextInt()) {
            try {
                int seatNum = scanner.nextInt();
                scanner.nextLine();
                if (seat_row[seatNum - 1] == 0 && seatNum <= 14) {
                    seat_row[seatNum - 1] = 1;
                    person = get_person_details();

                    if(seatNum <= 5){
                        ticket_price = 200;
                    } else if (seatNum < 10) {
                        ticket_price= 150;
                    } else {
                        ticket_price = 180;
                    }

                    Ticket ticket = new Ticket(row, seatNum, ticket_price, person);
                    tickets[ticket_count++] = ticket;
                    save(row+seatNum, ticket);
                    System.out.println("Seat Booked!");
                    show_menu_options();

                } else {
                    System.out.println("Already sold");
                    show_menu_options();
                }

            } catch (Exception event){
                if (row.equals("A") || row.equals("D")){
                    System.out.print("Enter seat number between 1 - 14: ");
                } else {
                    System.out.print("Enter seat number below 1 - 12: ");
                }
            }
        } else {
            scanner.nextLine();
            System.out.println("Invalid input! Try again!\n");
            buy_seat();
        }
    }

    public static void cancel_process(int[] seat_row,String row){
        scanner.nextLine();
        System.out.println("Enter seat number");

        if(scanner.hasNextInt()){
            int seatNum = scanner.nextInt();
            scanner.nextLine();

            if (seat_row[seatNum - 1] == 1){
                seat_row[seatNum-1] = 0;
                System.out.println("seat cancelled");

                try {
                    for(int i = 0; i < tickets.length; i++) {
                        if (tickets[i].get_row().equals(row) && tickets[i].get_seat() == seatNum){
                            tickets[i] = null;
                        }
                    }
                } catch (Exception event){
                    System.out.println();
                }

            } else {
                System.out.println("Already free");
                show_menu_options();
            }
        } else {
            System.out.println("Enter valid input");
            scanner.nextLine();
            cancel_seat();
        }
    }

    public static void save(String x,Ticket t){
        try {
            File file = new File(x + ".txt");
            System.out.println("--------------------------------");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");

        }

        try {
            FileWriter myWriter = new FileWriter(x + ".txt");
            myWriter.write("Row: " + t.get_row() + "\n" +
                    "Seat: " + t.get_seat() + "\n" +
                    "Price: " + t.get_price() +"\n" +
                    "Person name: " + t.get_person().get_name() + "\n" +
                    "Email: " + t.get_person().get_email());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException event) {
            System.out.println("An error occurred.");

        }
        System.out.println("--------------------------------");
    }

    public static int get_valid_input(){
        int input =0;
        try {
            input = scanner.nextInt();
            scanner.nextLine();

            if (input < 0 || input > 6 ) {
                System.err.println("Invalid option, please enter a option between 0 - 7 (0 to quit)");
                show_menu_options();
            }
        } catch (Exception e)
            {
                scanner.nextLine();
                System.err.println("Invalid option, please enter a integer between 0 - 7 (0 to quit)");
                show_menu_options();
            }
        return input;
    }
}