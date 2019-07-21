package demo20171217;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.mail.internet.MimeMultipart;

import org.apache.commons.collections4.Get;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.poi.util.SystemOutLogger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class HttpUtilsFan {
	private static CloseableHttpClient httpclient;
	static {
		PoolingHttpClientConnectionManager manager = new PoolingHttpClientConnectionManager();
		manager.setMaxTotal(200); // ���ӳ���󲢷�������
		manager.setDefaultMaxPerRoute(200);// ��·����󲢷���,·���Ƕ�maxTotal��ϸ��
		httpclient = HttpClients.custom().setConnectionManager(manager).build();
	}
	/*
	 * ConnectionRequestTimeout httpclientʹ�����ӳ����������ӣ����ʱ����Ǵ����ӳػ�ȡ���ӵĳ�ʱʱ�䣬�������������ݿ����ӳ�
	 * ConnectTimeout �����������ʱ�� SocketTimeout ���ݴ�����������ݰ�֮���������ʱ�� HttpHost ����
	 */
	private static RequestConfig config = RequestConfig.copy(RequestConfig.DEFAULT).setSocketTimeout(10000)
			.setConnectTimeout(5000).setConnectionRequestTimeout(100).build();
	// .setProxy(new HttpHost("127.0.0.1", 8888, "http")).build();
	
	

	public  String doGet(String url,Map<String, String> parms,Map<String, String> header) throws IOException {
		String result=null;
		HttpEntity geEntity=null;
		/**/
		//����һ��Get���󷽷�
		HttpGet httpGet=new HttpGet(url);
		httpGet.getConfig();
		//�������ͷ
		//httpGet.setHeader("key","values");
		//ִ��Get����
		try {
			HttpResponse getResponse =httpclient.execute(httpGet);
			//��ȡ��Ӧʵ��
			geEntity=getResponse.getEntity();
			//��ӡ��Ӧʵ������
			 result= EntityUtils.toString(geEntity);
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			EntityUtils.consume(geEntity);
			httpclient.close();
		}
		
		return result;
		
	}
	//���أ�û��header��get����
	public  String doGet(String url,Map<String, String> parms) {
		String result=null;
		try {
			 result= doGet(url, parms, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//���أ�ֻ�и�url����
	public  String doGet(String url) {
		String result=null;
		try {
			 result= doGet(url, null, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static String doPost(String url,Map<String, String>params,Map<String, String> header) throws ClientProtocolException, IOException {
		String postresult;
		//����post����
		HttpPost httpPost=new HttpPost(url);
		//���header
		httpPost.addHeader("key","vales");
		//���params
		List<NameValuePair> param = new ArrayList<NameValuePair>();
		for(Map.Entry<String, String> entry:params.entrySet()) {
			param.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
		}
		UrlEncodedFormEntity post_post_entity=new UrlEncodedFormEntity(param);
		httpPost.setEntity(post_post_entity);
		//
		CloseableHttpResponse postResponse=httpclient.execute(httpPost);
		
		//��ȡ��Ӧʵ��
		HttpEntity post_response_entity=postResponse.getEntity();
		System.out.println(postResponse.getStatusLine().getStatusCode());
		//����Ӧʵ��ת����String���Ͳ���ӡ
		postresult=EntityUtils.toString(post_response_entity);
		return postresult;
		
	}
	public static String doPost(String url,Map<String, String>params) {
		String result=null;
		try {
			result= doPost(url, params, null);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public static String doPostJson(String url,String JsonParam,Map<String, String> header) throws ClientProtocolException, IOException {
		String postresult;
		//����post����
		HttpPost httpPost=new HttpPost(url);
		//���params
		StringEntity JsonEntity=new StringEntity(JsonParam);
		JsonEntity.setContentEncoding("UTF-8");
		JsonEntity.setContentType("application/json");
		httpPost.setEntity(JsonEntity);
		//
		CloseableHttpResponse postResponse=httpclient.execute(httpPost);
		//��ȡ��Ӧʵ��
		HttpEntity post_response_entity=postResponse.getEntity();
		System.out.println(postResponse.getStatusLine().getStatusCode());
		//����Ӧʵ��ת����String���Ͳ���ӡ
		postresult=EntityUtils.toString(post_response_entity);
		return postresult;
		
	}	public static String doupload(String url,Map<String, String> params,Map<String, String> header,File file) throws ClientProtocolException, IOException {
		String postresult;
		//����post����
		HttpPost httpPost=new HttpPost(url);
		//���params
		//StringEntity JsonEntity=new StringEntity(JsonParam);
		MultipartEntityBuilder mEntityBuilder= MultipartEntityBuilder.create();
		mEntityBuilder.addBinaryBody("file", file);
		httpPost.setEntity(mEntityBuilder.build());
		//
		CloseableHttpResponse postResponse=httpclient.execute(httpPost);
		//��ȡ��Ӧʵ��
		HttpEntity post_response_entity=postResponse.getEntity();
		System.out.println(postResponse.getStatusLine().getStatusCode());
		//����Ӧʵ��ת����String���Ͳ���ӡ
		postresult=EntityUtils.toString(post_response_entity);
		return postresult;
		
	}
	

	


	public static void main(String[] args) throws ClientProtocolException, IOException {
		/*����get����*/
//		String string = doGet("http://59.110.139.20:8080/goods/UserServlet?method=loginMobile&loginname=abc&loginpass=abc",null,null);
//		System.out.println(string);
		/*����post������*/
//		Map<String, String> param=new HashMap<String, String>();
//		param.put("method","loginMobile");
//		param.put("loginname","abc");
//		param.put("loginpass","abc");
//		String string =doPost("http://59.110.139.20:8080/goods/UserServlet?", param, null);
//		System.out.println(string);
		/*����Jsonpost����*/
//		String url="http://123.58.251.183:8080/goods/json2";
//		//��Ӳ���
//		Map<String, String> mapjson=new HashMap<String, String>();
//		mapjson.put("count","2");
//		String JsonParam=JSON.toJSONString(mapjson);
//		//���header
//		Map<String, String> header=new HashMap<String, String>();
//		header.put("token","61b3590090982a0185dda9d3bd793b46");
//		String resultJosn=doPostJson(url, JsonParam, header);
//		System.out.println(resultJosn);
		//--------------------------����postfile����-------------------------
		String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File file=new File(path+"api.txt");
		String string=doupload("http://59.110.139.20:8080/FileSever/upload.do", null, null, file);
		System.out.println(string);
	}

}
