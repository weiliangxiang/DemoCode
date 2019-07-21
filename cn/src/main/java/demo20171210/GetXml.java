package demo20171210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.configuration.AbstractConfiguration;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
/*<?xml version="1.0" encoding="UTF-8"?>
<Students>
	<boy>tom</boy>
	<student id="1">
		<name go="common1">lily</name>
		<age>20</age>
	</student>
	<student id="2">
		<name go="common2">lucy</name>
		<age>30</age>
	</student>
	<title>abc,cbc,bbc,bbs</title>
	<ball size="20">pingpang</ball>
</Students>
 * 
 * 
 * */
public class GetXml {
	public static void main(String[] args) throws ConfigurationException {
		// ReadXML();
		GetProperties();
	}

	public static void ReadXML() throws ConfigurationException {
		// ��ȡ�����ļ��еĵ����ֶ�
		XMLConfiguration configuration = new XMLConfiguration("config.xml");

		String boy = (configuration.getString("boy"));
		show(boy);
		// ��ȡ�ļ��е�����
		// !!!!ע���ȡ��������ݽṹ����students.name,����ֱ��name��Ҳ����students.student.name
		List<Object> namelist = configuration.getList("student.name");
		System.out.println(Arrays.toString(namelist.toArray()));

		// ������Ԫ�ػ�ȡ���ֵ <title>abc,cbc,bbc,bbs</title>
		List<Object> titlelist = configuration.getList("title");
		show(Arrays.toString(titlelist.toArray()));

		// ���ڱ�ǩԪ�ص����ԣ�����ͨ�� ��ǩ[@������]�����ķ�ʽ����ȡ
		show(configuration.getString("student[@id]"));

		// ����Ƕ�ױ�ǩ�Ļ�������ĳһ��Ļ�����ͨ�� ��ǩ��(������)�����ķ�ʽ����ȡ
		show(configuration.getString("student(1)[@id]"));

		// ���ڱ�ǩ������������ƿ�����ôȡ
		show(configuration.getString("student(0).name[@go]"));

	}

	/*
	 * ip=127.0.0.1 port=8080 sd=111 
	 * application.name = Killer App
	 * application.version = 1.6.2 
	 * application.title = ${application.name}${application.version} 
	 * con=cn-com-org-uk-edu-jp-hk
	 * keys=cn,com,org,uk,edu,jp,hk
	 */
	public static void GetProperties() throws ConfigurationException {
		// new���󲢻�ȡ�ļ���
		Configuration conf = new PropertiesConfiguration("config.properties");
		// ����ip�����ֱ��ȡ����
		String ip = conf.getString("ip");
		show(ip);
		
		 //���ָ����������Ի�ȡ����������Ҳ��ֱ�ӻ�ȡ
		String application=conf.getString("application.title");
		show(application);
		
		 //�پٸ�Configuration�ıȽ�ʵ�õķ�����,�ڶ�ȡ�����ļ���ʱ���п��������ֵ��Ӧ��ֵΪ�գ���ô���������������     
        //��Ϳ���Ϊ������Ĭ��ֵ����������������Ӿͻ���config.properties����ļ�����id��ֵ������ļ���û������id���ͻ��id����ֵΪ123     
        //�����ͱ�֤��java�İ�װ�಻�᷵�ؿ�ֵ����Ȼ���ܼܺ򵥣����Ǻܷ����ʵ�á�
//		String id=conf.getString("id", "456");
//		show(id);
		String id=conf.getString("id", "defaultid");   
        System.out.println(id);  
        
      //�����properties �ļ�������������keys=cn,com,org,uk,edu,jp,hk������������һ��ֵ���ж��Ԫ��ֵ
         List<Object> keylist=conf.getList("keys");
         show(Arrays.toString(keylist.toArray()));
         
       //���������������ϵ�ԭ���ǣ�Ĭ�Ϸָ�����Ƕ��ţ����������ļ���con��ֵ�к��ж���̺��߷ָ���������Ҫ�������÷ָ����������  
         AbstractConfiguration.setDefaultListDelimiter('-');  
         Configuration config = new PropertiesConfiguration("config.properties");  
         List<Object> cons=config.getList("con");
   
        
       

	}
	

	public static void show(Object object) {

		System.out.println(object);

	}

}
