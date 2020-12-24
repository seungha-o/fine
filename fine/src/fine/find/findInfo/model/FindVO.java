package fine.find.findInfo.model;

public class FindVO {
	private String desertionNo; //유기견번호
	private String happenPlace; // 유기날짜
	private String age; // 나이
	private String careAddr; // 보호소 번호
	private String careNm; // 보호소 이름
	private String careTel; // 보호소 전화번호
	private String colorCd; //
	private String filename;
	private String happenDt;
	private String kindCd;
	private String neuterYn; 
	private String noticeEdt;
	private String noticeSdt;
	private String officetel;
	private String orgNm;
	private String popfile;
	private String processState; 
	private String sexCd;
	private String specialMark; 
	private String weight;
	public String getDesertionNo() {
		return desertionNo;
	}
	public void setDesertionNo(String desertionNo) {
		this.desertionNo = desertionNo;
	}
	public String getHappenPlace() {
		return happenPlace;
	}
	public void setHappenPlace(String happenPlace) {
		this.happenPlace = happenPlace;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCareAddr() {
		return careAddr;
	}
	public void setCareAddr(String careAddr) {
		this.careAddr = careAddr;
	}
	public String getCareNm() {
		return careNm;
	}
	public void setCareNm(String careNm) {
		this.careNm = careNm;
	}
	public String getCareTel() {
		return careTel;
	}
	public void setCareTel(String careTel) {
		this.careTel = careTel;
	}
	public String getColorCd() {
		return colorCd;
	}
	public void setColorCd(String colorCd) {
		this.colorCd = colorCd;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getHappenDt() {
		return happenDt;
	}
	public void setHappenDt(String happenDt) {
		this.happenDt = happenDt;
	}
	public String getKindCd() {
		return kindCd;
	}
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}
	public String getNeuterYn() {
		return neuterYn;
	}
	public void setNeuterYn(String neuterYn) {
		this.neuterYn = neuterYn;
	}
	public String getNoticeEdt() {
		return noticeEdt;
	}
	public void setNoticeEdt(String noticeEdt) {
		this.noticeEdt = noticeEdt;
	}
	public String getNoticeSdt() {
		return noticeSdt;
	}
	public void setNoticeSdt(String noticeSdt) {
		this.noticeSdt = noticeSdt;
	}
	public String getOfficetel() {
		return officetel;
	}
	public void setOfficetel(String officetel) {
		this.officetel = officetel;
	}
	public String getOrgNm() {
		return orgNm;
	}
	public void setOrgNm(String orgNm) {
		this.orgNm = orgNm;
	}
	public String getPopfile() {
		return popfile;
	}
	public void setPopfile(String popfile) {
		this.popfile = popfile;
	}
	public String getProcessState() {
		return processState;
	}
	public void setProcessState(String processState) {
		this.processState = processState;
	}
	public String getSexCd() {
		return sexCd;
	}
	public void setSexCd(String sexCd) {
		this.sexCd = sexCd;
	}
	public String getSpecialMark() {
		return specialMark;
	}
	public void setSpecialMark(String specialMark) {
		this.specialMark = specialMark;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	@Override
	public String toString() {
		return "FindVO [desertionNo=" + desertionNo + ", happenPlace=" + happenPlace + ", age=" + age + ", careAddr="
				+ careAddr + ", careNm=" + careNm + ", careTel=" + careTel + ", colorCd=" + colorCd + ", filename="
				+ filename + ", happenDt=" + happenDt + ", kindCd=" + kindCd + ", neuterYn=" + neuterYn + ", noticeEdt="
				+ noticeEdt + ", noticeSdt=" + noticeSdt + ", officetel=" + officetel + ", orgNm=" + orgNm
				+ ", popfile=" + popfile + ", processState=" + processState + ", sexCd=" + sexCd + ", specialMark="
				+ specialMark + ", weight=" + weight + "]";
	}
}
