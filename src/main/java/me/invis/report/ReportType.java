package me.invis.report;

import me.invis.report.preset.Setting;
import me.invis.report.util.ArrayUtil;

import java.util.List;

public enum ReportType {

    CHAT,
    INGAME;

    public static ReportType getByReport(String report) {
        List<String> reportTypesList = Setting.INGAME_REPORT_TYPES;

        // First check...
        if(checkReport(report, reportTypesList)) return ReportType.INGAME;
        else {
            // Second check...
            reportTypesList = Setting.CHAT_REPORT_TYPES;
            if(checkReport(report, reportTypesList)) return ReportType.CHAT;
        }

        return null;
    }

    private static boolean checkReport(String report, List<String> reportTypesStrings) {
        for (String reportType : reportTypesStrings) {
            String[] reportStringParts = reportType.split("\\|");
            String reportName = reportStringParts[0];
            String[] reportAliases = (reportStringParts.length >= 2 ? reportStringParts[1].split("-") : new String[0]);

            if(report.equalsIgnoreCase(reportName) || ArrayUtil.contains(reportAliases, report)) return true;
        }

        return false;
    }

}
