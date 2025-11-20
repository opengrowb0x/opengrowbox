package uy.growbox.apimodel.utilities;

import uy.growbox.apimodel.Message;

import java.text.ParseException;
import java.util.Date;

public class DateTimeUtils {

    public Date parseDateTime(String date) throws ParseException {
        return Message.simpleDateTimeFormat.parse(date);
    }

    public long getDateInMillis(String date) throws ParseException {
        final Date parsedDate = Message.simpleDateTimeFormat.parse(date);
        return parsedDate.getTime();
    }
}
