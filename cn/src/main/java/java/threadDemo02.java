package java;

public class threadDemo02 extends Thread {
//��ϰ�����������߳������߳̽�������
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println("���߳�"+Thread.currentThread().getName().toString());
		}
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadDemo02 t2 = new threadDemo02();
		threadDemo02 t3 = new threadDemo02();
		t2.start();
		t3.start();
		//t2.run();
		//t3.run();//˳��ִ��
		/*���ʹ��run������û�����⣬���ǳ���һ�����⣬�������run����ִ��ʱ�������
		 * ����runִ��6��Σ���ô���t2û��������ɣ���ôt3Ҳ�Ͳ������У����ʹ������
		 * �����Ŀ��Ƶ�Ԫ����ô�Ϳ���ʵ��ͬʱ���У���߹���Ч�� 
		 * */
		for(int i=0;i<10;i++){
			System.out.println("������main����");
		}

	}

}
