package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class DateTimeExercise {

    private static final LocalDate DATE_START_FROM_2000 = LocalDate.of(2000, 01, 01);

    /*
    Список месяцев, в которых есть пятница 13-е. От 2000 года до сегодня.
    String имеет формат “MMM yyyy”, например “Jul 2013”, список упорядочен по возрастанию дат.
     */
    public static List<String> fridays13() {
        List<String> badDays = new ArrayList<>();
        LocalDate start = DATE_START_FROM_2000;
        LocalDate end = LocalDate.now();
        while (start.getYear() < end.getYear()) {
            for (int month = 1; month <= Month.values().length; month++) {
                LocalDate date = LocalDate.of(start.getYear(), month, 13);
                if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                    badDays.add(date.format(DateTimeFormatter.ofPattern("MMM yyyy")));
                }
            }
            start = start.plusYears(1);
        }
        return badDays;
    }

    /*
    Список месяцев, которые заканчиваются в воскресенье. От 2000 года до cегодня.
    Cписок упорядочен по возрастанию дат.
     */
    public static List<YearMonth> endOnSundays() {
        List<YearMonth> lastDaysOfMoth = new ArrayList<>();
        LocalDate start = DATE_START_FROM_2000;
        LocalDate end = LocalDate.now();
        while (start.getYear() < end.getYear()) {
            for (int month = 1; month <= Month.values().length; month++) {
                LocalDate lastDay = LocalDate.of(start.getYear(), month, start.getDayOfMonth()).with(TemporalAdjusters.lastDayOfMonth());
                if (lastDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
                    lastDaysOfMoth.add(YearMonth.of(start.getYear(), month));
                }
            }
            start = start.plusYears(1);
        }
        return lastDaysOfMoth;
    }

    /*
    Список годов, когда заданный день рождения попадает на субботу. От даты рождения до сегодня.
    Список годов упорядочен по возрастанию.
     */
    public static List<Year> birthdaysOnSaturdays(LocalDate birthday) {
        List<Year> birthdaySaturday = new ArrayList<>();
        LocalDate end = LocalDate.now();
        while (birthday.getYear() < end.getYear()) {
            if (birthday.getDayOfWeek() == DayOfWeek.SATURDAY) {
                birthdaySaturday.add(Year.of(birthday.getYear()));
            }
            birthday = birthday.plusYears(1);
        }
        return birthdaySaturday;
    }

    /*
     Для заданного года найти дни, когда количество часов не равно 24.
     Cписок по возрастанию.
     */
    List<MonthDay> daysNotWith24Hours(Year year) {
        return null;
    }

    /*
    Из списка тайм-зон найти зоны, где есть перевод часов.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesAlwaysClockShift(List<ZoneId> zones) {
        return null;
    }

    /*
    Из списка тайм-зон найти зоны, где нет перевода часов.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesNeverClockShift(List<ZoneId> zones) {
        return null;
    }

    /*
    А также зоны, где в одни годы был перевод часов, в другие - нет.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesChangedClockShiftRules(List<ZoneId> zones) {
        return null;
    }
}
