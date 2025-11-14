package uy.growbox.apimodel.valuetypes;

import uy.growbox.apimodel.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//TODO convert to record class and extract logic and constants
public class GrowPeriodBean {
    public final static String dateFormat = "yyyy-MM-dd";
    public final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

    public final Integer id;
    public final String growDescription;
    public final int sunriseHour;
    public final int photoPeriod;
    public final int totalDays;
    public final int vegetationDays;
    public final int vegetationDaylightHours;
    public final int floweringDaylightHours;
    public final String startDate;
    public final int wateringSeconds;
    public final float nutrientACDosingSeconds;
    public final float nutrientBDosingSeconds;
    public final int floodSeconds;
    public String growboxState;


    public GrowPeriodBean(int id, String growDescription, int sunriseHour, int photoPeriod, int totalDays, int vegetationDays,
                          int vegetationDaylightHours, int floweringDaylightHours,
                          String startDate, int wateringSeconds, float nutrientACDosingSeconds, float nutrientBDosingSeconds, int floodSeconds, String growboxState) {
        this.id = id;
        this.growDescription = growDescription;
        this.sunriseHour = sunriseHour;
        this.photoPeriod = photoPeriod;
        this.totalDays = totalDays;
        this.vegetationDays = vegetationDays;
        this.vegetationDaylightHours = vegetationDaylightHours;
        this.floweringDaylightHours = floweringDaylightHours;
        this.startDate = startDate;
        this.wateringSeconds = wateringSeconds;
        this.nutrientACDosingSeconds = nutrientACDosingSeconds;
        this.nutrientBDosingSeconds = nutrientBDosingSeconds;
        this.floodSeconds = floodSeconds;
        this.growboxState = growboxState;
    }


    public GrowPeriodBean(String growDescription, int sunriseHour, int photoPeriod, int totalDays, int vegetationDays,
                          int vegetationDaylightHours, int floweringDaylightHours,
                          String startDate, int wateringSeconds, float nutrientACDosingSeconds, float nutrientBDosingSeconds, int floodSeconds, String growboxState) {
        this.nutrientACDosingSeconds = nutrientACDosingSeconds;
        this.nutrientBDosingSeconds = nutrientBDosingSeconds;
        this.floodSeconds = floodSeconds;
        this.id = null;
        this.growDescription = growDescription;
        this.sunriseHour = sunriseHour;
        this.photoPeriod = photoPeriod;
        this.totalDays = totalDays;
        this.vegetationDays = vegetationDays;
        this.vegetationDaylightHours = vegetationDaylightHours;
        this.floweringDaylightHours = floweringDaylightHours;
        this.startDate = startDate;
        this.wateringSeconds = wateringSeconds;
        this.growboxState = growboxState;
    }

    public GrowPeriodBean(String growDescription, int sunriseHour, int photoPeriod, int totalDays, int vegetationDays,
                          int vegetationDaylightHours, int floweringDaylightHours,
                          Calendar startDate, int wateringSeconds, String growboxState, float nutrientACDosingSeconds, float nutrientBDosingSeconds, int floodSeconds) {
        this(growDescription, sunriseHour, photoPeriod, totalDays, vegetationDays, vegetationDaylightHours, floweringDaylightHours,
                simpleDateFormat.format(startDate), wateringSeconds, nutrientACDosingSeconds, nutrientBDosingSeconds, floodSeconds, growboxState);
    }

    public final GrowingState getGrowingState() throws ParseException {
        if (startDate == null) {
            System.out.println("startDate is null");
            return GrowingState.READY;
        }
        Calendar startDateCal = getStartDateCalendar();

        Calendar floweringDate = (Calendar) startDateCal.clone();
        Calendar end = (Calendar) startDateCal.clone();
        floweringDate.add(Calendar.DAY_OF_YEAR, vegetationDays);
        end.add(Calendar.DAY_OF_YEAR, totalDays);
        //LocalDate floweringDate = startDateCal.plusDays(vegetationDays);
        Calendar today = Calendar.getInstance();
        if (today.before(startDateCal)) {
            return GrowingState.READY;
        } else if ((today.equals(startDateCal) || today.after(startDateCal)) && today.before(floweringDate)) {
            return GrowingState.VEGETATION;
        } else if (today.equals(floweringDate) ||
                today.after(floweringDate) && today.before(end)) {
            return GrowingState.FLOWERING;
        } else if (today.after(end)) {
            return GrowingState.DRYING;
        }
        return GrowingState.READY;
    }

    public Calendar getStartDateCalendar() throws ParseException {
        Date startDateDate = Message.simpleDateFormat.parse(startDate);
        Calendar startDateCal = Calendar.getInstance();
        startDateCal.setTime(startDateDate);
        return startDateCal;
    }

    @Override
    public String toString() {
        return "GrowPeriodBean{" +
                "id='" + id + '\'' +
                "growDescription='" + growDescription + '\'' +
                ", sunriseHour=" + sunriseHour +
                ", photoPeriod=" + photoPeriod +
                ", totalDays=" + totalDays +
                ", vegetationDays=" + vegetationDays +
                ", vegetationDaylightHours=" + vegetationDaylightHours +
                ", floweringDaylightHours=" + floweringDaylightHours +
                ", growboxState=" + growboxState +
                ", wateringSeconds=" + wateringSeconds +
                ", startDate=" + startDate +
                '}';
    }
}
