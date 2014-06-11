package com.namoo.club.dao.mongo.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import dom.entity.ClubCategory;

public class ClubCategoryDoc {
	//
	@Id
	private int categoryNo;
	@Indexed
	private int communityNo;
	private String categoryName;
	//--------------------------------------------------------------------------
	public ClubCategoryDoc() {
		//
	}
	public ClubCategoryDoc(ClubCategory clubCategory) {
		//
		this.categoryNo = clubCategory.getCategoryNo();
		this.communityNo = clubCategory.getCommunityNo();
		this.categoryName = clubCategory.getCategoryName();
	}
	//--------------------------------------------------------------------------
	public ClubCategory createDomain() {
		ClubCategory clubCategory = new ClubCategory();
		
		clubCategory.setCategoryNo(categoryNo);
		clubCategory.setCommunityNo(communityNo);
		clubCategory.setCategoryName(categoryName);
		
		return clubCategory;
	}
	//--------------------------------------------------------------------------
	public int getCategoryNo() {
		return categoryNo;
	}
	public void setCategoryNo(int categoryNo) {
		this.categoryNo = categoryNo;
	}
	public int getCommunityNo() {
		return communityNo;
	}
	public void setCommunityNo(int communityNo) {
		this.communityNo = communityNo;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
