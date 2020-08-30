package com.portfolio.converters;

import com.portfolio.domain.Asset;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.portfolio.form.AssetForm;


@Component
public class AssetFormToAssetConverter implements Converter<AssetForm, Asset> {

	@Override
	public Asset convert(AssetForm assetForm) {
		Asset asset = new Asset();
		asset.setId(assetForm.getId());
		asset.setPrice(assetForm.getPrice());
		asset.setType(assetForm.getType());
		return asset;
	}

	
}
