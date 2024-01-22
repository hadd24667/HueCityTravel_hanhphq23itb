package model;

public class relicsModel {
    private String name;
    private String location;
    private String describe;
    private double price;
    private double rate;
    private byte[] image;
	public relicsModel(String name, String location, String describe, double price, double rate, byte[] image) {
		this.name = name;
		this.location = location;
		this.describe = describe;
		this.price = price;
		this.rate = rate;
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
    
}
