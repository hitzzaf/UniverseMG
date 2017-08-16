package com.Shadersoft.UniverseMG.Commands;

import net.pravian.bukkitlib.command.BukkitCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class Command_serverlinks extends BukkitCommand 
{

    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) 
    {
        
        if (args.length == 0) 
        {
            return false;       
        }
        
        if ("discord".equals(args[0])) 
        {
            
        msg(ChatColor.GREEN + "The server discord is: " + ChatColor.BLUE + plugin.config.getString("discord"));    
        
        }
        
        if ("forums".equals(args[0])) 
        {
            
        msg(ChatColor.GREEN + "The server forums are: " + ChatColor.BLUE + plugin.config.getString("forums"));    
        
        }
        
        if ("github".equals(args[0])) 
        {
            
        msg(ChatColor.GREEN + "The server github is: " + ChatColor.BLUE + plugin.config.getString("github"));    
        
        }
        if ("twitter".equals(args[0))
        {
        
        msg(ChatColor.GREEN + "The server github is: " + ChatColor.BLUE + plugin.config.getString("twitter));
        
        }
       
        return true;
        
    }
    
}
