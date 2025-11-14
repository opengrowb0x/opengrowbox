package uy.growbox.apimodel.valuetypes;

import java.io.Serializable;

public record ConfigurationBean(String raspiStillOptions, Integer slowMoStartHour, Integer servoHorizontalMin,
                                Integer servoHorizontalMax, Integer servoVerticalMin,
                                Integer servoVerticalMax) implements Serializable {


}
