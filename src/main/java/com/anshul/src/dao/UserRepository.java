package com.anshul.src.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import com.anshul.src.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT * FROM user u WHERE " +
            "LOWER(u.name) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR " +
            "LOWER(u.address) LIKE LOWER(CONCAT('%',:searchTerm, '%')) "+
            "order by :name :order Limit :limit, :offset",
            nativeQuery = true
    )
	List<User> findBySerchTerm(@Param("searchTerm") String searchTerm
			,@Param("name") String name
			,@Param("order") String order
			,@Param("limit") Integer limit
			,@Param("offset") Integer offset
			);

}
