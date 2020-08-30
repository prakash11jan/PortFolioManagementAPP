package com.portfolio.services.impl;

import java.util.List;
import java.util.Optional;

import com.portfolio.converters.AssetFormToAssetConverter;
import com.portfolio.domain.Asset;
import com.portfolio.domain.AssetDetails;
import com.portfolio.domain.User;
import com.portfolio.repositories.AssetDetailsRepository;
import com.portfolio.repositories.AssetRepository;
import com.portfolio.repositories.UserRepository;
import com.portfolio.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


@PropertySource({ "classpath:application.properties" })
@Service
public class AssetServiceImpl implements AssetService {


    private Environment env;
    @Autowired
	AssetFormToAssetConverter priceFormToPriceConverter;

	@Autowired
	AssetRepository assetRepository;

	@Autowired
	private AssetDetailsRepository assetDetailsRepository;

	@Autowired
	UserRepository userRepository;


	@Override
	public Asset updateAssetPrice(long assetId,Asset asset) {
		return assetRepository.save(asset);//save or update
	}

	@Override
	public List<AssetDetails> findAllAssetsForUser(long userId) {
		return assetDetailsRepository.findAllAssetsByUserId(userId);
	}

	@Override
	public AssetDetails findAssetDeail(long assetDetailId) {
		Optional<AssetDetails> assetDetail = assetDetailsRepository.findById(assetDetailId);
		return assetDetail.isPresent()?assetDetail.get():null;
	}

	@Override
	public Asset CreateAssetForUser(Asset asset, Long userId,int count) {
		Optional<User> user = userRepository.findById(userId);
		if(user.isPresent()) {
			AssetDetails deatils = new AssetDetails();
			deatils.setAsset(asset);
			deatils.setNoOfAssets(count);
			deatils.setTotalPrice(count * asset.getPrice());
			deatils.setUser(user.get());
		}
		return asset;
	}


}
