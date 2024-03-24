public class Ticket {
    private String row;
    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    public String get_row() {
        return row;
    }
    public void set_row(String row) {
        this.row = row;
    }

    public int get_seat() { return seat; }
    public void set_seat(int seat) { this.seat = seat; }

    public double get_price() { return price; }
    public void  set_price(double price) { this.price = price; }

    public Person get_person() { return person; }
    public  void set_person(Person person) { this.person = person; }

    public void ticket_details() {
        String row = " Row  : " + this.row;
        String seat = " Seat  : " + this.seat;
        String price = " Price  : " + this.price;
        String name = " Name  : " + person.get_name();
        String email = " Email  : " + person.get_email();

    }

    private void print_line(int width) {
        System.out.print("+");
        for (int i = 0; i < width - 2; i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }

    private void print_text(String text, int width) {
        System.out.print("|");

        int padding = width - 2 - text.length();
        int padding_top = padding / 2;
        int padding_bottom = padding - padding_top;

        for (int i = 0; i < padding_top; i++) {
            System.out.print(" ");
        }

        System.out.print(text);

        for (int i = 0; i < padding_bottom; i++) {
            System.out.print(" ");
        }

        System.out.println("|");
    }

}
