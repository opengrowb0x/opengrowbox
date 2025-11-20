package uy.growbox.apimodel;

import java.util.Calendar;

public record InputOutputResult (
    Integer readingId,
    String inputOutputId,
    String date,
    Float value
) {
    public InputOutputResult {
        if (date == null) {
            date = Message.simpleDateTimeFormat.format(Calendar.getInstance().getTime());
        }
    }
}
