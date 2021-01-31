package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class DateTimeExerciseTest {

    private List<String> list;

    @Before
    public void init(){
        list = DateTimeExercise.fridays13();
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
}
