package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class MatchingSelectVO implements Serializable {
	private List	kind = new ArrayList();
	private String	size;
	private String	color;
	private String	sex;

	public MatchingSelectVO() {
		super();
	}

	public MatchingSelectVO(List kind, String size, String color, String sex) {
		super();
		this.kind = kind;
		this.size = size;
		this.color = color;
		this.sex = sex;
	}

	public List getKind() {
		return kind;
	}

	public void setKind(List kind) {
		this.kind = kind;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
} 