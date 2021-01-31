package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

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
    public static List<MonthDay> daysNotWith24Hours(Year year) {
        List<MonthDay> timeNot24 = new ArrayList<>();
        ZonedDateTime date = ZonedDateTime.of(
                LocalDateTime.of(year.get(ChronoField.YEAR), 01, 01, 00, 00),
                TimeZone.getDefault().toZoneId());
        for (int i = 1; i < year.length(); i++) {
            if (ChronoUnit.HOURS.between(date, date.plusDays(1)) != 24) {
                timeNot24.add(MonthDay.of(date.getMonth(), date.getDayOfMonth()));
            }
            date = date.plusDays(1);
        }

        return timeNot24;
    }

    private static List<ZoneId> getZonesByCondition(boolean condition, List<ZoneId> inputZones) {
        List<ZoneId> zones = new ArrayList<>();
        for (ZoneId zoneId : inputZones) {
            if (condition == TimeZone.getTimeZone(zoneId).useDaylightTime()) {
                zones.add(zoneId);
            }
        }
        return zones;
    }

    /*
    Из списка тайм-зон найти зоны, где есть перевод часов.
    Проверяем от 1900 года до сегодня.
     */
    public static List<ZoneId> zonesAlwaysClockShift(List<ZoneId> zones) {
        return getZonesByCondition(true, zones);
    }

    /*
    Из списка тайм-зон найти зоны, где нет перевода часов.
    Проверяем от 1900 года до сегодня.
     */
    public static List<ZoneId> zonesNeverClockShift(List<ZoneId> zones) {
        return getZonesByCondition(false, zones);
    }

    /*
    А также зоны, где в одни годы был перевод часов, в другие - нет.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesChangedClockShiftRules(List<ZoneId> zones) {
        return null;
    }
}
