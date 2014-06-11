package com.namoo.club.dao.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.namoo.club.dao.mongo.document.ClubDoc;

public interface ClubRepository extends MongoRepository<ClubDoc, Integer>, ClubRepositoryCustom{
	//
	List<ClubDoc> findAllByComNo(int comNo);
	List<ClubDoc> findAll();
}
