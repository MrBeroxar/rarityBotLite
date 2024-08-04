package rarityBot.businessObjects;

public class KongData {
	
	private long tokenId;
	private long rank;
	private String imgLink;
	private String gif;
	
	public void parseTokenId(String data) {
		long x = Long.parseLong(data.substring(1));	
		if(x==861) {
			this.gif = "https://tenor.com/view/gigachad-chad-gif-20773266";
		}else if(x==1003) {
			this.gif = "https://tenor.com/view/floppa-big-floppa-chad-big-floppa-chad-floppa-chad-gif-23500776";
		}else if(x==69) {
			this.gif = "https://tenor.com/view/pepe-gif-13326371 ";
		}else if(x==420) {
			this.gif = "https://tenor.com/view/pepe-kek-smile-gif-13819379";
		}this.tokenId =x;
	}
	public void parseRank(String data){
		try {
			long x = Long.parseLong(data);
			if(x >= 970) {
				this.gif = "https://tenor.com/view/ree-pepe-triggered-angry-ahhhh-gif-13627544";			
			}else if(x<81) {
				this.gif = "https://tenor.com/view/pepe-kek-rare-pepe-gif-13819400 ";
			}
			this.rank = x+20;
		}catch(NumberFormatException e) {
			if(data.equals("https://ipfs.io/ipfs/Qmf7eKQiMAEDVT5pc6cKoMDQPLkwK6T2v35xqFbRQA9nYx")) {
				this.gif = "https://tenor.com/view/anonymous-pepe-rare-pepe-the-matrix-pepe-matrix-gif-15409694";
				this.rank =1;
			}else{
				this.rank = 2;
				this.gif = "https://tenor.com/view/pepe-think-pepe-the-frog-gif-15109639";
			}
		}
	}
	public void setTokenId(long tokenId) {
		this.tokenId = tokenId;
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
