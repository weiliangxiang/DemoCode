package demo20171224;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class EmailDemo {
	
	public static void main(String[] args) {
//		try {
//			sendMsg();
//		} catch (EmailException e) {
//			e.printStackTrace();
//		}
		try {
			//sendMsg();
			 String path= "E:\\Users\\Administrator\\Documents\\workspace-sts-3.9.1.RELEASE\\cn\\data\\test.xls";
			sendEmailsWithAttachments(path,"���Խ��","�����");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	
	public static void sendMsg() throws EmailException {
		HtmlEmail mail = new HtmlEmail();
		String hostname  = PropertiesUtils.getString("mail.host");
		String password = PropertiesUtils.getString("mail.password");
		String username = PropertiesUtils.getString("mail.username");
	    String[] toList = PropertiesUtils.getStringArray("mail.touser");
	    String subject = PropertiesUtils.getString("mail.title");
		mail.setHostName(hostname); // �ʼ�����������
		//mail.setSmtpPort(smtpPort); // �ʼ�������smtpЭ��˿�
		mail.setAuthentication(username, password); // �����˻�
		mail.setCharset("UTF-8"); // �ʼ����ַ���

		//mail.setSSLOnConnect(true); // �Ƿ�����SSL
		//mail.setSslSmtpPort(sslSmtpPort); // �����ã�����smtpЭ���SSL�˿ں�
 
		mail.setFrom(username); // �����˵�ַ
		for (String to : toList) {
			mail.addTo(to); // �ռ��˵�ַ���������ö��
		}
		
		mail.setSubject(subject); // �ʼ�����  
		mail.setHtmlMsg("test"); // �ʼ�����  
		String rString = mail.send(); // �����ʼ�  
		System.out.println(rString);
	}
	 public static void sendEmailsWithAttachments(String filepath,String title, String context) throws EmailException {
	        // Create the attachment
		  
	        EmailAttachment attachment = new EmailAttachment();
	        attachment.setPath(filepath);
	        attachment.setDisposition(EmailAttachment.ATTACHMENT);
	        attachment.setDescription("���Խ��");
	        attachment.setName("excel.xlsx");

	        String hostname  = PropertiesUtils.getString("mail.host");
			String password = PropertiesUtils.getString("mail.password");
			String username = PropertiesUtils.getString("mail.username");
		    String[] toList = PropertiesUtils.getStringArray("mail.touser");
		    
	        // Create the email message
		    HtmlEmail email = new HtmlEmail();
	        email.setHostName(hostname); // �ʼ�����������
			//mail.setSmtpPort(smtpPort); // �ʼ�������smtpЭ��˿�
	        email.setAuthentication(username, password); // �����˻�
	        email.setCharset("UTF-8"); // �ʼ����ַ���

			//mail.setSSLOnConnect(true); // �Ƿ�����SSL
			//mail.setSslSmtpPort(sslSmtpPort); // �����ã�����smtpЭ���SSL�˿ں�
	        email.setSubject(title);
	        email.setFrom(username); // �����˵�ַ
	        email.setHtmlMsg("<a font=red>�鿴����</a>");
	        
	        for (String to : toList) {
	        	email.addTo(to); // �ռ��˵�ַ���������ö��
			}
	        
	        // add the attachment
	        email.attach(attachment);

	        // send the email
	        email.send();
	    }


}
