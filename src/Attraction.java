import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public abstract class Attraction{
    private String id;
    private String name;
    private int capacityPerCycle;
    private Staff operator;

    protected Queue<Visitor> waitingLine;
    protected List<Visitor> visitHistory;

    private int cycleCount;

    public Attraction(String id, String name, int capacityPerCycle, Staff operator) {
        setId(id);
        setName(name);
        setCapacityPerCycle(capacityPerCycle);

        this.operator = null;
        this.waitingLine = new LinkedList<>();
        this.visitHistory = new ArrayList<>();
        this.cycleCount = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCapacityPerCycle() {
        return capacityPerCycle;
    }

    public Staff getOperator() {
        return operator;
    }

    public int getCycleCount() {
        return cycleCount;
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

    public void setCapacityPerCycle(int capacityPerCycle) {
        if (capacityPerCycle <= 0) {
            throw new IllegalArgumentException("Capacity per cycle must be greater than zero.");
        }
        this.capacityPerCycle = capacityPerCycle;
    }

    public void assignOperator(Staff operator) {
        if (operator == null) {
            throw new IllegalArgumentException("Operator cannot be null.");
        }
        this.operator = operator;

        System.out.println("Operator " + operator.getName() + " assigned to attraction " + name + ".");
    }

    public void removeOperator() {
        if (operator == null) {
            System.out.println("No operator is currently assigned to attraction " + name + ".");
            return;
        }
        System.out.println("Operator " + operator.getName() + " removed from attraction " + name + ".");
        this.operator = null;
    }

    protected void incrementCycleCount() {
        cycleCount++;
    }

    public abstract void runCycle();

    @Override
    public String toString() {
        String operatorName = (operator != null) ? operator.getName() : "None";
        return "Attraction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacityPerCycle=" + capacityPerCycle +
                ", operator=" + (operator != null ? operator.getName() : "None") +
                ", cycleCount=" + cycleCount +
                '}';
    }
}