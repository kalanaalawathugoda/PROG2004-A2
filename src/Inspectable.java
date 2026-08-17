// Defines the behaviour required for objects that can be inspected by park staff.

public interface Inspectable {

    // Returns the name of the object being inspected.

    String getInspectionName();

    // Starts the inspection and temporarily closes the object.

    void startInspection();

    // Records the result of the inspection.

    void recordInspection(String result);

    // Finishes the inspection and reopens the object.

    void finishInspection();

    // Returns whether the object is currently closed.

    boolean isClosed();

    // Returns the most recent inspection result.
    String getLastInspectionResult();
}