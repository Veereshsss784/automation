package sample;
import java.time.LocalDate;

public class PrintDate {
   public static void main(String[] args) {
      // Get today's date
      LocalDate today = LocalDate.now();
      System.out.println("Today's date: " + today);

      // Get tomorrow's date
      LocalDate tomorrow = today.plusDays(1);
      System.out.println("Tomorrow's date: " + tomorrow);
   }
}


