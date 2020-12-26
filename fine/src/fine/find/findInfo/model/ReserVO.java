package fine.find.findInfo.model;
//RESERCATION_NO   NOT NULL CHAR(6)        
//DESERTIONNO               NUMBER         
//ID                        VARCHAR2(15)   
//CARE_NO                   VARCHAR2(2000) 
//RESERVATION_DATE NOT NULL VARCHAR2(20) 
public class ReserVO {
private String resercationNo;
private int desertionNo;
private String id;
private String reservationDate;
private String careNo;
public String getResercationNo() {
	return resercationNo;
}
public void setResercationNo(String resercationNo) {
	this.resercationNo = resercationNo;
}
public int getDesertionNo() {
	return desertionNo;
}
public void setDesertionNo(int desertionNo) {
	this.desertionNo = desertionNo;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getReservationDate() {
	return reservationDate;
}
public void setReservationDate(String reservationDate) {
	this.reservationDate = reservationDate;
}

public String getCareNo() {
	return careNo;
}
public void setCareNo(String careNo) {
	this.careNo = careNo;
}
@Override
public String toString() {
	return "ReserVO [resercationNo=" + resercationNo + ", desertionNo=" + desertionNo + ", id=" + id
			+ ", reservationDate=" + reservationDate + "]";
}


}
