public class AssignmentTwo {
    public static void main(String[] args) {
        // Part 1 - Modelling the park's people
        System.out.println("\n===== PART 1 - PEOPLE =====");

        Staff staff1 = new Staff(
                "1001",
                "David",
                32,
                "Ride Operator");

        Visitor visitor1 = new Visitor(
                "2001",
                "Emma",
                21,
                "Standard");

        Visitor visitor2 = new Visitor(
                "2002",
                "John",
                17,
                "Premium");

        Visitor visitor3 = new Visitor(
                "2003",
                "Sarah",
                28,
                "VIP");

        System.out.println(staff1);
        System.out.println(visitor1);
        System.out.println(visitor2);
        System.out.println(visitor3);

        java.util.List<Visitor> visitors = new java.util.ArrayList<>();

        visitors.add(visitor1);
        visitors.add(visitor2);
        visitors.add(visitor3);

        java.util.Collections.sort(visitors);

        System.out.println("\nVisitors ordered by age:");

        for (Visitor visitor : visitors) {
            System.out.println(visitor);
        }

        // Part 2 - Modelling the park's attractions

        System.out.println("\n===== PART 2 - ATTRACTIONS =====");

        Staff operator1 = new Staff(
                "1002",
                "Michael",
                35,
                "Senior Operator");

        Ride ride1 = new Ride(
                "R001",
                "Thunder Coaster",
                3);

        Show show1 = new Show(
                "S001",
                "Magic Show",
                5);

        Toilet toilet1 = new Toilet(
                "T001",
                "Main Toilet Block");

        System.out.println(ride1);
        System.out.println(show1);
        System.out.println(toilet1);

        System.out.println("\nAssigning operator:");

        ride1.assignOperator(operator1);

        System.out.println(ride1);

        System.out.println("\nRemoving operator:");

        ride1.removeOperator();

        System.out.println(ride1);

        System.out.println("\nReassigning operator:");

        ride1.assignOperator(operator1);

        System.out.println("\nInspecting the ride:");

        System.out.println(
                "Ride closed before inspection: " +
                        ride1.isClosed());

        operator1.performInspection(
                ride1,
                "Ride passed technical inspection");

        System.out.println(
                "Ride closed after inspection: " +
                        ride1.isClosed());

        System.out.println(
                "Last ride inspection result: " +
                        ride1.getLastInspectionResult());

        System.out.println("\nInspecting the toilet:");

        System.out.println(
                "Toilet closed before inspection: " +
                        toilet1.isClosed());

        operator1.performInspection(
                toilet1,
                "Toilet passed hygiene inspection");

        System.out.println(
                "Toilet closed after inspection: " +
                        toilet1.isClosed());

        System.out.println(
                "Last toilet inspection result: " +
                        toilet1.getLastInspectionResult());

        // Part 3 - The waiting line

        System.out.println("\n===== PART 3 - WAITING LINE =====");

        Ride queueRide = new Ride(
                "R002",
                "Sky Drop",
                2);

        queueRide.assignOperator(operator1);

        Visitor queueVisitor1 = new Visitor(
                "2101",
                "Amelia",
                24,
                "Standard");

        Visitor queueVisitor2 = new Visitor(
                "2102",
                "Noah",
                19,
                "Premium");

        Visitor queueVisitor3 = new Visitor(
                "2103",
                "Olivia",
                31,
                "VIP");

        queueRide.addVisitorToWaitingLine(queueVisitor1);
        queueRide.addVisitorToWaitingLine(queueVisitor2);
        queueRide.addVisitorToWaitingLine(queueVisitor3);

        System.out.println("\nWaiting line before removing next visitor:");

        queueRide.displayWaitingLine();

        Visitor nextVisitor = queueRide.removeNextVisitor();

        System.out.println(
                "\nNext visitor removed: " +
                        nextVisitor);

        System.out.println("\nWaiting line after removing next visitor:");

        queueRide.displayWaitingLine();

        // Part 4 - The visit history

        System.out.println("\n===== PART 4 - VISIT HISTORY =====");

        Ride historyRide = new Ride(
                "R003",
                "River Rapids",
                4);

        Visitor historyVisitor1 = new Visitor(
                "2201",
                "Liam",
                26,
                "Standard");

        Visitor historyVisitor2 = new Visitor(
                "2202",
                "Ava",
                18,
                "VIP");

        Visitor historyVisitor3 = new Visitor(
                "2203",
                "Liam",
                34,
                "Premium");

        Visitor historyVisitor4 = new Visitor(
                "2204",
                "Sophia",
                22,
                "Standard");

        historyRide.recordVisitorInHistory(historyVisitor1);
        historyRide.recordVisitorInHistory(historyVisitor2);
        historyRide.recordVisitorInHistory(historyVisitor3);
        historyRide.recordVisitorInHistory(historyVisitor4);

        System.out.println("\nChecking visitor history:");

        historyRide.isVisitorInHistory(historyVisitor2);

        Visitor notRecordedVisitor = new Visitor(
                "2299",
                "Ethan",
                29,
                "Standard");

        historyRide.isVisitorInHistory(notRecordedVisitor);

        System.out.println("\nHistory count:");

        historyRide.getHistoryCount();

        System.out.println("\nOriginal visit history:");

        historyRide.displayHistory();

        System.out.println("\nVisit history sorted by age:");

        historyRide.displayHistoryByAge();

        System.out.println(
                "\nVisit history sorted by name and ticket type:");

        historyRide.displayHistoryByNameAndTicketType();

        // Part 5 - Operating an attraction

        System.out.println("\n===== PART 5 - OPERATING AN ATTRACTION =====");

        // Create staff member for Part 5
        Staff cycleOperator = new Staff(
                "1003",
                "Daniel",
                40,
                "Attraction Operator");

        // --------------------
        // Ride demonstration
        // --------------------

        Ride operatingRide = new Ride(
                "R004",
                "Dragon Flight",
                2);

        Visitor rideVisitor1 = new Visitor(
                "2301",
                "Mia",
                20,
                "Standard");

        Visitor rideVisitor2 = new Visitor(
                "2302",
                "Lucas",
                27,
                "Premium");

        Visitor rideVisitor3 = new Visitor(
                "2303",
                "Grace",
                23,
                "VIP");

        System.out.println(
                "\nTrying to run ride without an operator:");

        operatingRide.addVisitorToWaitingLine(rideVisitor1);

        operatingRide.runCycle();

        System.out.println(
                "\nAssigning operator and adding more visitors:");

        operatingRide.assignOperator(cycleOperator);

        operatingRide.addVisitorToWaitingLine(rideVisitor2);
        operatingRide.addVisitorToWaitingLine(rideVisitor3);

        System.out.println("\nBefore ride cycle:");

        operatingRide.displayWaitingLine();

        System.out.println(
                "Cycle count: " +
                        operatingRide.getCycleCount());

        operatingRide.runCycle();

        System.out.println("\nAfter ride cycle:");

        operatingRide.displayWaitingLine();

        operatingRide.displayHistory();

        System.out.println(
                "Cycle count: " +
                        operatingRide.getCycleCount());

        // --------------------
        // Empty queue test
        // --------------------

        System.out.println(
                "\nRunning ride until queue becomes empty:");

        operatingRide.runCycle();

        System.out.println(
                "\nTrying to run ride with empty queue:");

        operatingRide.runCycle();

        // --------------------
        // Inspection test
        // --------------------

        operatingRide.addVisitorToWaitingLine(
                new Visitor(
                        "2304",
                        "Henry",
                        30,
                        "Standard"));

        System.out.println(
                "\nTrying to run ride while closed for inspection:");

        operatingRide.startInspection();

        operatingRide.runCycle();

        operatingRide.finishInspection();

        System.out.println(
                "\nRunning ride after inspection:");

        operatingRide.runCycle();

        // --------------------
        // Show demonstration
        // --------------------

        System.out.println(
                "\n----- SHOW DEMONSTRATION -----");

        Show operatingShow = new Show(
                "S002",
                "Evening Dance Show",
                5);

        System.out.println(
                "\nTrying to run show without an operator:");

        operatingShow.runCycle();

        operatingShow.assignOperator(cycleOperator);

        System.out.println(
                "\nRunning show with an empty audience:");

        operatingShow.runCycle();

        System.out.println(
                "Show cycle count: " +
                        operatingShow.getCycleCount());

        Visitor showVisitor1 = new Visitor(
                "2401",
                "Ella",
                25,
                "Standard");

        Visitor showVisitor2 = new Visitor(
                "2402",
                "James",
                32,
                "VIP");

        operatingShow.addVisitorToWaitingLine(
                showVisitor1);

        operatingShow.addVisitorToWaitingLine(
                showVisitor2);

        System.out.println(
                "\nRunning show with visitors:");

        operatingShow.runCycle();

        operatingShow.displayHistory();

        System.out.println(
                "Show cycle count: " +
                        operatingShow.getCycleCount());

        // Part 6 - Managing the park

        System.out.println("\n===== PART 6 - MANAGING THE PARK =====");

        ThemePark park = new ThemePark();

        Ride parkRide = new Ride(
                "R005",
                "Ocean Racer",
                3);

        Show parkShow = new Show(
                "S003",
                "Comedy Show",
                4);

        Ride parkRide2 = new Ride(
                "R006",
                "Jungle Adventure",
                2);

        park.registerAttraction(parkRide);
        park.registerAttraction(parkShow);
        park.registerAttraction(parkRide2);

        System.out.println("\nRegistered attractions:");

        park.displayAttractions();

        System.out.println("\nLooking up attraction R005:");

        Attraction foundAttraction = park.getAttractionById("R005");

        System.out.println(
                "Lookup result: " +
                        foundAttraction);

        Visitor parkVisitor1 = new Visitor(
                "2501",
                "Oliver",
                24,
                "Standard");

        Visitor parkVisitor2 = new Visitor(
                "2502",
                "Charlotte",
                29,
                "VIP");

        Visitor parkVisitor3 = new Visitor(
                "2503",
                "William",
                19,
                "Premium");

        // Same visitor appears in more than one attraction.
        parkRide.recordVisitorInHistory(
                parkVisitor1);

        parkRide.recordVisitorInHistory(
                parkVisitor2);

        parkShow.recordVisitorInHistory(
                parkVisitor1);

        parkShow.recordVisitorInHistory(
                parkVisitor3);

        parkRide2.recordVisitorInHistory(
                parkVisitor2);

        System.out.println(
                "\nVisitor counts for individual attractions:");

        park.reportVisitorCounts();

        System.out.println(
                "\nDistinct visitor count across the park:");

        park.getDistinctVisitorCount();

        // Part 7 - Backing up and restoring the park

        System.out.println("\n===== PART 7 - BACKUP AND RESTORE =====");

        ThemePark backupPark = new ThemePark();

        Staff backupOperator = new Staff(
                "1101",
                "Sophie",
                33,
                "Ride Operator");

        Ride backupRide = new Ride(
                "R007",
                "Mountain Express",
                3);

        Show backupShow = new Show(
                "S004",
                "Music Show",
                5);

        backupRide.assignOperator(backupOperator);
        backupShow.assignOperator(backupOperator);

        Visitor backupVisitor1 = new Visitor(
                "2601",
                "Jack",
                21,
                "Standard");

        Visitor backupVisitor2 = new Visitor(
                "2602",
                "Emily",
                27,
                "VIP");

        Visitor backupVisitor3 = new Visitor(
                "2603",
                "Leo",
                18,
                "Premium");

        Visitor backupVisitor4 = new Visitor(
                "2604",
                "Chloe",
                30,
                "Standard");

        // Add visitors to waiting lines
        backupRide.addVisitorToWaitingLine(
                backupVisitor1);

        backupRide.addVisitorToWaitingLine(
                backupVisitor2);

        backupShow.addVisitorToWaitingLine(
                backupVisitor3);

        // Add visitors to histories
        backupRide.recordVisitorInHistory(
                backupVisitor3);

        backupShow.recordVisitorInHistory(
                backupVisitor4);

        // Register attractions
        backupPark.registerAttraction(
                backupRide);

        backupPark.registerAttraction(
                backupShow);

        System.out.println(
                "\nOriginal park before backup:");

        backupPark.displayAttractions();

        System.out.println(
                "\nOriginal ride waiting line:");

        backupRide.displayWaitingLine();

        System.out.println(
                "\nOriginal ride history:");

        backupRide.displayHistory();

        System.out.println(
                "\nSaving park...");

        String backupFile = "park_backup.txt";

        backupPark.saveToFile(
                backupFile);

        // ------------------------------------
        // Restore into a new ThemePark object
        // ------------------------------------

        System.out.println(
                "\nRestoring into a new park...");

        ThemePark restoredPark = new ThemePark();

        restoredPark.loadFromFile(
                backupFile);

        System.out.println(
                "\nRestored attractions:");

        restoredPark.displayAttractions();

        Attraction restoredRide = restoredPark.getAttractionById(
                "R007");

        if (restoredRide != null) {

            System.out.println(
                    "\nRestored ride operator:");

            System.out.println(
                    restoredRide.getOperator());

            System.out.println(
                    "\nRestored waiting line:");

            restoredRide.displayWaitingLine();

            System.out.println(
                    "\nRestored history:");

            restoredRide.displayHistory();
        }

        // ------------------------------------
        // Missing-file test
        // ------------------------------------

        System.out.println(
                "\nTesting missing backup file:");

        ThemePark missingFilePark = new ThemePark();

        missingFilePark.loadFromFile(
                "file_that_does_not_exist.txt");

        // ------------------------------------
        // Corrupted-file test
        // ------------------------------------

        System.out.println(
                "\nTesting corrupted backup file:");

        try (
                java.io.BufferedWriter corruptedWriter = new java.io.BufferedWriter(
                        new java.io.FileWriter(
                                "corrupted_backup.txt"))) {

            corruptedWriter.write(
                    "ATTRACTION|RIDE|R900|Broken Ride|3");

            corruptedWriter.newLine();

            corruptedWriter.write(
                    "THIS|IS|NOT|A|VALID|RECORD");

            corruptedWriter.newLine();

            corruptedWriter.write(
                    "QUEUE|9999|Test Visitor|notANumber|Standard");

            corruptedWriter.newLine();

            corruptedWriter.write(
                    "END");

            corruptedWriter.newLine();

        } catch (java.io.IOException exception) {

            System.out.println(
                    "Could not create corrupted test file: " +
                            exception.getMessage());
        }

        ThemePark corruptedPark = new ThemePark();

        corruptedPark.loadFromFile(
                "corrupted_backup.txt");

        System.out.println(
                "\nProgram continued after corrupted file test.");

        // Part 8 - Running the park

        System.out.println("\n===== PART 8 - RUNNING THE PARK CONCURRENTLY =====");

        ParkWideCounter sharedCounter = new ParkWideCounter();

        Staff concurrentOperator = new Staff(
                "1201",
                "Alex",
                36,
                "Concurrent Attraction Operator");

        Ride concurrentRide1 = new Ride(
                "R008",
                "Speed Racer",
                3);

        Ride concurrentRide2 = new Ride(
                "R009",
                "Wild River",
                2);

        Show concurrentShow = new Show(
                "S005",
                "Night Performance",
                4);

        concurrentRide1.assignOperator(concurrentOperator);
        concurrentRide2.assignOperator(concurrentOperator);
        concurrentShow.assignOperator(concurrentOperator);

        concurrentRide1.setParkWideCounter(sharedCounter);
        concurrentRide2.setParkWideCounter(sharedCounter);
        concurrentShow.setParkWideCounter(sharedCounter);

        concurrentRide1.addVisitorToWaitingLine(
                new Visitor("2701", "Alice", 20, "Standard"));

        concurrentRide1.addVisitorToWaitingLine(
                new Visitor("2702", "Ben", 23, "VIP"));

        concurrentRide1.addVisitorToWaitingLine(
                new Visitor("2703", "Clara", 28, "Premium"));

        concurrentRide2.addVisitorToWaitingLine(
                new Visitor("2704", "Daniel", 31, "Standard"));

        concurrentRide2.addVisitorToWaitingLine(
                new Visitor("2705", "Eva", 25, "VIP"));

        concurrentShow.addVisitorToWaitingLine(
                new Visitor("2706", "Frank", 22, "Standard"));

        concurrentShow.addVisitorToWaitingLine(
                new Visitor("2707", "Georgia", 26, "Premium"));

        java.util.concurrent.ExecutorService executor = java.util.concurrent.Executors.newFixedThreadPool(3);

        System.out.println("\nStarting attractions concurrently...");

        executor.submit(concurrentRide1);
        executor.submit(concurrentRide2);
        executor.submit(concurrentShow);

        executor.shutdown();

        try {

            boolean finished = executor.awaitTermination(
                    1,
                    java.util.concurrent.TimeUnit.MINUTES);

            if (finished) {
                System.out.println(
                        "\nAll attractions finished running.");
            } else {
                System.out.println(
                        "\nSome attractions did not finish in time.");
            }

        } catch (InterruptedException exception) {

            System.out.println(
                    "Concurrent execution was interrupted.");

            Thread.currentThread().interrupt();
        }

        System.out.println(
                "\nFinal park-wide visitors served: " +
                        sharedCounter.getTotalVisitorsServed());
    }

}