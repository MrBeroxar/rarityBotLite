package rarityBot.processing;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Encode {
	
	 public static String encodeToBase64(long l){
		 
	    	String tokenQuery = "{\"nft_info\": {\"token_id\": \""+l+"\"}}";
	    	try {
	            return Base64.getEncoder()
	                        .encodeToString(tokenQuery.getBytes(StandardCharsets.UTF_8.toString()));        
	        } catch(UnsupportedEncodingException ex) {
	            ex.printStackTrace();
	            return null;
	        }    	
	    }
}
