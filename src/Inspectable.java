public interface Inspectable {

    String getInspectionName();
    void startInspection();
    void recordInspectionResult(String result);
    void finishInspection();

    boolean isClosed();

    String getInspectionResult();
}