package java;

/*ͬ������12
 * 
 * 
 * */
public class safeThread03 implements Runnable {
	private int ticket = 10;

	public void run() {
		//public synchronized void run() ���ֱ�Ӽ�ͬ����������ôͬʱֻ��һ���߳�A�����У���������Ժ��˳�����
		// �����̲߳���ִ�У���ô��ν���أ���Ҫͬ���Ĵ����װ��һ����������
		// TODO Auto-generated method stub
		while (true) {
			show();
		}

	}

	public synchronized void show() {

		if (ticket > 0) {
			try {
				Thread.sleep(10);
				System.out.println(Thread.currentThread().getName().toString()
						+ "***" + ticket--);
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		safeThread03 sf3 = new safeThread03();
		Thread A1 = new Thread(sf3);
		Thread A2 = new Thread(sf3);
		A1.start();
		A2.start();

	}

}
