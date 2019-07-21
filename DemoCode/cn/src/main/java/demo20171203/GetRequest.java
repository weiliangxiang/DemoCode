package demo20171203;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
//��url�ķ�ʽ����
public class GetRequest {
public static void main(String[] args) {
	/*
	 * */
	  //���������
	  CloseableHttpClient httpClient=HttpClients.createDefault();
	  //����ĳ������
	  HttpGet get=new HttpGet("https://www.baidu.com/");
	  HttpEntity entity=null;
	try {
		//���õ�һ�������õ�ʵ��
		CloseableHttpResponse response=httpClient.execute(get);
		//����ʵ���еķ���
		entity=response.getEntity();
		StatusLine statusLine= response.getStatusLine();
		int code=statusLine.getStatusCode();
		System.out.println(code);
		String result=EntityUtils.toString(entity);
		//System.out.println(result);
		
	} catch (ClientProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			//����ʵ���ͷ�
			EntityUtils.consume(entity);
			//�ͷ����ӳ�
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
  

}

