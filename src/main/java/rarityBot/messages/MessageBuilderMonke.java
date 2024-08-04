package rarityBot.messages;

import java.awt.Color;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import rarityBot.businessObjects.MonkeData;

public class MessageBuilderMonke {
	
	public MessageEmbed getMessage(MonkeData monkeData) {
		
        EmbedBuilder e = new EmbedBuilder();
        if(monkeData.getRank()> 50) {
        	e.setTitle("Monkeez #"+monkeData.getTokenId()+" is ranked "+monkeData.getRank()+"/500").setColor(Color.RED);
        }else {
        	e.setTitle("Monkeez #"+monkeData.getTokenId()+" is Legendary").setColor(Color.ORANGE);
        }
        e.setImage(monkeData.getImgLink());
		return e.build();
	}

}
