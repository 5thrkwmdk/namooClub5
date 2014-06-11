package com.namoo.club.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.CommunityDao;
import com.namoo.club.dao.mongo.document.ClubCategoryDoc;
import com.namoo.club.dao.mongo.document.CommunityDoc;
import com.namoo.club.dao.mongo.repository.CommunityRepository;
import com.namoo.club.dao.mongo.shared.IdGenerator;

import dom.entity.ClubCategory;
import dom.entity.Community;

@Repository
public class CommunityDaoMongoLogic implements CommunityDao {
	//
	@Autowired
	private CommunityRepository comRepo;
	@Autowired
	private IdGenerator idGen;
	
	@Override
	public List<Community> readAllCommunities() {
		//
		List<CommunityDoc> docs = comRepo.findAll();
		if (docs != null) {
			List<Community> communties = new ArrayList<Community>();
			for(CommunityDoc doc : docs) {
				communties.add(doc.createDomain());
			}
			return communties;
		}
		return null;
	}

	@Override
	public Community readCommunity(int comNo) {
		//
		CommunityDoc doc = comRepo.findOne(comNo);
		if (doc != null) {
			return doc.createDomain();
		}
		return null;
	}

	@Override
	public int createCommunity(Community community) {
		//
		community.setComNo(idGen.next("community"));
		CommunityDoc doc = new CommunityDoc(community);
		comRepo.save(doc);
		
		return doc.getComNo();
	}

	@Override
	public void updateCommunity(Community community) {
		//
		CommunityDoc doc = comRepo.findOne(community.getComNo());
		doc = new CommunityDoc(community);
		comRepo.save(doc);
	}

	@Override
	public void deleteCommunity(int comNo) {
		//
		comRepo.delete(comNo);
	}

	@Override
	public List<ClubCategory> readAllCategories(int comNo) {
		//
		CommunityDoc doc = comRepo.findOne(comNo);
		List<ClubCategoryDoc> categoryDocs = doc.getCategories();
		if(categoryDocs != null) {
			List<ClubCategory> categories = new ArrayList<ClubCategory>();
			for (ClubCategoryDoc categoryDoc : categoryDocs) {
				categories.add(categoryDoc.createDomain());
			}
			return categories;
		}
		return null;
	}

	@Override
	public void insertClubCategory(List<ClubCategory> categories) {
		// 
		CommunityDoc doc = comRepo.findOne(categories.get(0).getCommunityNo());
		List<ClubCategoryDoc> docs = new ArrayList<ClubCategoryDoc>();
		for (ClubCategory category : categories) {
			docs.add(new ClubCategoryDoc(category));
		}
		doc.setCategories(docs);
		comRepo.save(doc);
	}
}
