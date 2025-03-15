package com.fattied.fl0jah.main;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		ProtocolManager manager = ProtocolLibrary.getProtocolManager();
		
		manager.addPacketListener(new PacketAdapter(this,
													ListenerPriority.NORMAL,
													PacketType.Play.Client.CHAT) {
			@Override
			public void onPacketReceiving(PacketEvent e) {
				Player player = e.getPlayer();
				
				PacketContainer packet = e.getPacket();
				
				System.out.println("[PrtclLbTestPlugin] Player chatted: " + packet.getStrings().read(0));
				
				e.setCancelled(true);
			}
		});
	}
	
	@Override
	public void onDisable() {
		
	}
}
