import java.util.LinkedList;

public class Mailbox {
	
	public LinkedList<Email> email = new LinkedList<>();
	private FilterType filter;

	public void show() {
		sort();
	}
	
	private void sort() {
		int size = email.size();
		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j > i; j++) {
				if (before(email.get(j), email.get(j - 1))) {
					Email e = email.get(j - 1);
					email.set(j - 1, email.get(j));
					email.set(j, e);
				}
			}
		}
	}
	
	private Boolean before(Email m1, Email m2) {
		return filter.before(m1, m2);
	}
	
	public void setBefore(FilterType fT) {
		filter = fT;
	}
}
