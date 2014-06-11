package com.namoo.club.dao.mongo.repository;

import com.namoo.club.dao.mongo.document.ClubManagerDoc;
import com.namoo.club.dao.mongo.document.ClubMemberDoc;

public interface ClubRepositoryCustom{
	//
	void addClubMember(ClubMemberDoc clubMemberDoc);
	void addClubManager(ClubManagerDoc clubManagerDoc);
//	void deleteAllClubMember(int clubNo);
	void deleteClubMemberByEmail(int clubNo, String email);
	void deleteClubManager(int clubNo, String email);
	void updateClubManager(ClubManagerDoc clubManagerDoc);
	
}
