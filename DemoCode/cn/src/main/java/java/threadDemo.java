package java;

/*1.���ָó���ÿ��ִ�еĽ������һ����Ϊʲô��
 *  ��ȷһ�㣬����̶߳���ȡcpu��ִ��Ȩ��cpuִ�е�˭��˭����ִ�У�ִ��Ȩ��cpu
 * 	��ȷһ�㣬��ĳһʱ�̣�ֻ��һ�����������У���˳��⣩��cpu�����ſ����л����Դﵽ
 * 	����ȥͬʱ���е�Ч�������ǿ�������İѶ��̵߳�������Ϊ���Ϊ�ڻ���������Դ
 * 	����Ƕ��̵߳�һ���ص㣬�����
 * 2.ΪʲôҪ����run������
 * 	Ŀ�ģ����Զ���Ĵ���洢��run�����У����߳�����
 * 	Thread�����������̣߳�����Ͷ�����һ�����ܣ����ڴ洢�߳����еĴ��룬�ô洢����
 * 	����run������Ҳ����thread���е�run���������ڴ洢�߳�Ҫ���еĴ��룬Ϊʲô����
 * 	�����main�����У��Ǿ������߳��ˣ�����
 * 	Thread t= new Thread();
	t.run()
	�������д��thread��֪������ʲôrun����
 * 	
 * 3.�����̵߳�start����
 * �÷������������ã�һ���������̣߳�һ���ǵ���run����
 * �������run���������ִ������ӷ����Ż����ִ��main�������������start������
 * �ڼ���ִ��main������ͬʱ�������µ�·��ִ���ӷ���
 * 
 * 
 * */
public class threadDemo extends Thread {

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println("demo run" + i);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		threadDemo demo = new threadDemo();
		//demo.start();//�����̲߳�ִ���̵߳�run����
		demo.run();//�����Ƕ�����÷��������̴߳����ˣ���û������
		for (int i = 0; i < 10; i++) {
			System.out.println("main run" + i);
		}
	}
	
}
