import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Abstract parent class for all theme park attractions.
 
public abstract class Attraction implements Runnable {

    private String id;
    private String name;
    private int capacityPerCycle;
    private Staff operator;

    protected Queue<Visitor> waitingLine;
    protected List<Visitor> visitHistory;

    private int cycleCount;
    private ParkWideCounter parkWideCounter;

//    Creates a new attraction.
  
    public Attraction(String id, String name, int capacityPerCycle) {

        setId(id);
        setName(name);
        setCapacityPerCycle(capacityPerCycle);

        this.operator = null;
        this.waitingLine = new LinkedList<>();
        this.visitHistory = new ArrayList<>();
        this.cycleCount = 0;
        this.parkWideCounter = null;
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

    // Sets the attraction ID.
  
    public void setId(String id) {

        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Attraction ID cannot be null or empty."
            );
        }

        this.id = id;
    }

//  Sets the attraction name.
    
    public void setName(String name) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Attraction name cannot be null or empty."
            );
        }

        this.name = name;
    }

    // Sets the maximum number of visitors that can be served in one cycle.
   
    public void setCapacityPerCycle(int capacityPerCycle) {

        if (capacityPerCycle <= 0) {
            throw new IllegalArgumentException(
                    "Capacity per cycle must be greater than zero."
            );
        }

        this.capacityPerCycle = capacityPerCycle;
    }

    // Assigns a staff member as the attraction operator.
   
    public void assignOperator(Staff operator) {

        if (operator == null) {
            System.out.println(
                    "Cannot assign a null operator to " +
                    name + "."
            );
            return;
        }

        this.operator = operator;

        System.out.println(
                operator.getName() +
                " has been assigned to operate " +
                name + "."
        );
    }

    // Removes the current operator.
    
    public void removeOperator() {

        if (operator == null) {

            System.out.println(
                    name + " currently has no operator."
            );

            return;
        }

        System.out.println(
                operator.getName() +
                " has been removed as operator of " +
                name + "."
        );

        operator = null;
    }

//    Adds a visitor to the end of the waiting line.
 
    public void addVisitorToWaitingLine(Visitor visitor) {

        if (visitor == null) {

            System.out.println(
                    "Cannot add a null visitor to " +
                    name + " waiting line."
            );

            return;
        }

        waitingLine.offer(visitor);

        System.out.println(
                visitor.getName() +
                " joined the waiting line for " +
                name + "."
        );
    }

    // Removes and returns the visitor at the front of the waiting line.
  
    public Visitor removeNextVisitor() {

        if (waitingLine.isEmpty()) {

            System.out.println(
                    "The waiting line for " +
                    name + " is empty."
            );

            return null;
        }

        Visitor visitor = waitingLine.poll();

        System.out.println(
                visitor.getName() +
                " was removed from the waiting line for " +
                name + "."
        );

        return visitor;
    }

    // Displays visitors in FIFO waiting order.
  
    public void displayWaitingLine() {

        System.out.println(
                "Waiting line for " + name + ":"
        );

        if (waitingLine.isEmpty()) {

            System.out.println(
                    "No visitors are waiting."
            );

            return;
        }

        for (Visitor visitor : waitingLine) {
            System.out.println(visitor);
        }
    }

    // Records a visitor in the attraction history.
    public void recordVisitorInHistory(Visitor visitor) {

        if (visitor == null) {

            System.out.println(
                    "Cannot record a null visitor in the history."
            );

            return;
        }

        visitHistory.add(visitor);

        System.out.println(
                visitor.getName() +
                " was recorded in the history for " +
                name + "."
        );
    }

    // Checks whether a particular visitor appears in the attraction history.
   
    public boolean isVisitorInHistory(Visitor visitor) {

        if (visitor == null) {

            System.out.println(
                    "Cannot search history for a null visitor."
            );

            return false;
        }

        boolean found =
                visitHistory.contains(visitor);

        System.out.println(
                visitor.getName() +
                (found
                        ? " appears in "
                        : " does not appear in ") +
                name +
                " history."
        );

        return found;
    }

    // Returns the number of recorded visits.
   
    public int getHistoryCount() {

        System.out.println(
                name +
                " has served " +
                visitHistory.size() +
                " visit(s)."
        );

        return visitHistory.size();
    }

    // Displays visit history in serving order.
    
    public void displayHistory() {

        System.out.println(
                "Visit history for " + name + ":"
        );

        if (visitHistory.isEmpty()) {

            System.out.println(
                    "No visitors have been served."
            );

            return;
        }

        for (Visitor visitor : visitHistory) {
            System.out.println(visitor);
        }
    }

    // Displays history ordered by visitor age.
    public void displayHistoryByAge() {

        List<Visitor> sortedHistory =
                new ArrayList<>(visitHistory);

        sortedHistory.sort(null);

        System.out.println(
                "Visit history for " +
                name +
                " sorted by age:"
        );

        for (Visitor visitor : sortedHistory) {
            System.out.println(visitor);
        }
    }

    // Displays history ordered first by visitor name and then by ticket type.
    
    public void displayHistoryByNameAndTicketType() {

        List<Visitor> sortedHistory =
                new ArrayList<>(visitHistory);

        sortedHistory.sort(
                new VisitorNameTicketComparator()
        );

        System.out.println(
                "Visit history for " +
                name +
                " sorted by name and ticket type:"
        );

        for (Visitor visitor : sortedHistory) {
            System.out.println(visitor);
        }
    }

    // Returns a copy of the waiting line.
   
    public Queue<Visitor> getWaitingLine() {

        return new LinkedList<>(waitingLine);
    }

    // Returns a copy of the visit history.
    
    public List<Visitor> getVisitHistory() {

        return new ArrayList<>(visitHistory);
    }

    // Increases the completed cycle count.
    
    protected void incrementCycleCount() {

        cycleCount++;
    }

    // Assigns the shared park-wide visitor counter.
    
    public void setParkWideCounter(
            ParkWideCounter parkWideCounter
    ) {

        this.parkWideCounter = parkWideCounter;
    }

 
    //  Returns the shared park-wide counter.

    protected ParkWideCounter getParkWideCounter() {

        return parkWideCounter;
    }

  
    public abstract void runCycle();

    
    //  Allows the attraction to execute as a Runnable task.
     
    @Override
    public void run() {

        runCycle();
    }

    // Returns attraction information in readable form.
     
    @Override
    public String toString() {

        String operatorName =
                operator == null
                        ? "None"
                        : operator.getName();

        return "Attraction{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", capacityPerCycle=" +
                capacityPerCycle +
                ", operator='" +
                operatorName + '\'' +
                ", cycleCount=" +
                cycleCount +
                '}';
    }
}