package me.invis.report.config.settings;

import java.util.List;

public class Settings {

    private final List<String> ingameReportTypes, chatReportTypes;
    private final int reportDelay;

    public Settings(List<String> ingameReportTypes, List<String> chatReportTypes, int reportDelay) {
        this.ingameReportTypes = ingameReportTypes;
        this.chatReportTypes = chatReportTypes;

        this.reportDelay = reportDelay;
    }

    public List<String> getIngameReportTypes() {
        return this.ingameReportTypes;
    }

    public List<String> getChatReportTypes() {
        return this.chatReportTypes;
    }

    public int getReportDelay() {
        return this.reportDelay;
    }

}
