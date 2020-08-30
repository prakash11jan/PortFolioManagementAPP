package com.portfolio.services;

import java.util.List;

import com.portfolio.domain.Asset;
import com.portfolio.domain.AssetDetails;
import com.portfolio.form.AssetForm;

public interface AssetService {


    Asset updateAssetPrice(long assetId, Asset asset);

    Asset CreateAssetForUser(Asset asset,Long userId,int count);

    List<AssetDetails> findAllAssetsForUser(long userId);

    AssetDetails findAssetDeail(long assetDetailId);
}
