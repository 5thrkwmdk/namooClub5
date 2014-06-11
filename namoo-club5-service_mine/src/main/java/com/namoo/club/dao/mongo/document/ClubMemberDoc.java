package com.namoo.club.dao.mongo.document;

import dom.entity.ClubMember;

public class ClubMemberDoc {
	//
	private int clubNo;
	private SocialPersonDoc rolePerson;
	//--------------------------------------------------------------------------
	public ClubMemberDoc() {
		//
	}
	public ClubMemberDoc(ClubMember clubMember) {
		//
		this.clubNo = clubMember.getClubNo();
		this.rolePerson = new SocialPersonDoc(clubMember.getRolePerson());
	}
	//---------------------------------------------------------------------------
	public ClubMember createDomain() {
		ClubMember clubMember = new ClubMember();
		clubMember.setClubNo(clubNo);
		clubMember.setRolePerson(rolePerson.createDomain());
		
		return clubMember;
	}
	//---------------------------------------------------------------------------
	public String getName() {
		return rolePerson.getName();
	}
	public String getEmail() {
		return rolePerson.getEmail();
	}
	public int getClubNo() {
		return clubNo;
	}
	public void setClubNo(int clubNo) {
		this.clubNo = clubNo;
	}
	public SocialPersonDoc getRolePerson() {
		return rolePerson;
	}
	public void setRolePerson(SocialPersonDoc rolePerson) {
		this.rolePerson = rolePerson;
	}
}
