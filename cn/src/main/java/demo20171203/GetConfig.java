package demo20171203;

import java.util.Arrays;  
import java.util.List;  
  
import org.apache.commons.configuration.AbstractConfiguration;  
import org.apache.commons.configuration.Configuration;  
import org.apache.commons.configuration.ConfigurationException;  
import org.apache.commons.configuration.PropertiesConfiguration;  
  
public class GetConfig {  
      
    public static void main(String[] args) {  
        testReadProperties();  
    }  
      
    public static void testReadProperties(){  
        //ע��·��Ĭ��ָ�����classpath�ĸ�Ŀ¼     
        Configuration config;  
        try {  
            config = new PropertiesConfiguration("config.properties");  
            //����һ������ֱ�ӻ�ȡ����  
            String ip=config.getString("ip");     
            int port=config.getInt("port");     
              
            //���ָ����������Ի�ȡ����������Ҳ��ֱ�ӻ�ȡ  
            String title=config.getString("application.title");     
            System.out.println(ip+"\n"+port+"\n"+title);     
              
            //�پٸ�Configuration�ıȽ�ʵ�õķ�����,�ڶ�ȡ�����ļ���ʱ���п��������ֵ��Ӧ��ֵΪ�գ���ô���������������     
            //��Ϳ���Ϊ������Ĭ��ֵ����������������Ӿͻ���config.properties����ļ�����id��ֵ������ļ���û������id���ͻ��id����ֵΪ123     
            //�����ͱ�֤��java�İ�װ�಻�᷵�ؿ�ֵ����Ȼ���ܼܺ򵥣����Ǻܷ����ʵ�á�     
            String id=config.getString("id", "defaultid");   
            System.out.println(id);  
              
            //�����properties �ļ�������������keys=cn,com,org,uk,edu,jp,hk������������һ��ֵ���ж��Ԫ��ֵ     
            //��ô�������ַ���������  
            String[] keys1=config.getStringArray("keys");   
            System.out.println(Arrays.toString(keys1));  
            List<Object> keys2=config.getList("keys");    
            System.out.println(Arrays.toString(keys2.toArray()));  
              
            //���������������ϵ�ԭ���ǣ�Ĭ�Ϸָ�����Ƕ��ţ����������ļ���con��ֵ�к��ж���̺��߷ָ���������Ҫ�������÷ָ����������  
            AbstractConfiguration.setDefaultListDelimiter('-');  
            config = new PropertiesConfiguration("config.properties");  
            List<Object> cons=config.getList("con");    
            System.out.println(Arrays.toString(cons.toArray()));  
            /** 
             *  
             *  �������������� 
             *  127.0.0.1 
             *  8080 
             *  Killer App 1.6.2 
             *  defaultid 
             *  [cn, com, org, uk, edu, jp, hk] 
             *  [cn, com, org, uk, edu, jp, hk] 
             *  [cn, com, org, uk, edu, jp, hk] 
             */  
        } catch (ConfigurationException e) {  
            e.printStackTrace();  
        }     
          
    }  
}  
