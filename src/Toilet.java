public class Toilet implements Inspectable{

    private String id;
    private String name;
    private boolean closed;
    private String lastInspectionResult;

    public Toilet(String id, String name) {
        setId(id);
        setName(name);

        this.closed = false;
        this.lastInspectionResult = "No inspections yet.";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
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

    @Override
public String getInspectionName() {
        return getName();
    }

   @Override
   public void startInspection(){
        closed = true;
        System.out.println(name + " is now closed for inspection.");
    }

    @Override
    public void recordInspection(String result) {
        if(result == null || result.trim().isEmpty()){
            lastInspectionResult = "No results supplied";
        } else {
            lastInspectionResult = result;
        }

        System.out.println(name + " inspection result recorded: " + lastInspectionResult);
    }

    @Override
    public void finishInspection() {
        closed = false;
        System.out.println(name + " is now open after inspection.");
    }

    @Override
    public boolean isClosed() {
        return closed;
    }

    @Override
    public String getLastInspectionResult() {
        return lastInspectionResult;
    }

    @Override
    public String toString() {
        return "Toilet{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", closed=" + isClosed() +
                ", lastInspectionResult='" + getLastInspectionResult() + '\'' +
                '}';    
   }
}