import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class BabyWeeksCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите дату рождения ребёнка:");
        System.out.print("Год: ");
        int year = scanner.nextInt();
        System.out.print("Месяц (1-12): ");
        int month = scanner.nextInt();
        System.out.print("День: ");
        int day = scanner.nextInt();

        System.out.println("Введите ПДР:");
        System.out.print("Год: ");
        int yearPdr = scanner.nextInt();
        System.out.print("Месяц (1-12): ");
        int monthPdr = scanner.nextInt();
        System.out.print("День: ");
        int dayPdr = scanner.nextInt();

        // Создаём дату рождения
        LocalDate birthDate;
        try {
            birthDate = LocalDate.of(year, month, day);
        } catch (Exception e) {
            System.out.println("Ошибка: некорректная дата!");
            return;
        }

        // Создаём дату ПДР
        LocalDate pdrDate;
        try {
            pdrDate = LocalDate.of(yearPdr, monthPdr, dayPdr);
        } catch (Exception e) {
            System.out.println("Ошибка: некорректная дата!");
            return;
        }

        // Текущая дата
        LocalDate today = LocalDate.now();

        // Проверка: дата не в будущем
        if (birthDate.isAfter(today) || pdrDate.isAfter(today)) {
            System.out.println("Дата не может быть в будущем!");
            return;
        }

        // Вычисляем разницу
        Period period = Period.between(birthDate, today);
        long totalDays = java.time.temporal.ChronoUnit.DAYS.between(birthDate, today);
        int weeks = (int) (totalDays / 7);

        long totalDaysPdr = java.time.temporal.ChronoUnit.DAYS.between(pdrDate, today);
        int weeksPdr = (int) (totalDaysPdr / 7);

        // Выводим результат
        System.out.println("\nРебёнок родился: " + birthDate);
        System.out.println("Сегодня: " + today);
        System.out.println("Возраст: " + period.getYears() + " лет, " + period.getMonths() + " месяцев, " + period.getDays() + " дней");
        System.out.println("Полных недель жизни: " + weeks);

        // Дополнительно: какая неделя идёт сейчас
        System.out.println("Сейчас идёт " + (weeks + 1) + "-я неделя жизни.");
        System.out.println("По ПДР сейчас идёт " + (weeksPdr + 1) + "-я неделя жизни.");
    }
}