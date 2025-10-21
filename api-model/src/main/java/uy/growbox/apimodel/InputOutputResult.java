package uy.growbox.apimodel;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class InputOutputResult {
    public Integer readingId;
    public String inputOutputId;
    public String date;
    public Float value;

    public InputOutputResult(String inputOutputId, Float value) {
        this.inputOutputId = inputOutputId;
        this.date = Message.simpleDateTimeFormat.format(Calendar.getInstance().getTime());
        this.value = value;
    }

    public InputOutputResult(String inputOutputId, String date, Float value) {
        this.inputOutputId = inputOutputId;
        this.date = date;
        this.value = value;
    }

    @Override
    public String toString() {
        return "InputOutputBean{" +
                "readingId=" + readingId +
                ", inputOutputId='" + inputOutputId + '\'' +
                ", date='" + date + '\'' +
                ", value='" + value + '\'' +
                '}';
    }

    public Date getDate() throws ParseException {
        return Message.simpleDateTimeFormat.parse(date);
    }


    public long getDateInMillis() throws ParseException {
        final Date parsedDate = Message.simpleDateTimeFormat.parse(date);
        return parsedDate.getTime();
    }
}
