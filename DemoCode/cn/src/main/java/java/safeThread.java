package java;



public class safeThread implements Runnable {
	private int ticket=10;
	Object object = new Object();
	/*
	 * �̰߳�ȫ���� 100��Ʊ���ĸ�����Ʊ����ʣ��Ʊ��Ϊһ��ʱ��A�û������ж�Ʊ���Ƿ�Ϊ0���жϣ����
	 * �ж�Ϊ�棬��ʱ��߱���ִ��Ȩ������cpu����һ˲����ȥִ��B�û����߳��ˣ��ж��Ƿ�
	 * ����0��Ϊ�棬����״̬����ʱ�����cpu�л�����C�û����ж��Ƿ����0��ͬ�ϣ��ͻ�� ��Ʊ��Ϊ���������
	 * ����ԭ��
	 * ����������ڲ���ͬһ���̹߳�������ʱ��һ���̶߳Զ������ִֻ����һ���֣���һ���߳�
	 * �������ִ�У����¹������ݵĴ���
	 * ����취��
	 * 		�Զ��������������ݵ���䣬ֻ����һ���̶߳�ִ���꣬��ִ�й����������߳�
	 * 		�����Բ���ִ��
	 * Java���ڶ��̵߳İ�ȫ�����ṩ��רҵ�Ľ����ʽ������ͬ�������
	 * ����ж�����������ͬ�����룬���ǿ���������ʹ�õ��˹�������
	 * 		��synchronized��ͬһʱ��ֻ����һ���߳���ִ�У����ǰ�obj��������ֻ������
	 * �ڵ��̲߳���ִ�У�������ĳ���ʹ��ȡ��cpu��ִ��ȨҲ����ȥ����Ϊû�л�ȡ��
	 * synchronized���Լ򵥵����Ϊ���ϵ�������Ŀ������ã��û�����֮ǰ���Ȼ��ж�
	 * �Ƿ����ˣ����������wait������ж���û�ˣ��ͽ��룬�����ͱ�֤��ͬһʱ��ֻ��һ��
	 * �û����ϲ��������ǰ�������½������ϵ�������
	 * ͬ����ǰ��
	 * 			����Ҫ�����������������ϵ��̲߳���Ҫͬ��
	 * 			�����Ƕ���߳�ʹ��ͬһ����
	 * 			���뱣֤ͬ����ֻ��һ���߳�������
	 * �ô���������̵߳İ�ȫ����
	 * �׶ˣ�����̶߳���Ҫ���жϣ������˴�������Դ
	 * @param args
	 */
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			synchronized (object) {//ͬ��δ�ɹ�
				if (ticket>0) {
					try {
						Thread.sleep(10);
						
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println(Thread.currentThread().getName().toString()+"***"+ticket--);
				}
			}
		
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		safeThread sf = new safeThread();
		Thread t1 = new Thread(sf);
		Thread t2 = new Thread(sf);
		Thread t3 = new Thread(sf);
		Thread t4 = new Thread(sf);
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
