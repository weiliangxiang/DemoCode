package java;
/*ͬ������
 * 
 * 
 * */
public class safeThread02 implements Runnable {
	private int ticket=10;

	public synchronized void run() {
		//���ֱ�Ӽ�ͬ����������ôͬʱֻ��һ���߳�A�����У���������Ժ��˳�����
		//�����̲߳���ִ�У���ô��ν���أ���Ҫͬ���Ĵ����װ��һ����������
		//��safeThread03
		// TODO Auto-generated method stub
		while (true) {
			if (ticket>0) {
				try {
					Thread.sleep(10);
					System.out.println(Thread.currentThread().getName().toString()+"***"+ticket--);
				
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		safeThread02 sf2=new safeThread02();
		Thread A1=new Thread(sf2);
		Thread A2=new Thread(sf2);
		A1.start();A2.start();
		

	}

}
