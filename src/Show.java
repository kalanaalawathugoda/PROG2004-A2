public class Show extends Attraction {

    public Show (String id, String name, int capacityPerCycle) {
        super(id, name, capacityPerCycle);
    }

    @Override
    public void runCycle() {
        if(getOperator() == null){
            System.out.println(
                getName() + " cannot run cycle without an operator."
            );
            return;
        }

        System.out.println(
            getName() + " is running a show cycle.");

            int visitorsServed = 0;

            while(visitorsServed < getCapacityPerCycle() && !waitingLine.isEmpty()){
                Visitor visitor = waitingLine.poll();
                visitHistory.add(visitor);

                System.out.println(
                    visitor.getName() + " has enjoyed the show on " + getName()
                );
                visitorsServed++;
            }
            incrementCycleCount();

            if(getParkWideCounter() != null){
                getParkWideCounter().addVisitors(visitorsServed);
                
            }

            if(visitorsServed == 0){
                System.out.println(
                    getName() +
                    " completed cycle " +
                    getCycleCount() +
                    " with an empty audience."
            );
            } else {
            System.out.println(
                    getName() +
                    " completed cycle " +
                    getCycleCount() +
                    " and served " +
                    visitorsServed +
                    " visitor(s)."
            );
        }
        }

        @Override
        public String toString(){
            return "Show ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Capacity per Cycle: " + getCapacityPerCycle() + "\n" +
                "Operator: " + (getOperator() != null ? getOperator().getName() : "None") + "\n" +
                "Total Cycles Run: " + getCycleCount();
        }
}