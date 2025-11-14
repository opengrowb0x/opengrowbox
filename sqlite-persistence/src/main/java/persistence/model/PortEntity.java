package persistence.model;

import java.io.Serializable;

public class PortEntity implements Serializable {

    public enum PortType {
        INPUT,OUTPUT
    }
    public final String portId;
    public final String name;
    public final PortType portType;
    public final Integer gpio;
    public final boolean enabled;

    public PortEntity(String portId, String name, PortType portType, Integer gpio, boolean enabled) {
        this.portId = portId;
        this.name = name;
        this.portType = portType;
        this.gpio = gpio;
        this.enabled = enabled;
    }

}
