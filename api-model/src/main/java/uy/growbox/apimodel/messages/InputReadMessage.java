package uy.growbox.apimodel.messages;


import uy.growbox.apimodel.InputOutputResult;
import uy.growbox.apimodel.Message;

public class InputReadMessage extends Message {

    public final String inputOutputId;
    public InputOutputResult inputOutputData;

    public InputReadMessage(String inputOutputId) {
        super(Type.READ_INPUT);
        this.inputOutputId = inputOutputId;
    }

    public InputReadMessage(String inputOutputId, InputOutputResult inputOutputData) {
        super(Type.READ_INPUT);
        this.inputOutputId = inputOutputId;
        this.inputOutputData = inputOutputData;
    }
}
