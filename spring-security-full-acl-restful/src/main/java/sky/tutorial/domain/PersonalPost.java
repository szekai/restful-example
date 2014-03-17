package sky.tutorial.domain;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A simple POJO representing personal posts
 */
@XmlRootElement
public class PersonalPost implements Post {
	private Long id;
	private Date date;
	private String message;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
