package persistence.model;

import java.time.LocalDate;

public record DailyDataBean(LocalDate date, float minimum, float maximum, float average) {
}
