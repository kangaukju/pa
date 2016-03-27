package kr.co.projectd.matching.types;

public enum Nation {
	KOR(1<<0),
	CHA(1<<1),
	ETC(1<<2);
	private int value;
	private Nation(int value) {
		this.value = value;
	}
}
