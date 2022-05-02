
public class BeforeDate implements FilterType{

	@Override
	public boolean before(Email m1, Email m2) {
		return (m1.date.after(m2.date));
	}

}
