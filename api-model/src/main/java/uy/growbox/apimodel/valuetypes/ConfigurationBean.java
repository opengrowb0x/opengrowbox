package uy.growbox.apimodel.valuetypes;

import java.io.Serializable;

//TODO convert all these into data types (java Records)
/*

public record Person (String name, String address) {}
 */
public class ConfigurationBean implements Serializable {

    public final String raspiStillOptions;

    public final Integer slowMoStartHour;

    public final Integer servoHorizontalMin;
    public final Integer servoHorizontalMax;
    public final Integer servoVerticalMin;
    public final Integer servoVerticalMax;

    public ConfigurationBean(String raspiStillOptions, Integer slowMoStartHour, Integer servoHorizontalMin, Integer servoHorizontalMax, Integer servoVerticalMin, Integer servoVerticalMax) {
        this.raspiStillOptions = raspiStillOptions;
        this.slowMoStartHour = slowMoStartHour;
        this.servoHorizontalMin = servoHorizontalMin;
        this.servoHorizontalMax = servoHorizontalMax;
        this.servoVerticalMin = servoVerticalMin;
        this.servoVerticalMax = servoVerticalMax;
    }


}
