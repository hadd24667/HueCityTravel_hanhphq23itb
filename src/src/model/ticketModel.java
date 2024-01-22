package model;

import java.time.LocalDate;

public class ticketModel {
private String relicsName;
private String userName;
private int personQuantity;
private LocalDate visitDate;
private String tourID;
public ticketModel(String relicsName, String userName, int personQuantity, LocalDate visitDate, String tourID) {
	super();
	this.relicsName = relicsName;
	this.userName = userName;
	this.personQuantity = personQuantity;
	this.visitDate = visitDate;
	this.tourID = tourID;
}
public String getRelicsName() {
	return relicsName;
}
public void setRelicsName(String relicsName) {
	this.relicsName = relicsName;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public int getPersonQuantity() {
	return personQuantity;
}
public void setPersonQuantity(int personQuantity) {
	this.personQuantity = personQuantity;
}
public LocalDate getVisitDate() {
	return visitDate;
}
public void setVisitDate(LocalDate visitDate) {
	this.visitDate = visitDate;
}
public String getTourID() {
	return tourID;
}
public void setTourID(String tourID) {
	this.tourID = tourID;
}

}
