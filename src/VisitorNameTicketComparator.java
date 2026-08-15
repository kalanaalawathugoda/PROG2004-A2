import java.util.Comparator;

public class VisitorNameTicketComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor first, Visitor second) {
        // Compare by name first
        int nameComparison = first.getName().compareTo(second.getName());
        if (nameComparison != 0) {
            return nameComparison;
        }
        // If names are the same, compare by ticket type
        return first.getTicketType().compareToIgnoreCase(second.getTicketType());
    }
}