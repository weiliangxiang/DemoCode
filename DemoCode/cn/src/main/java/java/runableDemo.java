package java;
/*���裺
 * 1.������ʵ��runnable�ӿ�
 * 2.����runnable�ӿڵ�run����
 * 	���߳�Ҫ���еĴ�������run������
 * 3.ͨ��thread�ཨ������
 * 4.��runnable�ӿڵ����������Ϊʵ�ʲ������ݸ�thread��Ĺ��캯��
 * 		ΪʲôҪ��runnable�ӿڵ�������󴫵ݸ�thread���캯��
 * 		��Ϊ�Զ����run����������������runnable�ӿڵ������������Ҫ���߳�ȥִ��ָ�������
 * 		run�������ͱ���Ҫ��ȷ��run���������Ķ���
 * 5.����thread��start���������̲߳�����runnable�ӿ������run����
 * thread��runnableʵ�ֵķ�ʽ��ʲô�����أ�
 *    ʵ�ַ�ʽ�ô����ڱ����˵��̳еľ����ԣ��ڶ����߳�ʱ������ʹ��ʵ�ַ�ʽ
 *    �̳�thread�̴߳����λ�ô����Thread����run�����У�ʵ��runnable����ڽӿڵ������run������
 * 
 * */
 public class runableDemo implements Runnable{
	 private int ticket=100;
	 public void run() {
			while (true) {
				if (ticket>0) {
					System.out.println(Thread.currentThread().getName().toString()+ticket--);
				}
			}
			
		}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		runableDemo rd = new runableDemo();
		Thread t1 = new Thread(rd);
		Thread t2 = new Thread(rd);
		t1.start();
		t2.start();
	}

	

}
