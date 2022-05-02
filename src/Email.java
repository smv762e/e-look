import java.util.Date;

public class Email {

	public String from;
	public String subject;
	public Date date;
	public Priority priority;
	private String text;
	
	public Email(String fm, String st, Date de, Priority py, String tt) {
		fm = from;
		st = subject;
		de = date;
		py = priority;
		tt = text;
	}
	
	public String toString() {
		return ("From: " + from + ".\n" +
				"Subject: " + subject + ".\n" +
				"Date: " + date + ".\n" +
				"Priority: " + priority + ".\n" +
				"Text: " + text);
	}
}
