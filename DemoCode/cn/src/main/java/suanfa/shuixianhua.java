package suanfa;
/*
 * ������3��   ��Ŀ����ӡ�����е� ˮ�ɻ��� ����ν ˮ�ɻ��� ��ָһ����λ�������λ���������͵��ڸ�������
 * ���磺153��һ�� ˮ�ɻ��� ����Ϊ153=1�����η���5�����η���3�����η�
 * 100-999
 * 
 * */

public class shuixianhua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=100;i<1000;i++) {
			int baiwei=i/100;
			int shiwei=i%100/10;
			int gewei=i%10;
			if (baiwei*baiwei*baiwei+shiwei*shiwei*shiwei+gewei*gewei*gewei==i) {
				System.out.println(i);
			}
		}

	}
	

}
