package com.namoo.club.dao.mongo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.namoo.club.dao.ClubDao;
import com.namoo.club.dao.mongo.document.ClubDoc;
import com.namoo.club.dao.mongo.repository.ClubRepository;
import com.namoo.club.dao.mongo.shared.IdGenerator;

import dom.entity.Club;

@Repository
public class ClubDaoMongoLogic implements ClubDao {
	//
	@Autowired
	private ClubRepository repo;
	@Autowired
	private IdGenerator idGen;
	
	@Override
	public List<Club> readAllClubsByComNo(int comNo) {
		// 
		List<ClubDoc> docs = repo.findAllByComNo(comNo);
		if(docs != null) {
			List<Club> clubs = new ArrayList<Club>();
			for(ClubDoc doc : docs) {
				clubs.add(doc.createDomain());
			}
			return clubs;
		}
		return null;
	}

	@Override
	public List<Club> readAllClubs() {
		// 
		List<ClubDoc> docs = repo.findAll();
		if(docs != null) {
			List<Club> clubs = new ArrayList<Club>();
			for(ClubDoc doc : docs) {
				clubs.add(doc.createDomain());
			}
			return clubs;
		}
		return null;
	}

	@Override
	public Club readClub(int clubNo) {
		//
		ClubDoc doc = repo.findOne(clubNo);
		if (doc != null) {
			return doc.createDomain();
		}
		return null;
	}

	@Override
	public int createClub(Club club) {
		// 
		club.setComNo(idGen.next("club"));
		ClubDoc doc = new ClubDoc(club);
		repo.save(doc);
		
		return doc.getClubNo();
	}

	@Override
	public void updateClub(Club club) {
		// 
		ClubDoc doc = repo.findOne(club.getClubNo());
		doc = new ClubDoc(club);
		repo.save(doc);
	}

	@Override
	public void deleteClub(int clubNo) {
		//
		ClubDoc doc = repo.findOne(clubNo);
		repo.delete(doc);
	}
}
