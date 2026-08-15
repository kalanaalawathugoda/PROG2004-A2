// Represents a ride in the theme park.

public class Ride extends Attraction implements Inspectable{
    private boolean closed;
    private String lastInspectionResult;

    // Creates a new ride

    public Ride(String id, String name, int capacityPerCycle, Staff operator) {
        super(id, name, capacityPerCycle, operator);
        this.closed = false;
        this.lastInspectionResult = "No inspections yet.";
    }

    // Runs one ride cycle.

    @Override
    public void runCycle(){
        if(getOperator() == null){
            System.out.println(getName() +"Cannot run cycle without an operator.");
            return;

        }

        if(closed){
            System.out.println(getName() + " is closed and cannot run a cycle.");
            return;
        }

        if(waitingLine.isEmpty()){
            System.out.println(getName() + " has no visitors to run a cycle.");
            return;
        }

        System.out.println(getName() + " is running a cycle ");
        int visitorsServed = 0;

        while(visitorsServed < getCapacityPerCycle() && !waitingLine.isEmpty()){
            Visitor visitor = waitingLine.poll();
            visitHistory.add(visitor);

            System.out.println(
                visitor.getName() + " has enjoyed the ride on " + getName()
            );
            visitorsServed++;
        }
        incrementCycleCount();

        System.out.println(
            getName() + " has completed a cycle. Total cycles run: " + getCycleCount() + "visitor(s)" + visitorsServed

        );
    }

    // Returns the name used for inspection messages.

    @Override
    public String getInspectionName() {
        return getName();
    }

    // Starts an inspection and closes the ride.

    @Override
    public void startInspection() {
        closed = true;
        System.out.println(getName() + " is now closed for inspection.");
    }

    // Records the result of an inspection

    @Override
    public void recordInspection(String result) {
        if(result == null || result.trim().isEmpty()){
            lastInspectionResult = "No results supplied";
        } else {
            lastInspectionResult = result;
        }

        System.out.println(getName() + " inspection result recorded: " + lastInspectionResult);
    }

    // Finishes the inspection and reopens the ride.

    @Override
    public void finishInspection() {
        closed = false;
        System.out.println(getName() + " is now open after inspection.");
    }

    // Reports whether the ride is closed.

    @Override
    public boolean isClosed() {
        return closed;
    }

    // Returns the most recent inspection result.

    @Override
    public String getInspectionResult() {
        return lastInspectionResult;
    }

    // Returns ride information.

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", capacityPerCycle=" + getCapacityPerCycle() +
                ", operator=" + (getOperator() != null ? getOperator().getName() : "None") +
                ", cycleCount=" + getCycleCount() +
                ", closed=" + closed +
                ", lastInspectionResult='" + lastInspectionResult + '\'' +
                '}';
    }

}