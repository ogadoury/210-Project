package test;


import model.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.Schedule;

import static org.junit.jupiter.api.Assertions.*;

public class ScheduleTest {

    Schedule schedule = new Schedule();

    @BeforeEach
    public void runBefore () {
    }

    public void loadSchedule () {
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        d1.setDate("1/1/2019");
        d2.setDate("2/1/2019");
        d3.setDate("3/1/2019");
        schedule.addDate(d1);
        schedule.addDate(d2);
        schedule.addDate(d3);
    }



    @Test
    public void testAddDate () {
        Date d = new Date();
        d.setDate("1/1/2019");
        schedule.addDate(d);
        assertTrue(schedule.getDates().contains(d));
        assertEquals(schedule.getDates().size(), 2);
    }

    @Test
    public void testRemoveDate () {
        Date d1 = new Date();
        Date d2 = new Date();
        Date d3 = new Date();
        d1.setDate("1/1/2019");
        d2.setDate("2/1/2019");
        d3.setDate("3/1/2019");
        schedule.addDate(d1);
        schedule.addDate(d2);
        schedule.addDate(d3);

        schedule.removeDate(d2);
        assertFalse(schedule.getDates().contains(d2));
        assertEquals(schedule.getDates().size(), 2);

    }


 }