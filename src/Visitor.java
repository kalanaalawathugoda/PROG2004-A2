public class Visitor implements Comparable<Visitor> {

    private String id;
    private String name;
    private int age;
    private String ticketType;

    public Visitor(String id, String name, int age, String ticketType) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ticketType = ticketType;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public int compareTo(Visitor other) {
        return this.id.compareTo(other.id);
    }
}