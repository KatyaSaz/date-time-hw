package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTimeExerciseTest {

    private final LocalDate BIRTHDAY = LocalDate.of(1999, 12, 07);

    private List<String> fridays13;
    private List<YearMonth> sundaysEnd;
    private List<Year> birtdaySaturday;
    private List<ZoneId> clockShift;
    private List<ZoneId> clockNotShift;

    @Before
    public void init() {
        fridays13 = DateTimeExercise.fridays13();
        sundaysEnd = DateTimeExercise.endOnSundays();
        birtdaySaturday = DateTimeExercise.birthdaysOnSaturdays(BIRTHDAY);
        List<ZoneId> zones = getListOfAllTimeZones();
        clockShift = DateTimeExercise.zonesAlwaysClockShift(zones);
        clockNotShift = DateTimeExercise.zonesNeverClockShift(zones);
    }

    private List<ZoneId> getListOfAllTimeZones() {
        List<ZoneId> zoneIds = new ArrayList<>();
        String [] zones = getTimeZonesFromFile("timeZones.txt");
        for (String s : zones) {
            zoneIds.add(ZoneId.of(s));
        }
        return zoneIds;
    }

    private String[] getTimeZonesFromFile(String fileName) {
        String[] zones = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            zones = br.lines().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zones;
    }

    @Test
    public void checkFridays13IsNotNull() {
        Assert.assertNotNull(fridays13);
    }

    @Test
    public void checkFridays13IsAmountOfFridaysRight() {
        final int AMOUNT_OF_FRIDAYS = 37;
        Assert.assertEquals(AMOUNT_OF_FRIDAYS, fridays13.size());
    }

    @Test
    public void checkFridays13IsFirstAndLastFindCorrect() {
        String testDate1 = LocalDate.of(2000, 10, 13).format(DateTimeFormatter.ofPattern("MMM yyyy"));
        String testDate2 = LocalDate.of(2020, 11, 13).format(DateTimeFormatter.ofPattern("MMM yyyy"));
        Assert.assertEquals(testDate1, fridays13.get(0));
        Assert.assertEquals(testDate2, fridays13.get(fridays13.size() - 1));
    }

    @Test
    public void checkEndOnSundaysIsNotNull() {
        Assert.assertNotNull(sundaysEnd);
    }

    @Test
    public void checkEndOnSundaysIsFirstAndLastFindCorrect() {
        YearMonth yearMonth = sundaysEnd.get(0);
        YearMonth yearMonthEnd = sundaysEnd.get(sundaysEnd.size() - 1);
        LocalDate lastDay = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), 01).with(TemporalAdjusters.lastDayOfMonth());
        LocalDate lastDayEnd = LocalDate.of(yearMonthEnd.getYear(), yearMonthEnd.getMonth(), 01).with(TemporalAdjusters.lastDayOfMonth());
        Assert.assertEquals(DayOfWeek.SUNDAY, lastDay.getDayOfWeek());
        Assert.assertEquals(DayOfWeek.SUNDAY, lastDayEnd.getDayOfWeek());
    }

    @Test
    public void checkBirthdaysOnSaturdaysIsNotNull() {
        Assert.assertNotNull(birtdaySaturday);
    }

    @Test
    public void checkBirthdaysOnSaturdaysIsFirstValueCorrect() {
        Assert.assertEquals(BIRTHDAY.plusYears(3).getYear(), birtdaySaturday.get(0).getValue());
    }

    @Test
    public void checkZoneClockShiftIsNotNull() {
        Assert.assertNotNull(clockShift);
    }

    @Test
    public void checkZoneClockShiftIsAmountCorrect() {
        final int AMOUNT_CLOCK_SHIFT = 33;
        Assert.assertEquals(AMOUNT_CLOCK_SHIFT, clockShift.size());
    }

    @Test
    public void checkZonesNeverClockShiftIsNotNull() {
        Assert.assertNotNull(clockNotShift);
    }

    @Test
    public void checkZonesNeverClockShiftIsAmountCorrect(){
        final int AMOUNT_CLOCK_NEVER_SHIFT = 47;
        Assert.assertEquals(AMOUNT_CLOCK_NEVER_SHIFT, clockNotShift.size());
    }
}
