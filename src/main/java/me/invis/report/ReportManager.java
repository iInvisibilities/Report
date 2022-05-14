package me.invis.report;

import me.invis.report.inventory.ReportsInventory;
import me.invis.report.preset.Message;
import me.invis.report.preset.Setting;
import me.invis.report.staff.StaffManager;
import me.invis.report.util.ArrayUtil;
import me.invis.report.util.Cooldown;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ReportManager {

    public static boolean isReportValid(ReportType reportType, String report) {
        for (String registeredReportString : (reportType == ReportType.INGAME ? Setting.INGAME_REPORT_TYPES : Setting.CHAT_REPORT_TYPES)) {
            String[] reportStringParts = registeredReportString.split("\\|");
            String reportName = reportStringParts[0];
            String[] reportAliases = (reportStringParts.length >= 2 ? reportStringParts[1].split("-") : new String[0]);

            if(report.equalsIgnoreCase(reportName) || ArrayUtil.contains(reportAliases, report)) return true;
        }

        return false;
    }

    public static void executeReport(ReportType reportType, String report, Player executor, Player reported) {
        if(reported == null) {
            executor.sendMessage(Message.REPORT_FAIL);
            return;
        }

        if(!isReportValid(reportType, report)) {
            executor.sendMessage(Message.REPORT_FAIL);
            return;
        }

        if(Cooldown.isInCooldown(executor)) {
            executor.sendMessage(Message.REPORT_COOLDOWN);
            return;
        }

        executor.sendMessage(Message.REPORT_SUCCESS);
        Cooldown.addPlayer(executor);

        List<String> reportedPlayers = new ArrayList<>(Report.getCurrentReportsFile().getStringList(report));
        reportedPlayers.add(reported.getUniqueId().toString());

        Report.getCurrentReportsFile().set(report, reportedPlayers);

        ReportsInventory.initItems();

        StaffManager.getCurrentStaff().forEach(staffMember -> staffMember.sendMessage(Message.REPORT_RECEIVED));
    }

}
