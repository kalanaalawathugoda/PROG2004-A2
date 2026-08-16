public class ParkWideCounter {
    private int totalVisitorsServed;

    public ParkWideCounter() {
        this.totalVisitorsServed = 0;
    }

    public synchronized void addVisitors(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be negative.");
        }
        totalVisitorsServed += amount;

        System.out.println("Park-wide total updated to " +
                totalVisitorsServed + ".");

    }

    public synchronized int getTotalVisitorsServed() {
        return totalVisitorsServed;
    }

    public synchronized void reset() {
        totalVisitorsServed = 0;
        System.out.println("Park-wide visitor counter reset to 0.");
    }
}
