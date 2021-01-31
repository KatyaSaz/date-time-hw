package org.example;

import java.time.*;
import java.util.List;

public class DateTimeExercise {

    /*
    Список месяцев, в которых есть пятница 13-е. От 2000 года до сегодня.
    String имеет формат “MMM yyyy”, например “Jul 2013”, список упорядочен по возрастанию дат.
     */
    List<String> fridays13(){
        return null;
    }

    /*
    Список месяцев, которые заканчиваются в воскресенье. От 2000 года до cегодня.
    Cписок упорядочен по возрастанию дат.
     */
    List<YearMonth> endOnSundays(){
        return null;
    }

    /*
    Список годов, когда заданный день рождения попадает на субботу. От даты рождения до сегодня.
    Список годов упорядочен по возрастанию.
     */
    List<Year> birthdaysOnSaturdays(LocalDate birthday){
        return null;
    }

    /*
     Для заданного года найти дни, когда количество часов не равно 24.
     Cписок по возрастанию.
     */
    List<MonthDay> daysNotWith24Hours(Year year){
        return null;
    }

    /*
    Из списка тайм-зон найти зоны, где есть перевод часов.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesAlwaysClockShift(List<ZoneId> zones){
        return null;
    }

    /*
    Из списка тайм-зон найти зоны, где нет перевода часов.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesNeverClockShift(List<ZoneId> zones){
        return null;
    }

    /*
    А также зоны, где в одни годы был перевод часов, в другие - нет.
    Проверяем от 1900 года до сегодня.
     */
    List<ZoneId> zonesChangedClockShiftRules(List<ZoneId> zones){
        return null;
    }
}
