package rarityBot.main;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import rarityBot.slashcommands.BabyCommand;
import rarityBot.slashcommands.KongCommand;
import rarityBot.slashcommands.MonkeCommand;

public class CommandListener extends ListenerAdapter  {

	public static void main(String[] args) throws Exception
    {	
		CommandClientBuilder builder = new CommandClientBuilder();
		builder.setOwnerId("414437021608706069");
		builder.addSlashCommands( new MonkeCommand(),new KongCommand(),new BabyCommand());
		CommandClient commandClient = builder.build();
		
        JDABuilder.createDefault("OTQxODMyMjE0MDg0MjE0ODI2.Gf3hC8.yxf99hQWpA4-IubOVaf9Zzti1eyCKASBbos3AI")
            .addEventListeners(commandClient)
            .build();
        
        builder.forceGuildOnly("897239025327431711");
    }    
}
