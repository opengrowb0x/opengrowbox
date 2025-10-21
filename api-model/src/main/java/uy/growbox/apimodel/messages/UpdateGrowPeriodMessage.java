package uy.growbox.apimodel.messages;


import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.GrowPeriodBean;

public class UpdateGrowPeriodMessage extends Message {

    public final GrowPeriodBean growPeriodBean;

    public UpdateGrowPeriodMessage(GrowPeriodBean growPeriodBean) {
        super(Type.UPDATE_GROW_PERIOD);
        this.growPeriodBean = growPeriodBean;
    }
}
