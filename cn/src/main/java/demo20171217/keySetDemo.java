package demo20171217;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class keySetDemo {
/*map���ϵ�����ȡ����ʽ��
 * 1.keySet����map�е����еļ����뵽Set�����У���ΪSet���Ͼ߱������������Կ����Ե�����ʽ
 * ȡ�����еļ����ڸ���get����ȡÿһ������Ӧ��ֵ
 * Map���ϵ�ȡ��ԭ����map����ת����set���ϣ���ͨ��������ȡ��
 * 2.entrySet����map�����е�ӳ���ϵ�浽set�����У�
 * */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "weiliangxinag");
		map.put("age", "18");
		map.put("sex", "boy");
		//�Ȼ�ȡmap�������м���set���ϣ�keyset
		Set<String> keyset=map.keySet();
		//����set���ϾͿ��Ի�ȡ��������
		Iterator<String> iterator=keyset.iterator();
		while (iterator.hasNext()) {
			String key =iterator.next();
			System.out.println(key+":"+map.get(key));
}

	}

}
