package com.namoo.club.dao.mongo.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import dom.entity.ClubCategory;
import dom.entity.Community;
import dom.entity.CommunityMember;

@Document(collection="communities")
public class CommunityDoc {
	//
	@Id
	private int comNo;
	private String name;
	private String description;
	private Date openDate;
	
	private List<ClubCategoryDoc> categories;
	private List<CommunityMemberDoc> members;
	private CommunityManagerDoc manager;
	//--------------------------------------------------------------------------
	public CommunityDoc () {
		//
	}
	public CommunityDoc (Community community) {
		//
		this.comNo = community.getComNo();
		this.name = community.getName();
		this.description = community.getDescription();
		this.openDate = new Date();
	}
	//--------------------------------------------------------------------------
	public Community createDomain() {
		//
		Community community = new Community();
		community.setComNo(comNo);
		community.setName(name);
		community.setDescription(description);
		community.setOpenDate(openDate);
		
		if (categories != null) {
			List<ClubCategory> clubCategorys = new ArrayList<ClubCategory>();
			for(ClubCategoryDoc doc : categories) {
				clubCategorys.add(doc.createDomain());
			}
			community.setCategories(clubCategorys);
		}
		
		if (members != null) {
			List<CommunityMember> comMembers = new ArrayList<CommunityMember>();
			for(CommunityMemberDoc doc : members) {
				comMembers.add(doc.createDomain());
			}
			community.setMembers(comMembers);
		}
		if (manager != null ) {
			community.setManager(manager.createDomain());
		}
		
		return community;
	}
	//--------------------------------------------------------------------------
	public int getComNo() {
		return comNo;
	}
	public void setComNo(int comNo) {
		this.comNo = comNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public List<ClubCategoryDoc> getCategories() {
		return categories;
	}
	public void setCategories(List<ClubCategoryDoc> categories) {
		this.categories = categories;
	}
	public List<CommunityMemberDoc> getMembers() {
		return members;
	}
	public void setMembers(List<CommunityMemberDoc> members) {
		this.members = members;
	}
	public CommunityManagerDoc getManager() {
		return manager;
	}
	public void setManager(CommunityManagerDoc manager) {
		this.manager = manager;
	}
}