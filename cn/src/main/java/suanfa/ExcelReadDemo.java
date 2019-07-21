package suanfa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Object[] ReadExcel(String filepath,String filename,String sheetname) throws IOException{
		//String path=System.getProperty("user.dir")+File.separator+"data"+File.separator;
		File file=new File(filepath+File.separator+filename);
		try {
			//����FileInputStream�������ڶ�ȡExcel����
			FileInputStream inputStream=new FileInputStream(file);
			//����workbook����
			Workbook workbook=new XSSFWorkbook(inputStream);
			//����sheet����
			org.apache.poi.ss.usermodel.Sheet sheet=workbook.getSheet(sheetname);
			//��������
			int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			//��������洢Excel��ȡ������
			List<Object[]> records= new ArrayList<Object[]>();
			//ʹ������forѭ������Excel�������ļ�
			for(int i=1;i<rowCount+1;i++) {
			//��ȡ�ж���
				Row row=sheet.getRow(i);
			//����һ�����飬�����洢Excel�����ļ�ÿ���е�����
				String fields[] =new String[row.getLastCellNum()];
			for(int j=0;j<row.getFirstCellNum();j++) {
				fields[j]=row.getCell(j).getStringCellValue();
			}
			records.add(fields);	
			}
			//���洢��list����ת����һ��object����
			Object[][] results= new Object[records.size()][];
			for(int i=0;i<records.size();i++) {
				results[i]=records.get(i);
			}
			return results;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
		
	}

}
