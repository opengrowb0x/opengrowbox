package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.InputOutputResult;
import uy.growbox.apimodel.Message;

import java.util.LinkedList;
import java.util.List;

public class PortDataMessage extends Message {
    public static final int PORT_DATA_LIMIT = 24;
    public final String portId;

    public final List<InputOutputResult> portData = new LinkedList<>();
    public int maxResults = PORT_DATA_LIMIT;

    public PortDataMessage(String portId) {
        super(Type.PORT_DATA_MESSAGE);
        this.portId = portId;
    }

    public PortDataMessage(String portId, int maxResults) {
        super(Type.PORT_DATA_MESSAGE);
        this.portId = portId;
        this.maxResults = maxResults;
    }


}
