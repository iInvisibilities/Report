package me.invis.report.config.messages;

import me.invis.report.config.messages.enums.MessageType;
import me.invis.report.util.CC;

import java.util.Map;

public class Messages {

    private final Map<MessageType, String> messages;

    public Messages(Map<MessageType, String> messages) {
        messages.forEach((messageType, message) -> messages.put(messageType, CC.translateColors(message)));
        this.messages = messages;
    }

    public Map<MessageType, String> getValues() {
        return this.messages;
    }

}
