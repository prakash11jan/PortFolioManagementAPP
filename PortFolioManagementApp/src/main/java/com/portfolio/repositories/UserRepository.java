package com.portfolio.repositories;

import com.portfolio.domain.Asset;
import com.portfolio.domain.User;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
