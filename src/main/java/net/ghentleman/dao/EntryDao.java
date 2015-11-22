package net.ghentleman.dao;


import net.ghentleman.model.Entry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryDao extends MongoRepository<Entry, ObjectId> {
    @Query("{ 'hashes' : ?0 }")
    List<Entry> findEntriesByHash(String hash);
}
