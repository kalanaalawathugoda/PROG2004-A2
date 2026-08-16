import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class ThemePark {

    private Map<String, Attraction> attractions;


    public ThemePark() {
        attractions = new HashMap<>();
    }


    public void registerAttraction(Attraction attraction) {

        if (attraction == null) {
            System.out.println(
                    "Cannot register a null attraction."
            );
            return;
        }

        String id = attraction.getId();

        if (attractions.containsKey(id)) {
            System.out.println(
                    "Attraction with ID " +
                    id +
                    " is already registered."
            );
            return;
        }

        attractions.put(id, attraction);

        System.out.println(
                attraction.getName() +
                " was registered with ID " +
                id + "."
        );
    }


    public Attraction getAttractionById(String id) {

        Attraction attraction = attractions.get(id);

        if (attraction == null) {
            System.out.println(
                    "No attraction found with ID " +
                    id + "."
            );
        } else {
            System.out.println(
                    "Found attraction: " +
                    attraction.getName()
            );
        }

        return attraction;
    }


    public void reportVisitorCounts() {

        System.out.println(
                "Visitor counts for all attractions:"
        );

        if (attractions.isEmpty()) {
            System.out.println(
                    "No attractions are registered."
            );
            return;
        }

        for (Attraction attraction : attractions.values()) {

            int count =
                    attraction.getVisitHistory().size();

            System.out.println(
                    attraction.getName() +
                    " served " +
                    count +
                    " seat(s)."
            );
        }
    }


    public int getDistinctVisitorCount() {

        Set<Visitor> distinctVisitors =
                new HashSet<>();

        for (Attraction attraction : attractions.values()) {

            distinctVisitors.addAll(
                    attraction.getVisitHistory()
            );
        }

        int count = distinctVisitors.size();

        System.out.println(
                "Distinct visitors served across the park: " +
                count
        );

        return count;
    }


    public int getAttractionCount() {
        return attractions.size();
    }

    public void displayAttractions() {

        System.out.println(
                "Registered attractions:"
        );

        if (attractions.isEmpty()) {
            System.out.println(
                    "No attractions are registered."
            );
            return;
        }

        for (Attraction attraction : attractions.values()) {
            System.out.println(attraction);
        }
    }
}