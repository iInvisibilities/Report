package me.invis.report.preset;

import me.invis.report.Report;
import me.invis.report.config.messages.Messages;
import me.invis.report.config.messages.enums.MessageType;

public class Message {

    private static final Messages messages = Report.getInstance().getMessages();

    public static String REPORT_SUCCESS = messages.getValues().get(MessageType.REPORT_SUCCESS);
    public static String REPORT_FAIL = messages.getValues().get(MessageType.REPORT_FAIL);

    public static String REPORT_COOLDOWN = messages.getValues().get(MessageType.REPORT_COOLDOWN);

    public static String REPORT_RECEIVED = messages.getValues().get(MessageType.REPORT_RECEIVED);

}
