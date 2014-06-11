package com.namoo.club.dao.mongo.repository;

import com.namoo.club.dao.mongo.document.CommunityManagerDoc;
import com.namoo.club.dao.mongo.document.CommunityMemberDoc;

public interface CommunityRepositoryCustom {
	//
	// Community part
	void addCommunityManager(CommunityManagerDoc communityManagerDoc);
	void addCommunityMember(CommunityMemberDoc communityMemberDoc);
	void deleteCommunityMemberByEmail(int comNo, String email);
	void updateCommunityManager(CommunityManagerDoc communityManagerDoc);
}
