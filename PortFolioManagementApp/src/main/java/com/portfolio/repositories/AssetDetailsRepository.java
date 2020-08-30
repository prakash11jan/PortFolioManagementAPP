package com.portfolio.repositories;

import com.portfolio.domain.Asset;
import com.portfolio.domain.AssetDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetDetailsRepository extends CrudRepository<AssetDetails, Long> {
    String Q_GET_ALL_ASSETS = "select * from ASSETDETAILS where user=:id";
    List<AssetDetails> findAllAssetsByUserId(long id);
}
