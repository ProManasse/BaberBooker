package com.example.barberbooker.domain;

public class Salon {
    private Integer salon_id;
    private String salon_name;
    private Double latitude;
    private Double longitude;
    private String salon_status;

	public Integer getSalon_id() {
		return salon_id;
	}
	public void setSalon_id(Integer salon_id) {
		this.salon_id = salon_id;
	}
	public String getSalon_name() {
		return salon_name;
	}
	public void setSalon_name(String salon_name) {
		this.salon_name = salon_name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public String getSalon_status() {
		return salon_status;
	}
	public void setSalon_status(String salon_status) {
		this.salon_status = salon_status;
	}
}
