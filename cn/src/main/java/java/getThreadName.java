package java;
//��ϰ����ȡ�߳�����
//��ϰ������Զ����߳�����
public class getThreadName extends Thread{
	
/*�̶߳����Լ���Ĭ�����ƣ�Thread-���
 * currentThread����ȡ��ǰ�̶߳���
 * getName����ȡ�߳�����
 * setName�������߳�����
 * 
 * 
 * */
	public void run() {
		// TODO Auto-generated method stub
		String string = Thread.currentThread().getName().toString();
		System.out.println(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<10;i++){
			getThreadName getname= new getThreadName();
			getname.start();
		}

	}

}
