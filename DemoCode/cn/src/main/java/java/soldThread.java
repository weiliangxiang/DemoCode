package java;
/*������Ʊ��С����
 * ������ڿ�ͬʱ��Ʊ
 * 
 * 
 * */
public class soldThread extends Thread {
	//int  ticket=20;����������Ļ����߳�1��100��Ʊ���߳�2Ҳ��һ����Ʊ����ν�����������
		private  static int ticket=20;

	public void run() {
		// TODO Auto-generated method stub
	
		while (true) {
			if (ticket>0) {
				
				System.out.println(Thread.currentThread().getName().toString()+"������Ʊ"+ticket--);
			}
			
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			soldThread ST = new soldThread();
			ST.start();
		}

	}

}
