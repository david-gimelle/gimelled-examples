package com.gimelle.sandbox.javaeight;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Java8TimeClassesTest {

    @Test
    public void playWithNewLocalTimeClasses(){

        LocalTime localTime = LocalTime.now();

        LocalTime Oneh12min30s = LocalTime.of (1, 12, 30);

        assertThat(localTime.compareTo(Oneh12min30s) > 0, is(true));
    }

    @Test
    public void playWithNewLocalDateClasses(){

        LocalDate today = LocalDate.now();

        MonthDay x28Feb = MonthDay.of(2, 28);

        //so today is after the 28 feb ...
        assertThat(MonthDay.from(today).compareTo(x28Feb)>0, is(true));

    }

    @Test
    public void haveFunWithNewStringFormatterMatcher(){

        LocalTime localTime = LocalTime.of(11,12);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        assertThat(formatter.format(localTime).toString(), equalTo("11:12"));

        LocalTime.parse("11:12",formatter);

        assertThat(LocalTime.parse("11:12",formatter), equalTo(localTime));
    }
}
