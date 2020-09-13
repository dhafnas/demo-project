package com.dhafnas.featuremanage.service;

import java.util.List;

import com.dhafnas.featuremanage.model.FeatureRequestModel;

public interface FeatureRequestService {
	
	public FeatureRequestModel createFeatureRequest(FeatureRequestModel feature);

	public List<FeatureRequestModel> getFeatureRequests();
}
