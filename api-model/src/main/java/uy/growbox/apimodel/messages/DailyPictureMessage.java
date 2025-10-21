package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.Message;

import java.util.Calendar;
import java.util.List;

public class DailyPictureMessage extends Message {

    public final List<PictureMessage> dailyPictures;
    public final String date;

    public DailyPictureMessage(List<PictureMessage> dailyPictures, String date) {
        super(Type.DAILY_PICTURES_MESSAGE);
        this.dailyPictures = dailyPictures;
        this.date = date;
    }

    public DailyPictureMessage(Calendar date) {
        super(Type.DAILY_PICTURES_MESSAGE);
        this.dailyPictures = null;

        if (date == null) {
            this.date = null;
        }
        else {
            this.date = simpleDateFormat.format(date.getTime());
        }
    }

    public DailyPictureMessage(List<PictureMessage> dailyPictures) {
        super(Type.DAILY_PICTURES_MESSAGE);
        this.dailyPictures = dailyPictures;
        this.date = null;
    }


}
