package com.dhafnas.featuremanage.convertor;

import com.dhafnas.featuremanage.entity.FeatureRequest;
import com.dhafnas.featuremanage.model.FeatureRequestModel;

public  class FeatureRequestConvertor {
 public static FeatureRequest convert(FeatureRequestModel feature) {
	 FeatureRequest newFeature = new FeatureRequest();
	 newFeature.setTitle(feature.getTitle());
	 newFeature.setDescription(feature.getDescription());
	 newFeature.setPriority(feature.getPriority());
	 newFeature.setClient(feature.getClient());
	 newFeature.setTargetDate(feature.getTargetDate());
	 newFeature.setProductArea(feature.getProductArea());
     return newFeature;
 }
 
 public static FeatureRequestModel convert(FeatureRequest feature) {
	 FeatureRequestModel featureModel = new FeatureRequestModel() {{
		 setTitle(feature.getTitle());
		 setDescription(feature.getDescription());
		 setPriority(feature.getPriority());
		 setClient(feature.getClient());
		 setProductArea(feature.getProductArea());
		 setTargetDate(feature.getTargetDate());
	 }};
     return featureModel;
 }
}
