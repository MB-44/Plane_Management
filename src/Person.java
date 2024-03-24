public class Person {
    private String name;
    private String email;

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void set_name(String name) { this.name = name; }
    public String get_name() { return name; }

    public void set_email(String email) { this.email = email; }
    public String get_email() { return email; }


}