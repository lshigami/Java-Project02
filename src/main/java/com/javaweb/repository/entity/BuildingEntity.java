package com.javaweb.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "buildingEntity",fetch = FetchType.LAZY)
	List<RentAreaEntity> areaEntities = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="districtid")
	DistrictEntity districtEntity;
	
	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}
	public List<RentAreaEntity> getAreaEntities() {
		return areaEntities;
	}
	public void setAreaEntities(List<RentAreaEntity> areaEntities) {
		this.areaEntities = areaEntities;
	}
	@Column(name ="name" )
	private String name;
	
	
	@Column(name ="street")
	private String street;

	@Column(name ="ward")
	private String ward;

//	@Column(name ="districtid")
//	private String districtid;

	@Column(name ="structure")
	private String structure;

	@Column(name ="numberofbasement")
	private String numberofbasement;

	@Column(name ="floorarea")
	private String floorarea;

	@Column(name ="direction")
	private String direction;

	@Column(name ="level")
	private String level;

	@Column(name ="rentprice")
	private String rentprice;

	@Column(name ="rentpricedescription")
	private String rentpricedescription;

	@Column(name ="servicefee")
	private String servicefee;

	@Column(name ="carfee")
	private String carfee;

	@Column(name ="motorbikefee")
	private String motorbikefee;

	@Column(name ="overtimefee")
	private String overtimefee;

	@Column(name ="waterfee")
	private String waterfee;

	@Column(name ="electricityfee")
	private String electricityfee;

	@Column(name ="deposit")
	private String deposit;

	@Column(name ="payment")
	private String payment;

	@Column(name ="renttime")
	private String renttime;

	@Column(name ="decorationtime")
	private String decorationtime;

	@Column(name ="brokeragefee")
	private String brokeragefee;

	@Column(name ="note")
	private String note;

	@Column(name ="linkofbuilding")
	private String linkofbuilding;

	@Column(name ="map")
	private String map;

	@Column(name ="image")
	private String image;

	@Column(name ="createddate")
	private String createddate;

	@Column(name ="modifieddate")
	private String modifieddate;

	@Column(name ="createdby")
	private String createdby;

	@Column(name ="modifiedby")
	private String modifiedby;

	@Column(name ="managername")
	private String managername;

	@Column(name ="managerphonenumber")
	private String managerphonenumber;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
//	public String getDistrictid() {
//		return districtid;
//	}
//	public void setDistrictid(String districtid) {
//		this.districtid = districtid;
//	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getNumberofbasement() {
		return numberofbasement;
	}
	public void setNumberofbasement(String numberofbasement) {
		this.numberofbasement = numberofbasement;
	}
	public String getFloorarea() {
		return floorarea;
	}
	public void setFloorarea(String floorarea) {
		this.floorarea = floorarea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getRentprice() {
		return rentprice;
	}
	public void setRentprice(String rentprice) {
		this.rentprice = rentprice;
	}
	public String getRentpricedescription() {
		return rentpricedescription;
	}
	public void setRentpricedescription(String rentpricedescription) {
		this.rentpricedescription = rentpricedescription;
	}
	public String getServicefee() {
		return servicefee;
	}
	public void setServicefee(String servicefee) {
		this.servicefee = servicefee;
	}
	public String getCarfee() {
		return carfee;
	}
	public void setCarfee(String carfee) {
		this.carfee = carfee;
	}
	public String getMotorbikefee() {
		return motorbikefee;
	}
	public void setMotorbikefee(String motorbikefee) {
		this.motorbikefee = motorbikefee;
	}
	public String getOvertimefee() {
		return overtimefee;
	}
	public void setOvertimefee(String overtimefee) {
		this.overtimefee = overtimefee;
	}
	public String getWaterfee() {
		return waterfee;
	}
	public void setWaterfee(String waterfee) {
		this.waterfee = waterfee;
	}
	public String getElectricityfee() {
		return electricityfee;
	}
	public void setElectricityfee(String electricityfee) {
		this.electricityfee = electricityfee;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRenttime() {
		return renttime;
	}
	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}
	public String getDecorationtime() {
		return decorationtime;
	}
	public void setDecorationtime(String decorationtime) {
		this.decorationtime = decorationtime;
	}
	public String getBrokeragefee() {
		return brokeragefee;
	}
	public void setBrokeragefee(String brokeragefee) {
		this.brokeragefee = brokeragefee;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getLinkofbuilding() {
		return linkofbuilding;
	}
	public void setLinkofbuilding(String linkofbuilding) {
		this.linkofbuilding = linkofbuilding;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphonenumber() {
		return managerphonenumber;
	}
	public void setManagerphonenumber(String managerphonenumber) {
		this.managerphonenumber = managerphonenumber;
	}
	
}
