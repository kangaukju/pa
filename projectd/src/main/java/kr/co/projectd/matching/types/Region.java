package kr.co.projectd.matching.types;

public class Region {
	private int id; // 지역 primary key
	private int sidoId; // 시/도 번호
	private String sidoName; // 시/도 이름
	private int sigunguId; // 시/군/구 번호
	private String sigunguName; // 시/군/구 이름
	
	public Region() {
	}
	public Region(Region region) {
		this.id = region.id;
		this.sidoId = region.sidoId;
		this.sidoName = region.sidoName;
		this.sigunguId = region.sigunguId;
		this.sigunguName = region.sigunguName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSidoId() {
		return sidoId;
	}
	public void setSidoId(int sidoId) {
		this.sidoId = sidoId;
	}
	public String getSidoName() {
		return sidoName;
	}
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	public int getSigunguId() {
		return sigunguId;
	}
	public void setSigunguId(int sigunguId) {
		this.sigunguId = sigunguId;
	}
	public String getSigunguName() {
		return sigunguName;
	}
	public void setSigunguName(String sigunguName) {
		this.sigunguName = sigunguName;
	}
}
