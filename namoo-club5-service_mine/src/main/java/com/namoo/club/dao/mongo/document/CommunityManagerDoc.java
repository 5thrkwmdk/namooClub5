package com.namoo.club.dao.mongo.document;

import dom.entity.CommunityManager;

public class CommunityManagerDoc {
	//
	private int communityNo;
	private SocialPersonDoc rolePerson;
	//--------------------------------------------------------------------------
	// constructor
	public CommunityManagerDoc() {
		//
	}
	public CommunityManagerDoc(CommunityManager comManager){
		//
		this.communityNo = comManager.getCommunityNo();
		this.rolePerson = new SocialPersonDoc(comManager.getRolePerson());
	}
	//--------------------------------------------------------------------------
	public CommunityManager createDomain() {
		CommunityManager comManager = new CommunityManager();
		comManager.setCommunityNo(communityNo);
		comManager.setRolePerson(rolePerson.createDomain());
		
		return comManager;
	}
	//--------------------------------------------------------------------------
	// getter/setter
	public String getName() {
		return rolePerson.getName();
	}
	public String getEmail() {
		return rolePerson.getEmail();
	}
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
}