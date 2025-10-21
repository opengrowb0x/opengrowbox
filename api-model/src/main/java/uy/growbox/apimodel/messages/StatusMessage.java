package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.GrowPeriodBean;

import java.util.Calendar;

public class StatusMessage extends Message {
    public final GrowPeriodBean growPeriod;
    public final int daysElapsed;
    public final int daysTotal;

    public final String temperature;
    public final String humidity;
    public final String humiditySoil;
    public final String luminosity;

    public final boolean lightsOn;
    public final boolean fanOn;
    public final Boolean fan2;

    public final boolean waterOn;

    public final String eventDate;

    public StatusMessage(GrowPeriodBean growPeriod, int daysElapsed, int daysTotal, String temperature,
                         String humidity, String humiditySoil, String luminosity,
                         boolean lightsOn, boolean fanOn, boolean waterOn, GrowPeriodState growPeriodState, String growingPeriod, Boolean fan2) {
        super(Type.STATUS_MESSAGE);
        this.growPeriod = growPeriod;
        this.daysElapsed = daysElapsed;
        this.daysTotal = daysTotal;
        this.temperature = temperature;
        this.humidity = humidity;
        this.humiditySoil = humiditySoil;
        this.luminosity = luminosity;
        this.lightsOn = lightsOn;
        this.fanOn = fanOn;
        this.waterOn = waterOn;
        this.fan2 = fan2;
        eventDate = simpleDateTimeFormat.format(Calendar.getInstance().getTime());
    }

    @Override
    public String toJson() {
        return GSON.toJson(this, this.getClass());
    }

}
