import java.time.*;
import java.time.format.DateTimeFormatter;


import java.util.Timer;
import java.util.TimerTask;

public class Examples11Timer {
    public static void main(String[] args) {

        //date and time

        Instant inst = Instant.now();
        System.out.println(inst);

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("Now: " + ldt);
        LocalDateTime ldt2 = ldt.plusDays(30);
        System.out.println("Now + 30 days: " + ldt2);

        LocalDate xmas = LocalDate.parse("24.12.2022", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        System.out.println("Christmas: " + xmas);

        System.out.println("Duration between Now and +30 days: " + Duration.between(ldt, ldt2));
        System.out.println("Duration between Now and +30 days in seconds: " + Duration.between(ldt, ldt2).getSeconds());

        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println("Now: " + zdt);
        ZonedDateTime zdt2 = zdt.withZoneSameInstant(ZoneId.of("Europe/London"));
        System.out.println("Now in London: " + zdt2);

        System.out.println("Duration between Now and Now in London: " + Duration.between(zdt, zdt2));

        System.out.println("Zones:");
        ZoneId.getAvailableZoneIds().forEach(System.out::println);



        // timing tasks

        Timer timer = new Timer();

        // Define a TimerTask
        TimerTask task = new TimerTask() {
            int count = 0;

            @Override
            public void run() {
                count++;
                System.out.println("Task is running. Count: " + count);

                // Specify the number of times the task should run
                if (count == 5) {
                    System.out.println("Task completed. Stopping the timer.");
                    timer.cancel(); // Terminate the timer
                }
            }
        };

        // Schedule the TimerTask to run every 1 second (1000 milliseconds)
        timer.schedule(task, 0, 1000);
    }
}
