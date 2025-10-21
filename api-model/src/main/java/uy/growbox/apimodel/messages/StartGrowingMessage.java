package uy.growbox.apimodel.messages;


import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.GrowPeriodBean;

public class StartGrowingMessage extends Message {

    public final GrowPeriodBean growPeriodBean;

    public StartGrowingMessage(GrowPeriodBean growPeriodBean) {
        super(Type.START_GROWING);
        this.growPeriodBean = growPeriodBean;
    }
}
