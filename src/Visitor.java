// Represent a visitor who enters the theme park.

public class Visitor implements Comparable<Visitor> {

    private String id;
    private String name;
    private int age;
    private String ticketType;

    public Visitor(String id, String name, int age, String ticketType) {
        setId(id);
        setName(name);
        setAge(age);
        setTicketType(ticketType);
    }

    public Visitor(String id, String name, int age) {
        this(id, name, age, "Standard");
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null or empty.");
        }

        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }

        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }

        this.age = age;
    }

    public void setTicketType(String ticketType) {
        if (ticketType == null || ticketType.trim().isEmpty()) {
            throw new IllegalArgumentException("Ticket type cannot be null or empty.");
        }

        this.ticketType = ticketType;
    }

// Orders visitors by age

    @Override
    public int compareTo(Visitor other) {
        return Integer.compare(this.age, other.age);
    }


    //  Visitors are considered equal when their IDs match.

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
       if (!(object instanceof Visitor)) {
            return false;
        }
        Visitor other = (Visitor) object;
        return this.id.equals(other.id);
    }

    // Generates a hash code from the visitor ID.


    @Override
    public int hashCode() {
        return id.hashCode();
    }

    // Returns all visitor information in readable form

    @Override
    public String toString() {
        return "Visitor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ticketType='" + ticketType + '\'' +
                '}';
    }
}