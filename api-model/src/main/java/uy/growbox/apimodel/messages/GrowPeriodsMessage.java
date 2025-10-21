package uy.growbox.apimodel.messages;


import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.GrowPeriodBean;

import java.util.Collection;

public class GrowPeriodsMessage extends Message {

    public final Collection<GrowPeriodBean> growPeriods;

    public GrowPeriodsMessage(Collection<GrowPeriodBean> growPeriods) {
        super(Type.GROW_PERIODS);
        this.growPeriods = growPeriods;
    }
}
