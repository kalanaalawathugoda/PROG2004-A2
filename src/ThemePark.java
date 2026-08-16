import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Represents the whole theme park.
 *
 * The ThemePark class manages all registered attractions,
 * provides direct attraction lookup, reports visitor counts,
 * calculates distinct visitors, and supports saving and
 * restoring park data.
 */
public class ThemePark {

    private Map<String, Attraction> attractions;

    /**
     * Creates an empty theme park.
     */
    public ThemePark() {
        attractions = new HashMap<>();
    }

    /**
     * Registers an attraction in the theme park.
     *
     * Attractions are stored using their unique ID as the key.
     *
     * @param attraction attraction to register
     */
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

    /**
     * Retrieves an attraction directly using its ID.
     *
     * @param id attraction identifier
     * @return attraction if found, otherwise null
     */
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

    /**
     * Returns the number of registered attractions.
     *
     * @return number of attractions
     */
    public int getAttractionCount() {
        return attractions.size();
    }

    /**
     * Displays all registered attractions.
     */
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

    /**
     * Reports how many seats have been served
     * by each registered attraction.
     *
     * The same visitor can count more than once
     * if they have been served multiple times.
     */
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

    /**
     * Calculates the number of distinct visitors
     * served across the whole park.
     *
     * A HashSet is used so that the same visitor
     * is only counted once.
     *
     * @return number of unique visitors
     */
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

    /**
     * Saves the theme park's attraction data to a text file.
     *
     * The backup includes:
     * - attraction type
     * - attraction details
     * - operator details
     * - visitors waiting in the queue
     * - visitors recorded in history
     *
     * @param fileName name of backup file
     */
    public void saveToFile(String fileName) {

        try (BufferedWriter writer =
                     new BufferedWriter(
                             new FileWriter(fileName)
                     )) {

            for (Attraction attraction :
                    attractions.values()) {

                String type;

                if (attraction instanceof Ride) {
                    type = "RIDE";

                } else if (attraction instanceof Show) {
                    type = "SHOW";

                } else {
                    continue;
                }

                /*
                 * Save attraction information.
                 */
                writer.write(
                        "ATTRACTION|" +
                        type + "|" +
                        attraction.getId() + "|" +
                        attraction.getName() + "|" +
                        attraction.getCapacityPerCycle()
                );

                writer.newLine();

                /*
                 * Save the attraction operator.
                 */
                Staff operator =
                        attraction.getOperator();

                if (operator != null) {

                    writer.write(
                            "OPERATOR|" +
                            operator.getId() + "|" +
                            operator.getName() + "|" +
                            operator.getAge() + "|" +
                            operator.getRole()
                    );

                    writer.newLine();
                }

                /*
                 * Save visitors currently waiting.
                 */
                for (Visitor visitor :
                        attraction.getWaitingLine()) {

                    writer.write(
                            "QUEUE|" +
                            visitor.getId() + "|" +
                            visitor.getName() + "|" +
                            visitor.getAge() + "|" +
                            visitor.getTicketType()
                    );

                    writer.newLine();
                }

                /*
                 * Save visitors already served.
                 */
                for (Visitor visitor :
                        attraction.getVisitHistory()) {

                    writer.write(
                            "HISTORY|" +
                            visitor.getId() + "|" +
                            visitor.getName() + "|" +
                            visitor.getAge() + "|" +
                            visitor.getTicketType()
                    );

                    writer.newLine();
                }

                /*
                 * Marks the end of one attraction.
                 */
                writer.write("END");
                writer.newLine();
            }

            System.out.println(
                    "Park data successfully saved to " +
                    fileName + "."
            );

        } catch (IOException exception) {

            System.out.println(
                    "Unable to save park data: " +
                    exception.getMessage()
            );
        }
    }

    /**
     * Restores theme park data from a text backup file.
     *
     * Malformed records are skipped rather than
     * stopping the whole restore operation.
     *
     * @param fileName backup file to restore
     */
    public void loadFromFile(String fileName) {

        attractions.clear();

        Attraction currentAttraction = null;

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(fileName)
                     )) {

            String line;

            while ((line = reader.readLine()) != null) {

                try {

                    if (line.trim().isEmpty()) {
                        continue;
                    }

                    String[] values =
                            line.split("\\|");

                    /*
                     * Restore an attraction.
                     */
                    if (values[0].equals("ATTRACTION")) {

                        if (values.length != 5) {
                            throw new IllegalArgumentException(
                                    "Invalid attraction record."
                            );
                        }

                        String type = values[1];
                        String id = values[2];
                        String name = values[3];

                        int capacity =
                                Integer.parseInt(
                                        values[4]
                                );

                        if (type.equals("RIDE")) {

                            currentAttraction =
                                    new Ride(
                                            id,
                                            name,
                                            capacity
                                    );

                        } else if (type.equals("SHOW")) {

                            currentAttraction =
                                    new Show(
                                            id,
                                            name,
                                            capacity
                                    );

                        } else {

                            throw new IllegalArgumentException(
                                    "Unknown attraction type."
                            );
                        }

                        registerAttraction(
                                currentAttraction
                        );
                    }

                    /*
                     * Restore attraction operator.
                     */
                    else if (values[0]
                            .equals("OPERATOR")) {

                        if (currentAttraction == null
                                || values.length != 5) {

                            throw new IllegalArgumentException(
                                    "Invalid operator record."
                            );
                        }

                        Staff operator =
                                new Staff(
                                        values[1],
                                        values[2],
                                        Integer.parseInt(
                                                values[3]
                                        ),
                                        values[4]
                                );

                        currentAttraction
                                .assignOperator(operator);
                    }

                    /*
                     * Restore a waiting visitor.
                     */
                    else if (values[0]
                            .equals("QUEUE")) {

                        if (currentAttraction == null
                                || values.length != 5) {

                            throw new IllegalArgumentException(
                                    "Invalid queue record."
                            );
                        }

                        Visitor visitor =
                                new Visitor(
                                        values[1],
                                        values[2],
                                        Integer.parseInt(
                                                values[3]
                                        ),
                                        values[4]
                                );

                        currentAttraction
                                .addVisitorToWaitingLine(
                                        visitor
                                );
                    }

                    /*
                     * Restore a visitor history record.
                     */
                    else if (values[0]
                            .equals("HISTORY")) {

                        if (currentAttraction == null
                                || values.length != 5) {

                            throw new IllegalArgumentException(
                                    "Invalid history record."
                            );
                        }

                        Visitor visitor =
                                new Visitor(
                                        values[1],
                                        values[2],
                                        Integer.parseInt(
                                                values[3]
                                        ),
                                        values[4]
                                );

                        currentAttraction
                                .recordVisitorInHistory(
                                        visitor
                                );
                    }

                    /*
                     * End of current attraction record.
                     */
                    else if (values[0]
                            .equals("END")) {

                        currentAttraction = null;
                    }

                    /*
                     * Unknown record type.
                     */
                    else {

                        throw new IllegalArgumentException(
                                "Unknown record type."
                        );
                    }

                } catch (
                        IllegalArgumentException exception
                ) {

                    System.out.println(
                            "Skipping malformed line: " +
                            line
                    );
                }
            }

            System.out.println(
                    "Park data successfully restored from " +
                    fileName + "."
            );

        } catch (FileNotFoundException exception) {

            System.out.println(
                    "Backup file not found: " +
                    fileName
            );

        } catch (IOException exception) {

            System.out.println(
                    "Unable to restore park data: " +
                    exception.getMessage()
            );
        }
    }
}