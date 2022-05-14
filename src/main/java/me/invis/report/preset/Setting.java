package me.invis.report.preset;

import me.invis.report.Report;
import me.invis.report.config.settings.Settings;

import java.util.List;

public class Setting {

    private static Settings settings = Report.getInstance().getSettings();

    public static List<String> INGAME_REPORT_TYPES = settings.getIngameReportTypes();
    public static List<String> CHAT_REPORT_TYPES = settings.getChatReportTypes();

    public static int REPORT_DELAY = settings.getReportDelay();

}
