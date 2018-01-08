package com.open.android.react.modules;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class PicassoHeaderInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		// TODO Auto-generated method stub
		 Request.Builder request = chain.request().newBuilder();
//			if(encodedUrl.contains("img1.mm131.com")){
//	    		conn.setRequestProperty("Host", "img1.mm131.com");
//	    		conn.setRequestProperty("referer", "http://m.mm131.com/");
//	    		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");  
//	        }else if(encodedUrl.contains("img2.mm131.com")){
//	    		conn.setRequestProperty("Host", "img2.mm131.com");
//	    		conn.setRequestProperty("referer", "http://m.mm131.com/");
//	    		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");  
//	        }else if(encodedUrl.contains("img1.mm131.me")){
//	    		conn.setRequestProperty("Host", "img1.mm131.me");
//	    		conn.setRequestProperty("referer", "http://m.mm131.com/");
//	    		conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");  
//	        }
//			
		    request.addHeader("referer", "http://m.mm131.com/");
		    return chain.proceed(request.build());
	}

}
