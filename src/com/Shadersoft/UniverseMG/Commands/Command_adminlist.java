package com.Shadersoft.UniverseMG.Commands;

import org.apache.commons.lang.StringUtils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.Shadersoft.UniverseMG.Messages;
import com.Shadersoft.UniverseMG.Ranks.Rank;
import com.Shadersoft.UniverseMG.UniverseMG;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.bukkit.Bukkit.getOfflinePlayer;
import org.bukkit.OfflinePlayer;

public class Command_adminlist implements UMGCommand
{
    public UniverseMG plugin = UniverseMG.plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(Rank.getSenderRank(sender).getPriority() < this.getRank().getPriority())
        {
            sender.sendMessage(Messages.MSG_NO_PERMS);

            return true;
        }
        
        if(args.length != 1)
        {
            return false;
        }
        switch(args[0].toUpperCase())
        {
            case "LIST":
            {
                if(Rank.getSenderRank(sender).getPriority() < Rank.MEMBER.getPriority())
                {
                    sender.sendMessage(Messages.MSG_NO_PERMS);
                    
                    return true;
                }
                
                List<String> admins = new ArrayList();
                
                for(String pname : plugin.config.getConfigurationSection("ranks").getKeys(false))
                {
                    OfflinePlayer p = getOfflinePlayer(pname);
                    Rank rank = Rank.getRank(plugin.config.getString("ranks." + pname));
                    admins.add(rank.getColor() + p.getName());
                }
                
                sender.sendMessage(StringUtils.join(admins, ChatColor.RED + ", "));
            }
        }
        return true;
    }

    @Override
    public Rank getRank()
    {
        return Rank.MEMBER;
    }
    @Override
    public List<String> getAliases() 
    {
        return Arrays.asList("");
    }

    @Override
    public String getUsage() 
    {
        return "/<command> <list>";
    }

    @Override
    public String getDescription() 
    {
        return "Gets the admin list.";
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
