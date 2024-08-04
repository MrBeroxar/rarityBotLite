package rarityBot.messages;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import rarityBot.businessObjects.KongData;

public class MessageBuilderKong {
	
	public MessageEmbed getMessage(KongData kongData) {
		
        EmbedBuilder e = new EmbedBuilder();
        if(kongData.getRank()> 20) {
        	e.setTitle("Kong #"+kongData.getTokenId()+" is ranked "+kongData.getRank()+"/1010").setColor(Color.BLUE);
        }else {
        	e.setTitle("Kong #"+kongData.getTokenId()+" is Legendary ").setColor(Color.MAGENTA);
        }
        e.setImage(kongData.getImgLink());
		return e.build();
	}

}
