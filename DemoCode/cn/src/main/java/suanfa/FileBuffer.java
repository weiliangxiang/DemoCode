package suanfa;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// WriterBufferDemo();
		BufferReadDemo();

	}

	/*
	 * �������ĳ�����Ϊ��������Ķ�дЧ�ʣ������ڴ���������֮ǰ����Ҫ�������� �û������ṩ��һ�ζ�һ�еķ�������������ı��Ļ�ȡ
	 * 
	 */
	public static void WriterBufferDemo() {
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		try {
			// ����һ���ַ�д��������
			FileWriter fw = new FileWriter(path + "buf.txt");
			// Ϊ����߶�дЧ�ʣ����뻺����������ֻ��Ҫ�����Ч�ʵ���������Ϊ�������ݸ��������Ĺ��캯������
			BufferedWriter bw = new BufferedWriter(fw);
			for (int x = 0; x < 5; x++) {
				bw.write("����bufferд��" + x);
				// ��ƽ̨�Ļ��з���������˵��newline
				bw.newLine();

			}
			// ֻҪ�õ�����������Ҫ�ǵ�ˢ��
			bw.flush();
			// ��ʵ�رջ����������ڹرջ������������󣬾Ͳ���fw.close
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void BufferReadDemo() {
		String path = System.getProperty("user.dir") + File.separator + "data" + File.separator;
		try {
			// ����һ����ȡ������ļ�����
			FileReader fw = new FileReader(path + "buf.txt");
			// Ϊ�����Ч�ʣ����뻺�弼�������ַ���ȡ��������Ϊ�������ݸ��������Ĺ������
			BufferedReader br = new BufferedReader(fw);
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
