package demo20171203;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class PostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.����һ�����ӳ�
		CloseableHttpClient client=HttpClients.createDefault();
		//2.����һ��post����
		HttpPost post=new HttpPost("http://123.58.251.183:8080/goods/UserServlet");
		//7.ƴ��post�������
		List<NameValuePair> list=new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("method","loginMobile"));
		list.add(new BasicNameValuePair("loginname", "abc"));
		list.add(new BasicNameValuePair("loginpass", "abc"));
		
		try {
			//3.����post�������
			HttpEntity postEntity=new UrlEncodedFormEntity(list);
			//������ƴ�ӵ�post������
			post.setEntity(postEntity);
			//post.setHeader("", "");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//
		HttpEntity entity=null;
		//������Ӧ
		try {
			//4.ִ��post����
			CloseableHttpResponse response=client.execute(post);
			//5.��ȡʵ����
			 entity=response.getEntity();
			 //System.out.println(entity);
			//6.����ʵ����
			System.out.println(EntityUtils.toString(entity,"utf-8"));
			//��ȡ��Ӧ״̬
			//StatusLine statusLine=response.getStatusLine();
			//������Ӧ״̬��ȡ״̬��
			//System.out.println(statusLine.getStatusCode());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				EntityUtils.consume(entity);
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

	}

}
