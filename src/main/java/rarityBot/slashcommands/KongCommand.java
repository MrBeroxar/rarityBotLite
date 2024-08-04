package rarityBot.slashcommands;

import java.util.Collections;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import rarityBot.businessObjects.KongData;
import rarityBot.messages.MessageBuilderKong;
import rarityBot.search.KongzCSVReader;

public class KongCommand extends SlashCommand{
	
	private KongzCSVReader kongReader = new KongzCSVReader();
	private MessageBuilderKong kongMessage = new MessageBuilderKong();
	
	public KongCommand() {
		kongReader.readAll();
		this.name = "kongz";
		this.help = "Gets the rank of the Kong";
		this.options = Collections.singletonList(new OptionData(OptionType.INTEGER, "tokenid", "Enter the id of a Kong").setRequired(true));
	}
	@Override
	protected void execute(SlashCommandEvent event) {
		
		OptionMapping option = event.getOption("tokenid");
		if (option == null) {
            event.reply("Enter the id of a Kong!").setEphemeral(true).queue();
            return;
        }if(option.getAsLong() > 1010) {
        	event.reply("There are only 1010 Kongz!").setEphemeral(true).queue();
        	return;
        }
		KongData kongData = kongReader.searchByTokenId(option.getAsLong());
		event.replyEmbeds(kongMessage.getMessage(kongData)).queue();
		if(kongData.getGif()!=null) {
			event.getGuild().getTextChannelsByName("💍│rarity",true).get(0).sendMessage(kongData.getGif()).queue();
		}
	}
}
