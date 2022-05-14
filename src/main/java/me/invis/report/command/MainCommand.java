package me.invis.report.command;

import me.invis.report.ReportManager;
import me.invis.report.ReportType;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(!(commandSender instanceof Player) || args.length < 2) return true;

        ReportType reportType = ReportType.valueOf((command.getName().equalsIgnoreCase("chatreport") ? "CHAT" : "INGAME"));
        Player executor = (Player) commandSender;
        Player reported = Bukkit.getPlayer(args[0]);
        String report = args[1];

        ReportManager.executeReport(reportType, report, executor, reported);

        return true;
    }

}
