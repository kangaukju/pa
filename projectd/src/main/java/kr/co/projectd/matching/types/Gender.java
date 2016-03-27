package kr.co.projectd.matching.types;

public enum Gender {
	FEMALE(1<<0),
	MALE(1<<1);
	private int value;
	private Gender(int value) {
		this.value = value;
	}
}
