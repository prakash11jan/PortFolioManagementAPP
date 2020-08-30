package com.portfolio.controllers;

import com.portfolio.converters.AssetFormToAssetConverter;
import com.portfolio.domain.Asset;
import com.portfolio.domain.AssetDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.portfolio.form.AssetForm;
import com.portfolio.services.AssetService;

import java.util.List;


@RestController
@EnableZuulProxy
@EnableDiscoveryClient
public class PortFolioController implements ErrorController{
	private static final String PATH = "/error";
    @Autowired
    private AssetService assetService;

    @Autowired
    private AssetFormToAssetConverter assetFormToAssetConverter;

    

    @RequestMapping(value = "/assets", method = RequestMethod.GET)
    public List<AssetDetails> getAssets(@PathVariable long userId){
        List<AssetDetails> assetDetails = assetService.findAllAssetsForUser(userId);
        return assetDetails;
    }

    @RequestMapping(value = "/assetDetail/{id}", method = RequestMethod.GET)
    public AssetDetails getAssetDetail(@PathVariable long assetDetailId){
        AssetDetails productForm = assetService.findAssetDeail(assetDetailId);
        return productForm;
    }

    @RequestMapping(value = "/asset/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Asset> updatePrice(@PathVariable Long id,@RequestBody AssetForm assetForm){
        Asset asset = assetFormToAssetConverter.convert(assetForm);
        Asset result = assetService.updateAssetPrice(id,asset);
        if(null != result)
            return new ResponseEntity<Asset>(result, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

    }
   

    @RequestMapping(value = PATH)
    public String error() {
        return "oops!! something went wrong try again later!!";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
