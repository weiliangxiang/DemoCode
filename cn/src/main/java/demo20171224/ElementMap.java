package demo20171224;

import com.github.crab2died.annotation.ExcelField;

public class ElementMap {
	@ExcelField(title = "����")
	private String type;
	@ExcelField(title = "��ַ")
	private String url;
	@ExcelField(title = "����")
	private String params;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getParams() {
		return params;
	}
	public void setParams(String params) {
		this.params = params;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	@ExcelField(title = "ͷ��")
	private String header;
	// @ExcelField(title="���")
	// private int number;
	@Override
	public String toString() {
		return "ElementMap [type=" + type + ", url=" + url + ", params=" + params + ", header=" + header + "]";
	}

}
