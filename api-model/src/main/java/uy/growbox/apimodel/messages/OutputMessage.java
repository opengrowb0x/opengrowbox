package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.InputOutputId;
import uy.growbox.apimodel.Message;


public class OutputMessage extends Message {

    public final String inputOutputId;
    public final boolean state;
    public final Integer onSeconds;

    public OutputMessage(InputOutputId inputOutputId, boolean state) {
        super(Type.OUTPUT_MESSAGE);
        this.inputOutputId = inputOutputId.toString();
        this.state = state;
        onSeconds = null;
    }

    public OutputMessage(String inputOutputId, boolean state) {
        super(Type.OUTPUT_MESSAGE);
        this.inputOutputId = inputOutputId;
        this.state = state;
        onSeconds = null;
    }

    public OutputMessage(String inputOutputId, boolean state, int onSeconds) {
        super(Type.OUTPUT_MESSAGE);
        this.inputOutputId = inputOutputId;
        this.state = state;
        this.onSeconds = onSeconds;
    }
}
