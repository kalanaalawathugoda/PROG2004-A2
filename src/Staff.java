// Represents a staff member who works at the theme park.

public class Staff {
    private String id;
    private String name;
    private int age;
    private String role;

    // Creates a staff member with all required details.

    public Staff(String id, String name, int age, String role) {
        setId(id);
        setName(name);
        setAge(age);
        setRole(role);
    }

    // Creates a staff member with a default role.

    public Staff(String id, String name, int age) {
        this(id, name, age, "General");
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

    public String getRole() {
        return role;
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

    public void setRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be null or empty.");
        }
        this.role = role;
    }

    // Performs an inspection on an inspectable object.

    public void performInspection(Inspectable inspectable, String result){
    System.out.println(name + " is starting an inspection of " + inspectable.getInspectionName() );

    inspectable.startInspection();
    inspectable.recordInspectionResult(result);
    inspectable.finishInspection();

    System.out.println(name + " has completed the inspection of " + inspectable.getInspectionName() );

}

// Returns all staff information in readable form.

@Override
public String toString() {
    return "Staff{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", role='" + role + '\'' +
            '}';
}

}

