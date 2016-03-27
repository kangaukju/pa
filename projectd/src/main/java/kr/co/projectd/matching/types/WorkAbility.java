package kr.co.projectd.matching.types;

public class WorkAbility {
	
	static public enum Ability {
		SERVING(1<<0),
		KITCHEN(1<<1),
		ASSIST(1<<2);
		private int value;
		private Ability(int value) {
			this.value = value;
		}
	}
	/**
	 * WorkAbility value
	 */
	private int value;
	
	public WorkAbility(int value) {
		this.value = value;
	}
	public WorkAbility() {
		this(0);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (Ability ability : Ability.values()) {
			if ((ability.value & value) == ability.value) {
				sb.append(" "+ability.name());
			}
		}
		return sb.toString();
	}
}
