package demo20171217;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import com.alibaba.fastjson.JSON;
public class HttpUtils {
	//�����ļ�
	private static PoolingHttpClientConnectionManager connMgr;
	private static RequestConfig requestConfig;
	private static final int MAX_TIMEOUT = 7000;
	static {
		// �������ӳ�
		connMgr = new PoolingHttpClientConnectionManager();
		// �������ӳش�С
		connMgr.setMaxTotal(100);
		connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());

		RequestConfig.Builder configBuilder = RequestConfig.custom();
		// �������ӳ�ʱ
		configBuilder.setConnectTimeout(MAX_TIMEOUT);
		// ���ö�ȡ��ʱ
		configBuilder.setSocketTimeout(MAX_TIMEOUT);
		// ���ô����ӳػ�ȡ����ʵ���ĳ�ʱ
		configBuilder.setConnectionRequestTimeout(MAX_TIMEOUT);
		// ���ύ����֮ǰ ���������Ƿ����
		// configBuilder.setStaleConnectionCheckEnabled(true);
		requestConfig = configBuilder.build();
	}
	//���������
	public static void main(String[] args) throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> params=new HashMap<String,Object>();
		params.put("method", "loginMobile");
		params.put("loginname", "abc");
		params.put("loginpass", "abc");
		String reString=doGet("http://59.110.139.20:8080/goods/UserServlet", params);
		System.out.println(reString);
	}



	public static String doGet(String url, Map<String, Object> params) throws ClientProtocolException, IOException {
		String apiurl = url;
		StringBuffer param = new StringBuffer();
		int i = 0;
		for (String key : params.keySet()) {
			if (i == 0) {
				param.append("?");
			} else {
				param.append("&");
			}
			param.append(key).append("=").append(params.get(key));
			i++;

		}
		apiurl += param;
		String result = null;
		// �������ӳ�
		CloseableHttpClient getclient =HttpClients.createDefault();
		// get����
		HttpGet httpGet = new HttpGet(apiurl);
		// ��ȡget�����Response
		HttpResponse getRespone = getclient.execute(httpGet);
		// ��ȡresponse��״̬
		int getstatus = getRespone.getStatusLine().getStatusCode();
		//System.out.println("Respone��״̬��Ϊ" + getstatus);
		// ����responseʵ��
		HttpEntity entity = getRespone.getEntity();
//		System.out.println("��ȡentity��ֵ" + entity);
//		System.out.println(entity.getContent());
		// ��ʵ������ж�
		if (null != entity) {
			InputStream inputStream = entity.getContent();
//			System.out.println("ʵ���inputStream=" + inputStream);
			result = IOUtils.toString(inputStream, "UTF-8");
			

		}
		return result;

	}

}
