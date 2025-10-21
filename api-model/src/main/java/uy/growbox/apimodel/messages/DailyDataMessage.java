package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.DailyDataResult;

import java.util.LinkedList;
import java.util.List;

public class DailyDataMessage extends Message {
    public static final String dailyDatePattern = "yyyy-MM-dd";
    public final String portId;

    public final List<DailyDataResult> portData = new LinkedList<>();

    public DailyDataMessage(String portId) {
        super(Type.DAILY_DATA_MESSAGE);
        this.portId = portId;
    }

}
