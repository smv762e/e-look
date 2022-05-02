
public class BeforePriority implements FilterType{

	@Override
	public boolean before(Email m1, Email m2) {
		return (m1.priority.ordinal() < m2.priority.ordinal());
	}

}
