
package com.namoo.club.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.MemberDao;
import com.namoo.club.dao.mongo.document.ClubDoc;
import com.namoo.club.dao.mongo.document.ClubManagerDoc;
import com.namoo.club.dao.mongo.document.ClubMemberDoc;
import com.namoo.club.dao.mongo.document.CommunityDoc;
import com.namoo.club.dao.mongo.document.CommunityManagerDoc;
import com.namoo.club.dao.mongo.document.CommunityMemberDoc;
import com.namoo.club.dao.mongo.repository.ClubRepository;
import com.namoo.club.dao.mongo.repository.CommunityRepository;

import dom.entity.ClubManager;
import dom.entity.ClubMember;
import dom.entity.CommunityManager;
import dom.entity.CommunityMember;

@Repository
public class MemberDaoMongoLogic implements MemberDao{
	//
	@Autowired
	private CommunityRepository comRepo;
	@Autowired
	private ClubRepository clubRepo;
	
	@Override
	public void addCommunityManager(CommunityManager comManager) {
		//
		comRepo.addCommunityManager(new CommunityManagerDoc(comManager));
	}

	@Override
	public void addCommunityMember(CommunityMember comMember) {
		//
		comRepo.addCommunityMember(new CommunityMemberDoc(comMember));
	}

	@Override
	public CommunityMember readCommunityMember(int comNo, String email) {
		// 
		// 멤버리스트 불러와라. 리턴 끝.
		CommunityDoc comDoc = comRepo.findOne(comNo);
		List<CommunityMemberDoc> comMemberDocs = comDoc.getMembers();
		if (comMemberDocs != null) {
			CommunityMemberDoc found = null;
			for(CommunityMemberDoc comMemberDoc : comMemberDocs) {
				if (comMemberDoc.getEmail().equals(email)) {
						found =  comMemberDoc;
						break;
				}
			}
			if (found != null) {
				return found.createDomain();
			}
		}
		return null;
	}

	@Override
	public CommunityManager readCommunityManager(int comNo) {
		//
		// comDoc find. comDoc 의 매니저 불러와서, 매니저 리턴
		CommunityDoc comDoc = comRepo.findOne(comNo);
		CommunityManagerDoc comManagerDoc = comDoc.getManager();
		
		return comManagerDoc.createDomain();
	}

	@Override
	public List<CommunityMember> readAllCommunityMember(int comNo) {
		//
		// comDoc find. comDoc's members find? load? -> return
		CommunityDoc comDoc = comRepo.findOne(comNo);
		List<CommunityMemberDoc> comMemberDocs = comDoc.getMembers();
		List<CommunityMember> comMembers = new ArrayList<CommunityMember>();
		if(comMemberDocs != null) {
			for(CommunityMemberDoc comMemberDoc : comMemberDocs) {
				comMembers.add(comMemberDoc.createDomain());
			}
			return comMembers;
		}
		return null;
	}

	@Override
	public void deleteCommunityMember(int comNo, String email) {
		//
		comRepo.deleteCommunityMemberByEmail(comNo, email);
	}

	@Override
	public void addClubMember(ClubMember clubMember) {
		//
		clubRepo.addClubMember(new ClubMemberDoc(clubMember));
	}

	@Override
	public void addClubManager(ClubManager clubManager) {
		//
		clubRepo.addClubManager(new ClubManagerDoc(clubManager));
	}

	@Override
	public void deleteClubMember(int clubNo, String email) {
		//
		clubRepo.deleteClubMemberByEmail(clubNo, email);
	}

	@Override
	public void deleteClubManager(int clubNo, String email) {
		//
		clubRepo.deleteClubManager(clubNo, email);
	}

	@Override
	public List<ClubMember> readAllClubMembers(int clubNo) {
		//
		ClubDoc clubDoc = clubRepo.findOne(clubNo);
		List<ClubMemberDoc> clubMemberDocs = clubDoc.getMembers();
		List<ClubMember> clubMembers = new ArrayList<ClubMember>();
		for(ClubMemberDoc clubMemberDoc : clubMemberDocs) {
			clubMembers.add(clubMemberDoc.createDomain());
		}
		return clubMembers;
	}

	@Override
	public List<ClubManager> readAllClubManagers(int clubNo) {
		//
		ClubDoc clubDoc = clubRepo.findOne(clubNo);
		List<ClubManagerDoc> clubManagerDocs = clubDoc.getManagers();
		List<ClubManager> clubManagers= new ArrayList<ClubManager>();
		if(clubManagerDocs != null) {
			for(ClubManagerDoc clubManagerDoc : clubManagerDocs) {
				clubManagers.add(clubManagerDoc.createDomain());
			}
			return clubManagers;
		}
		return null;
	}

	@Override
	public ClubMember readClubMember(int clubNo, String email) {
		//
		ClubDoc clubDoc = clubRepo.findOne(clubNo);
		List<ClubMemberDoc> clubMemberDocs = clubDoc.getMembers();
		if (clubMemberDocs != null) {
			for(ClubMemberDoc clubMemberDoc : clubMemberDocs){
				if(clubMemberDoc.getEmail().equals(email)) {
					return clubMemberDoc.createDomain();
				}
			}
		}
		return null;
	}

	@Override
	public ClubManager readClubManager(int clubNo, String email) {
		// 
		ClubDoc clubDoc = clubRepo.findOne(clubNo);
		List<ClubManagerDoc> clubManagerDocs = clubDoc.getManagers();
		ClubManager manager = null;
		if(clubManagerDocs != null) {
			for (ClubManagerDoc clubManagerDoc : clubManagerDocs) {
				if(clubManagerDoc.getEmail().equals(email)) {
					manager = clubManagerDoc.createDomain();
				}
			}
			return manager;
		}
		return null;
	}

	@Override
	public ClubManager readClubKingManager(int clubNo) {
		//
		ClubDoc clubDoc = clubRepo.findOne(clubNo);
		List<ClubManagerDoc> clubManagerDocs = clubDoc.getManagers();
		if(clubManagerDocs != null) {
			for (ClubManagerDoc clubManagerDoc : clubManagerDocs) {
				if(clubManagerDoc.isKingManager()) {
					return clubManagerDoc.createDomain();
				}
			}
		}
		return null;
	}

	@Override
	public void updateCommunityManager(CommunityManager comManager) {
		// 
		comRepo.updateCommunityManager(new CommunityManagerDoc(comManager));
	}

	@Override
	public void updateClubManager(ClubManager clubManager) {
		//
		clubRepo.updateClubManager(new ClubManagerDoc(clubManager));
		
	}

}
