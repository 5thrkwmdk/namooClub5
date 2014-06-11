package com.namoo.club.dao.mongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.namoo.club.dao.mongo.document.CommunityDoc;
import com.namoo.club.dao.mongo.document.CommunityManagerDoc;

public interface CommunityRepository extends MongoRepository<CommunityDoc, Integer>, CommunityRepositoryCustom {
	//crudRepository 를 하는 것보다 mongoRepository를 하는게 더 낫다.
	List<CommunityDoc> findAll();
}
