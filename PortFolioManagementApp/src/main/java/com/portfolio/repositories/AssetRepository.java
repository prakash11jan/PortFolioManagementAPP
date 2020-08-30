package com.portfolio.repositories;

import com.portfolio.domain.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset,Long> {

}
