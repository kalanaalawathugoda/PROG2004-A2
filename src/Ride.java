public class Ride extends Attraction implements Inspectable{
    private boolean closed;
    private String lastInspectionResult;

    public Ride(String id, String name, int capacityPerCycle, Staff operator) {
        super(id, name, capacityPerCycle, operator);
        this.closed = false;
        this.lastInspectionResult = "No inspections yet.";
    }

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

    @Override
    public String getInspectionName() {
        return getName();
    }

    @Override
    public void startInspection() {
        closed = true;
        System.out.println(getName() + " is now closed for inspection.");
    }

    @Override
    public void recordInspection(String result) {
        if(result == null || result.trim().isEmpty()){
            lastInspectionResult = "No results supplied";
        } else {
            lastInspectionResult = result;
        }

        System.out.println(getName() + " inspection result recorded: " + lastInspectionResult);
    }

    @Override
    public void finishInspection() {
        closed = false;
        System.out.println(getName() + " is now open after inspection.");
    }

    @Override
    public boolean isClosed() {
        return closed;
    }

    @Override
    public String getInspectionResult() {
        return lastInspectionResult;
    }

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