package me.deathSwap.commands;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.deathSwap.main.Main;


public class Commands implements CommandExecutor{
	Main plugin;
	public Commands(Main plugin){
		plugin.getCommand("  deathSwapTwo").setExecutor(this);
		plugin.getCommand("deathSwapThree").setExecutor(this);
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String alias, String[] args) {
		Player player = (Player)sender; 

		switch(cmd.getName()){
		
			case "deathSwapTwo":
				Bukkit.broadcastMessage("Yes");
				try {
					
					Player a = Bukkit.getPlayer(args[0]);
					Player b = Bukkit.getPlayer(args[1]);
					long time = Integer.parseInt(args[2]) * 1000;
					
					Timer timer = new Timer();
					TimerTask myTask = new TimerTask() {
					    @Override
					    public void run() {
					    	new Thread(new Runnable() {
								long time1 = System.currentTimeMillis();
								long time2 = System.currentTimeMillis();
								long difference = 10;
								long originalDiff = 10;
								public void run(){
									while(time2 - time1 < time) {
										difference -= time2 - time1;
										difference = (int)difference/1000;
										if(difference != originalDiff) {
											
											long showtime = (time/1000) + difference;
											if(showtime % 60 == 0 && showtime != 0) {
												Bukkit.broadcastMessage(ChatColor.GREEN + "Time Left: " + showtime);
					
											} else if(showtime == 45 || showtime == 30) {
												Bukkit.broadcastMessage(ChatColor.YELLOW + "Time Left: " + showtime);
											} else if(showtime > 9 && showtime < 30 && showtime % 5 == 0) {
												Bukkit.broadcastMessage(ChatColor.GOLD + "Time Left: " + showtime);
											} else if(showtime < 10) {
												Bukkit.broadcastMessage(ChatColor.RED + "Time Left: " + showtime);
											}
											
											originalDiff = difference;
										}
										
										
										time2 = System.currentTimeMillis();
					
								}
								try {
									new BukkitRunnable() {
								        public void run() {
								        	Location aloc = a.getLocation();
											Location bloc = b.getLocation();
											
											a.teleport(bloc);
											b.teleport(aloc);
								        }
								    }.runTask(plugin);
		
		
								} catch(Exception e) {
									throw new IllegalStateException("ERROR YEEEEEEEEEEEEt");
								}
								
					
							}}).start();
					    }
					};

					timer.schedule(myTask, 0, time);
										
				}
				catch(Exception e) {
					player.sendMessage("lol wrong args");
					throw new ArrayIndexOutOfBoundsException("lol wrong args");
				}
				
				break;
				
				
		case "deathSwapThree":
			Bukkit.broadcastMessage("Yes");
			try {
				
				Player a = Bukkit.getPlayer(args[0]);
				Player b = Bukkit.getPlayer(args[1]);
				Player c = Bukkit.getPlayer(args[2]);

				long time = Integer.parseInt(args[3]) * 1000;
				
				Timer timer = new Timer();
				TimerTask myTask = new TimerTask() {
				    @Override
				    public void run() {
				    	new Thread(new Runnable() {
							long time1 = System.currentTimeMillis();
							long time2 = System.currentTimeMillis();
							long difference = 10;
							long originalDiff = 10;
							public void run(){
								while(time2 - time1 < time) {
									difference -= time2 - time1;
									difference = (int)difference/1000;
									if(difference != originalDiff) {
										
										long showtime = (time/1000) + difference;
										if(showtime % 60 == 0 && showtime != 0) {
											Bukkit.broadcastMessage(ChatColor.GREEN + "Time Left: " + showtime);
				
										} else if(showtime == 45 || showtime == 30) {
											Bukkit.broadcastMessage(ChatColor.YELLOW + "Time Left: " + showtime);
										} else if(showtime > 9 && showtime < 30 && showtime % 5 == 0) {
											Bukkit.broadcastMessage(ChatColor.GOLD + "Time Left: " + showtime);
										} else if(showtime < 10) {
											Bukkit.broadcastMessage(ChatColor.RED + "Time Left: " + showtime);
										}
										
										originalDiff = difference;
									}
									
									
									time2 = System.currentTimeMillis();
				
							}
							try {
								new BukkitRunnable() {
							        public void run() {
							        	int i = (int)Math.random() * 2;
							        	Location aloc = a.getLocation();
							        	Location bloc = b.getLocation();
							        	Location cloc = c.getLocation();
							        	if(i == 0) {
							        		a.teleport(bloc);
							        		b.teleport(cloc);
							        		c.teleport(aloc);
							        	} else {
							        		a.teleport(cloc);
							        		b.teleport(aloc);
							        		c.teleport(bloc);
							        	}
									
							        }
							    }.runTask(plugin);
	
	
							} catch(Exception e) {
								throw new IllegalStateException("ERROR YEEEEEEEEEEEEt");
							}
							
				
						}}).start();
				    }
				};
				
				timer.schedule(myTask, 0, time);
									
			}
			catch(Exception e) {
				player.sendMessage("lol wrong args");
				throw new ArrayIndexOutOfBoundsException("lol wrong args");
			}
				
				
			break;
		}
		return false;
	}



}
