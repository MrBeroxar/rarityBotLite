package rarityBot.processing;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetIfpsHttpClient {

	private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public void close() throws IOException {
        httpClient.close();
    }
    public String getImg(long l) throws Exception {
    	HttpGet request = null;
    	
    	request = new HttpGet("https://lcd.terra.dev/terra/wasm/v1beta1/contracts/terra175shn909mgs6evltmzj9d8uufu9m5lj29pyppq/store?query_msg="+Base64Encode.encodeToBase64(l));
        JSONObject jsonObject;
        String ifpsLink ="";
        try (CloseableHttpResponse response = httpClient.execute(request)) {
        	
            HttpEntity entity = response.getEntity();
            if (entity != null) {
            	
                String result = EntityUtils.toString(entity);
                jsonObject = new JSONObject(result);
                ifpsLink = "https://ipfs.io/ipfs/"+jsonObject.getJSONObject("query_result").getJSONObject("extension").get("image").toString().substring(7);
            }

        }
		return ifpsLink;
    }
}
