package in.xgen.webservice;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class InvalidUser {

	public static void main(String[] args) throws ClientProtocolException, IOException{
		
		String mUrl =  "http://ip.jsontest.com/";
		
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost postMethod = new HttpPost(mUrl);
		postMethod.setHeader("User-Agent","Mozilla/5.0 (Linux; U; Android 1.0; en-us; dream) AppleWebKit/525.10+ (KHTML, like Gecko) Version/3.0.4 Mobile Safari/523.12.2");
		postMethod.setHeader("Content-Type", "application/json");
		/*System.out.println("HTTP POST : " + mUrl + " type : " + jsonObject.getString("type")
				+ " parameters : " + jsonObject.toString());*/
		
		
		
		HttpResponse response = null;
		Object obj = null;
		JSONObject jsonObject = null;
		String mailid =null;
		int action =0; 
		String mailTo= null ;

			response = httpClient.execute(postMethod);
		
		
		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}
		

		JSONParser parser = new JSONParser();

		try {
			//StringEntity se = new StringEntity(jsonObject.toString());
			//postMethod.setEntity(se);
			//System.out.println("JSON Parameters: " + jsonObject.toString());
			//postMethod.setParams(httpParams);
			//HttpResponse response = httpClient.execute(postMethod);
			System.out.println("HTTP  " + response.getStatusLine());
			// Get hold of the response entity
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				// A Simple JSON Response Read
				InputStream instream = entity.getContent();
				String result = convertStreamToString(instream);
				
				//logger.debug(" UserId = " + UserId+ " HTTP Response:"+result.trim());
				if (!result.equals("")) {
					
					 obj = parser.parse(result);
					 jsonObject = (JSONObject) obj;
					 mailid = (String) jsonObject.get("mailid");
					 action = Integer.parseInt((String)jsonObject.get("action")); 
					 mailTo = (String) jsonObject.get("mailto");
					

					
				}
			}
		} catch (Exception e) {
			System.out.println("Err Ic:" + e.getMessage());
		} finally {
			postMethod.abort();
		}

		//return json;
	}
	
	private static String convertStreamToString(InputStream is) {
		/*
		 * To convert the InputStream to String we use the
		 * BufferedReader.readLine() method. We iterate until the BufferedReader
		 * return null which means there's no more data to read. Each line will
		 * appended to a StringBuilder and returned as String.
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
}
