package demo20171217;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class entrySetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "weiliangxiang");
		map.put("age", "23");
		map.put("sex", "boy");
		//��map��ӳ���ϵȡ����������set������
		Set<Map.Entry<String, String>> entrySet=map.entrySet();
		//�����ϵ����Map.Entry���ͣ���ô��ϵMap.Entry��ȡ���󣬾Ϳ��Ի�ȡ����ϵ�еļ�ֵ
		Iterator<Map.Entry<String, String>> it =entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> me=it.next();
			System.out.println(me.getKey()+":"+me.getValue());
		}

	}

}
