package rarityBot.slashcommands;

import java.awt.Color;
import java.util.Collections;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import rarityBot.processing.GetIfpsHttpClient;

public class BabyCommand extends SlashCommand{ 
	private GetIfpsHttpClient ifps = new GetIfpsHttpClient();
	public BabyCommand() {
		this.name = "baby";
		this.help = "Gets the rank of the Baby";
		this.options = Collections.singletonList(new OptionData(OptionType.INTEGER, "tokenid", "Enter the id of a Baby").setRequired(true));
	}
	@Override
	protected void execute(SlashCommandEvent event) {
		
		OptionMapping option = event.getOption("tokenid");
		if (option == null) {
            event.reply("Enter the id of a Baby!").setEphemeral(true).queue();
            return;
        }if(option.getAsLong() > 3000) {
        	event.reply("There are only 3000 Babies!").setEphemeral(true).queue();
        	return;
        }
		EmbedBuilder e = new EmbedBuilder();
        long x = option.getAsLong();
        e.setTitle("Baby #"+x+" is ranked ???/3000").setColor(Color.BLUE);
        try {
			e.setImage(ifps.getImg(x));
		} catch (Exception e1) {
			e.setImage("try again");
		}
        event.replyEmbeds(e.build()).queue();
		
	}
	
	
}
