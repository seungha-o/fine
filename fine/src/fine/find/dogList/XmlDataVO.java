package fine.find.dogList;



public class XmlDataVO {
	private String desertionNo;
	private String happenPlace;
	private String age;
	private String careAddr;
	private String careNm; 
	private String careTel; 
	private String colorCd; 
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
	
	public XmlDataVO(String desertionNo, String happenPlace, String age, String careAddr, String careNm, String careTel, 
			String colorCd, String filename, String happenDt, String kindCd, String neuterYn, String noticeEdt,
			String noticeSdt, String officetel, String orgNm, String popfile, String processState, String sexCd,
			String specialMark, String weight) {
		super();
		this.desertionNo = desertionNo;
		this.happenPlace = happenPlace;
		this.age = age;
		this.careAddr = careAddr;		
		this.careNm = careNm;
		this.careTel = careTel;
		this.colorCd = colorCd;
		this.filename = filename;
		this.happenDt = happenDt;
		this.kindCd = kindCd;
		this.neuterYn = neuterYn;
		this.noticeEdt = noticeEdt;
		this.noticeSdt = noticeSdt;
		this.officetel = officetel;
		this.orgNm = orgNm;
		this.popfile = popfile;
		this.processState = processState;
		this.sexCd = sexCd;
		this.specialMark = specialMark;
		this.weight = weight;
	}
	
	public XmlDataVO() {
		// TODO Auto-generated constructor stub
	}

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
		return "XmlDataVO [desertionNo=" + desertionNo + ", happenPlace=" + happenPlace + ", age=" + age + ", careAddr="
				+ careAddr + ", careNm=" + careNm + ", careTel=" + careTel + ", colorCd=" + colorCd + ", filename="
				+ filename + ", happenDt=" + happenDt + ", kindCd=" + kindCd + ", neuterYn=" + neuterYn + ", noticeEdt="
				+ noticeEdt + ", noticeSdt=" + noticeSdt + ", officetel=" + officetel + ", orgNm=" + orgNm
				+ ", popfile=" + popfile + ", processState=" + processState + ", sexCd=" + sexCd + ", specialMark="
				+ specialMark + ", weight=" + weight + "]";
	}

	



	

//품종관련
//	private String dog_kind_no;
//	private String kind;
//	public XmlDataVO(String dog_kind_no, String kind) {
//		super();
//		this.dog_kind_no = dog_kind_no;
//		this.kind = kind;
//	}
//	public String getDog_kind_no() {
//		return dog_kind_no;
//	}
//	public void setDog_kind_no(String dog_kind_no) {
//		this.dog_kind_no = dog_kind_no;
//	}
//	public String getKind() {
//		return kind;
//	}
//	public void setKind(String kind) {
//		this.kind = kind;
//	}
//	@Override
//	public String toString() {
//		return "XmlDataVO [dog_kind_no=" + dog_kind_no + ", kind=" + kind + "]";
//	}
//	

}
