package internalAssessment;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CallRequests 
{
	OkHttpClient client = new OkHttpClient();
	
	String makerequest (String url) throws IOException
	{
		Request re = new Request.Builder().url(url).build();
		
		Response res = client.newCall(re).execute();
		
		return res.body().string();
	}
}
