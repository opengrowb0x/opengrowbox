package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.Message;

public class TakePictureMessage extends Message {
    public TakePictureMessage() {
        super(Type.TAKE_PICTURE_MESSAGE);
    }
}
