package rarityBot.businessObjects;

public class MonkeData {
	
	private long tokenId;
	private long rank;
	private String imgLink;
	private String gif;
	
	public void parseTokenId(String data) {
		this.tokenId = Long.parseLong(data);
	}
	public void parseRank(String data){
		long x = Long.parseLong(data)+50;
		if(x<86) {
			this.gif = "https://tenor.com/view/pepe-kek-rare-pepe-gif-13819400";
		}if(x>490) {
			this.gif = "https://tenor.com/view/ree-pepe-triggered-angry-ahhhh-gif-13627544";
		}
		this.rank = x;
	}
	public void setRank(long rank) {
		if(rank==1) {
			this.gif = "https://tenor.com/view/pepe-think-pepe-the-frog-gif-15109639";
		}
		this.rank = rank;
	}
	public void setTokenId(long l) {
		if(l==69) {
			this.gif = "https://tenor.com/view/pepe-gif-13326371";
		}if(l==420) {
			this.gif = "https://tenor.com/view/pepe-kek-smile-gif-13819379";
		}
		this.tokenId = l;
	}
	public long getTokenId() {
		return tokenId;
	}
	public long getRank() {
		return rank;
	}
	public String getImgLink() {
		return imgLink;
	}
	public void setImgLink(String imgLink) {
		this.imgLink = imgLink;
	}
	public String getGif() {
		return gif;
	}
	public void setGif(String gif) {
		this.gif = gif;
	}
}
