import org.junit.Test;
import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.GrowPeriodBean;
import uy.growbox.apimodel.valuetypes.GrowingState;

import java.text.ParseException;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class GrowPeriodBeanTest {


    @Test
    public void verifyGrowingStateFlowering() throws ParseException {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR, -5);
        final GrowPeriodBean floweringPeriod = new GrowPeriodBean(1, "test_grow", 2, 10, 10, 4, 8,
                2, Message.simpleDateFormat.format(startDate.getTime()), 10, 5, 4, 2, Message.GrowPeriodState.GROWING.toString());

        assertEquals(GrowingState.FLOWERING, floweringPeriod.getGrowingState());
    }

    @Test
    public void verifyGrowingStateFloweringOnFloweringDay() throws ParseException {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR, -5);
        final GrowPeriodBean floweringPeriod = new GrowPeriodBean(1, "test_grow", 2, 10,
                10, 5, 8,
                2, Message.simpleDateFormat.format(startDate.getTime()), 10, 2, 2,3, Message.GrowPeriodState.GROWING.toString());

        assertEquals(GrowingState.FLOWERING, floweringPeriod.getGrowingState());
    }

    @Test
    public void verifyGrowingStateVegetation() throws ParseException {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR, -4);
        final GrowPeriodBean floweringPeriod = new GrowPeriodBean(1, "test_grow", 2, 10,
                10, 5, 8,
                2, Message.simpleDateFormat.format(startDate.getTime()), 10, 2, 2,3, Message.GrowPeriodState.GROWING.toString());

        assertEquals(GrowingState.VEGETATION, floweringPeriod.getGrowingState());
    }

    @Test
    public void verifyGrowingStateDrying() throws ParseException {
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.DAY_OF_YEAR, -11);
        String startDateString = Message.simpleDateFormat.format(startDate.getTime());
        System.out.println("Gp start date " + startDateString);
        final GrowPeriodBean floweringPeriod = new GrowPeriodBean(1, "test_grow", 2, 10,
                10, 5, 8,
                2, startDateString, 10, 2, 2,3, Message.GrowPeriodState.GROWING.toString());

        assertEquals(GrowingState.DRYING, floweringPeriod.getGrowingState());
    }
}
