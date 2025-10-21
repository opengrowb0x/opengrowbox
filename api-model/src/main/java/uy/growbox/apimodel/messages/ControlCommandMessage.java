package uy.growbox.apimodel.messages;

import uy.growbox.apimodel.Message;

public class ControlCommandMessage extends Message {
    public enum ControlCommand {
        play,
        stop,
        pause,
        delete,
        restart_service,
        restart_device,
        live,
        record
    }
    public final ControlCommand command;


    public ControlCommandMessage(ControlCommand command) {
        super(Type.CONTROL_COMMAND);
        this.command = command;
    }
}
