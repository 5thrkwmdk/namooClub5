package com.namoo.club.dao.mongo.document;

import dom.entity.CommunityMember;

public class CommunityMemberDoc {
	//
	private int communityNo;
	private SocialPersonDoc rolePerson;
	//--------------------------------------------------------------------------
	// constructor
	public CommunityMemberDoc() {
		//
	}
	public CommunityMemberDoc(CommunityMember comMember){
		//
		this.communityNo = comMember.getCommunityNo();
		this.rolePerson = new SocialPersonDoc(comMember.getRolePerson());
	}
	//--------------------------------------------------------------------------
	public CommunityMember createDomain() {
		//
		CommunityMember comMember = new CommunityMember();
		comMember.setCommunityNo(communityNo);
		comMember.setRolePerson(rolePerson.createDomain());
		
		return comMember;
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
	public SocialPersonDoc getRolePerson() {
		return rolePerson;
	}
	public void setRolePerson(SocialPersonDoc rolePerson) {
		this.rolePerson = rolePerson;
	}
}
