package uy.growbox.apimodel.messages;

import java.util.Calendar;

import uy.growbox.apimodel.Message;

public class PictureMessage extends Message {
    public final String imageName;
    public final String date;
    public final byte[] image;

    public PictureMessage(String imageName, byte[] image, String date) {
        super(Type.PICTURE_MESSAGE);
        this.imageName = imageName;
        this.image = image;
        this.date = date;
    }

    public PictureMessage(String imageName, byte[] image, Calendar date) {
        super(Type.PICTURE_MESSAGE);
        this.imageName = imageName;
        this.image = image;
        this.date = simpleDateFormat.format(date.getTime());
    }

    @Override
    public String toString() {
        return "PictureMessage{" +
                "imageName='" + imageName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
