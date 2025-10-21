package uy.growbox.apimodel.messages;


import uy.growbox.apimodel.Message;
import uy.growbox.apimodel.valuetypes.ConfigurationBean;

public class ConfigurationMessage extends Message {

    public final ConfigurationBean configurationBean;

    public ConfigurationMessage(ConfigurationBean configurationBean) {
        super(Type.UPDATE_CONFIG);
        this.configurationBean = configurationBean;
    }
}
