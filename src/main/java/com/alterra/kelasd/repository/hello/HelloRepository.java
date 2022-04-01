package com.alterra.kelasd.repository.hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HelloRepository extends CrudRepository<Hello, Integer> {

//    @Query("from Auction a join a.category c where c.name=:categoryName")
//    public Iterable<Hello> findByCategory(@Param("categoryName") String categoryName);
}
