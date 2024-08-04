package rarityBot.slashcommands;

import java.util.Collections;

import com.jagrosh.jdautilities.command.SlashCommand;
import com.jagrosh.jdautilities.command.SlashCommandEvent;

import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import rarityBot.businessObjects.MonkeData;
import rarityBot.messages.MessageBuilderMonke;
import rarityBot.search.MonkeCSVReader;

public class MonkeCommand extends SlashCommand{
	
	private MonkeCSVReader monkeReader = new MonkeCSVReader();
	private MessageBuilderMonke monkeMessage = new MessageBuilderMonke();
	
	public MonkeCommand() {
		monkeReader.readAll();
		this.name = "monkeez";
		this.help = "Gets the rank of the Monke";
		this.options = Collections.singletonList(new OptionData(OptionType.INTEGER, "tokenid", "Enter the id of a Monke").setRequired(true));
	}
	@Override
	protected void execute(SlashCommandEvent event) {
		
		OptionMapping option = event.getOption("tokenid");
		if (option == null) {
            event.reply("Enter the id of a Monke!").setEphemeral(true).queue();
            return;
        }if(option.getAsLong() > 500) {
        	event.reply("There are only 500 Monkeez!").setEphemeral(true).queue();
        	return;
        }
		
		MonkeData monkeData = monkeReader.searchByTokenId(option.getAsLong());
		event.replyEmbeds(monkeMessage.getMessage(monkeData)).queue();
		if(monkeData.getGif()!=null) {
			event.getGuild().getTextChannelsByName("💍│rarity",true).get(0).sendMessage(monkeData.getGif()).queue();
		}
	}
}
