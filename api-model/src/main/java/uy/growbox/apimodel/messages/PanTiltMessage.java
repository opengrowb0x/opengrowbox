package uy.growbox.apimodel.messages;


import uy.growbox.apimodel.Message;

public class PanTiltMessage extends Message {

    public final Integer horizontalValue;
    public final Integer verticalValue;

    public PanTiltMessage(Integer horizontalValue, Integer verticalValue) {
        super(Type.MOVE_CAMERA);
        this.horizontalValue = horizontalValue;
        this.verticalValue = verticalValue;
    }

    public static PanTiltMessage moveVertically(int verticalValue) {
        return  new PanTiltMessage(null, verticalValue);
    }

    public static PanTiltMessage moveHorizontally(int horizontalValue) {
        return  new PanTiltMessage(horizontalValue, null);
    }

    public static PanTiltMessage moveDiagonally(int horizontalValue, int verticalValue) {
        return  new PanTiltMessage(horizontalValue, verticalValue);
    }
}
