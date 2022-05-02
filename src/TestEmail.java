import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;

public class TestEmail {

	private final Mailbox email = new Mailbox();;
	private final LinkedList<Email> messages = new LinkedList<>();
	
	public void setEmails() {
		messages.add(new Email("Antonio", "Clases", new Date(1), Priority.HIGH, 
				"Recordad que hay clase el viernes"));
		messages.add(new Email("Juan", "Cine", new Date(2), Priority.HIGH, 
				"Compra las entradas de la película para mañana"));
		messages.add(new Email("Luisa", "Partido", new Date(3), Priority.STANDARD, 
				"Vamos a ver el partido de fútbol"));
		messages.add(new Email("Rosa", "Apuntes", new Date(1), Priority.STANDARD, 
				"¿Puedes pasarme los apuntes del martes?"));
		messages.add(new Email("Zara", "Promoción", new Date(4), Priority.LOW, 
				"15% de descuento en todas las prendas"));
		messages.add(new Email("Movistar", "Oferta", new Date(2), Priority.LOW, 
				"Móvil e Internet a 3€"));
	}
	
	private LinkedList<Email> sortedEmail(FilterType filter, LinkedList<Email> email) {
		int size = email.size();
		for (int i = 0; i < size; i++) {
			for (int j = size - 1; j > i; j++) {
				if (filter.before(email.get(j), email.get(j - 1))) {
					Email e = email.get(j - 1);
					email.set(j - 1, email.get(j));
					email.set(j, e);
				}
			}
		}
		return email;
	}
	
	@Test
	public void filterDateTest() {
		email.setBefore(new BeforeDate());
		email.show();
		assertEquals(sortedEmail(new BeforeDate(), messages), email.email);
	}
	
	@Test
	public void filterPriorityTest() {
		email.setBefore(new BeforePriority());
		email.show();
		assertEquals(sortedEmail(new BeforePriority(), messages), email.email);
	}
	
}
