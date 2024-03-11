public class Ticket {
    String row;

    private int seat;
    private double price;
    private Person person;

    public Ticket(String row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person
    }

    public String get_row() {
        return row;
    }

    public void set_row(String row) {
        this.row = row;
    }
}
