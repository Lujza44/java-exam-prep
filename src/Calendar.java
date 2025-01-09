import java.time.*;

public class Calendar {
    public static void main(String[] args) throws NumberFormatException {

        if (args.length == 0) {
            printCurrMonth();
        } else if (args.length == 2) {
            int month = Integer.parseInt(args[0]);
            int year = Integer.parseInt(args[1]);
            printAnotherMonth(month, year);
        } else {
            System.out.println("Nespravne zadane parametre");
        }
    }

    public static void printAnotherMonth(int month, int year) {
        YearMonth yearMonth = YearMonth.of(year, month);
        printMonth(yearMonth);
    }

    public static void printCurrMonth() {
        YearMonth currYearMonth = YearMonth.now();
        printMonth(currYearMonth);

    }

    public static void printMonth(YearMonth yearMonth) {
        int noOfDays = yearMonth.lengthOfMonth();

        LocalDate firstDay = yearMonth.atDay(1);

        for (int i = 0; i < noOfDays; i++) {
            LocalDate nextDay = firstDay.plusDays(i);
            System.out.println(nextDay + " " + nextDay.getDayOfWeek());
        }
    }
}
