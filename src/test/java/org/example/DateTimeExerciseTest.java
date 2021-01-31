package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;
import java.util.List;

public class DateTimeExerciseTest {

    private List<String> list;
    private List<YearMonth> sundaysEnd;

    @Before
    public void init(){
        list = DateTimeExercise.fridays13();
        sundaysEnd = DateTimeExercise.endOnSundays();
    }

    @Test
    public void checkFridays13IsNotNull(){
        Assert.assertNotNull(list);
    }

    @Test
    public void checkFridays13IsAmountOfFridaysRight(){
        final int AMOUNT_OF_FRIDAYS = 37;
        Assert.assertEquals(AMOUNT_OF_FRIDAYS, list.size());
    }

    @Test
    public void checkFridays13IsFirstAndLastFindCorrect(){
        Assert.assertEquals("Oct 2000", list.get(0));
        Assert.assertEquals("Nov 2020", list.get(list.size()-1));
    }

    @Test
    public void checkEndOnSundaysIsNotNull(){
        Assert.assertNotNull(sundaysEnd);
    }

    @Test
    public void checkEndOnSundaysIsFirstAndLastFindCorrect(){
        YearMonth yearMonth = sundaysEnd.get(0);
        YearMonth yearMonthEnd = sundaysEnd.get(sundaysEnd.size()-1);
        LocalDate lastDay = LocalDate.of(yearMonth.getYear(),yearMonth.getMonth(), 01).with(TemporalAdjusters.lastDayOfMonth());
        LocalDate lastDayEnd = LocalDate.of(yearMonthEnd.getYear(),yearMonthEnd.getMonth(), 01).with(TemporalAdjusters.lastDayOfMonth());
        Assert.assertEquals(DayOfWeek.SUNDAY, lastDay.getDayOfWeek());
        Assert.assertEquals(DayOfWeek.SUNDAY, lastDayEnd.getDayOfWeek());
    }
}
