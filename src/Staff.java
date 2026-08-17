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

//    Creates a staff member with a default role.

    public Staff(String id, String name, int age) {
        this(id, name, age, "General Staff");
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

    // Sets the staff ID.
  
    public void setId(String id) {

        if (id == null || !id.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "Staff ID must contain numbers only."
            );
        }

        this.id = id;
    }

//    Sets the staff member's name.
   
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Staff name cannot be empty."
            );
        }

        this.name = name;
    }

//    Sets the staff member's age.
   
    public void setAge(int age) {

        if (age < 0) {
            throw new IllegalArgumentException(
                    "Staff age cannot be negative."
            );
        }

        this.age = age;
    }

//    Sets the staff member's role.
  
    public void setRole(String role) {

        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Staff role cannot be empty."
            );
        }

        this.role = role;
    }

//    Performs an inspection on an inspectable object.
   
    public void performInspection(
            Inspectable inspectable,
            String result
    ) {

        if (inspectable == null) {
            System.out.println(
                    "Cannot inspect a null object."
            );
            return;
        }

        System.out.println(
                name +
                " is starting an inspection of " +
                inspectable.getInspectionName() +
                "."
        );

        inspectable.startInspection();

        inspectable.recordInspection(result);

        inspectable.finishInspection();

        System.out.println(
                name +
                " has completed the inspection of " +
                inspectable.getInspectionName() +
                "."
        );
    }

    // Returns all staff details in readable form.
     
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