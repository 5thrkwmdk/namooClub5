package com.namoo.club.dao.mongo.document;

import dom.entity.ClubManager;

public class ClubManagerDoc  {
	//
	private int clubNo;
	private SocialPersonDoc rolePerson;
	private boolean kingManager;
	
	//--------------------------------------------------------------------------
	public ClubManagerDoc() { 
		//
	}
	public ClubManagerDoc(ClubManager manager) {
		//
		this.clubNo = manager.getClubNo();
		this.rolePerson = new SocialPersonDoc(manager.getRolePerson());
		this.kingManager = manager.isKingManager();
	}
	//--------------------------------------------------------------------------
	public ClubManager createDomain() {
		//
		ClubManager clubManager = new ClubManager();
		clubManager.setClubNo(clubNo);
		clubManager.setRolePerson(rolePerson.createDomain());
		clubManager.setKingManager(kingManager);
		
		return clubManager;
	}
	//--------------------------------------------------------------------------
	public String getEmail() {
		return rolePerson.getEmail();
	}
	public String getName() {
		return rolePerson.getName();
	}
	public int getClubNo() {
		return clubNo;
	}
	public SocialPersonDoc getRolePerson() {
		return rolePerson;
	}
	public void setRolePerson(SocialPersonDoc rolePerson) {
		this.rolePerson = rolePerson;
	}
	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	public boolean isKingManager() {
		return kingManager;
	}
	public void setKingManager(boolean kingManager) {
		this.kingManager = kingManager;
	}
	//-------------------------------------------------------------------------
}
