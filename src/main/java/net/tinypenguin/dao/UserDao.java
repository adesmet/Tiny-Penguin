package net.tinypenguin.dao;


import net.tinypenguin.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends MongoRepository<User, ObjectId> {

    @Query(value = "{ ?0 {$in: keywords.$id} }")
    List<User> findUsersByKeywords(String keywordId);
}
