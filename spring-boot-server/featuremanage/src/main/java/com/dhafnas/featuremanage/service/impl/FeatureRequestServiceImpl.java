package com.dhafnas.featuremanage.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhafnas.featuremanage.convertor.FeatureRequestConvertor;
import com.dhafnas.featuremanage.entity.FeatureRequest;
import com.dhafnas.featuremanage.model.FeatureRequestModel;
import com.dhafnas.featuremanage.repository.FeatureRequestRepository;
import com.dhafnas.featuremanage.service.FeatureRequestService;

/**
 * This service class is responsible for creating/updating/deleting feature
 * requests
 * 
 * @author dhafnas
 *
 */
@Service
public class FeatureRequestServiceImpl implements FeatureRequestService {

	@Autowired
	FeatureRequestRepository featureRequestRepository;

	/**
	 * To create new feature request
	 */
	@Override
	public FeatureRequestModel createFeatureRequest(FeatureRequestModel feature) {
		if (isPriorityAlreadyExists(feature)) {
			updateExistingFeatureRequestsPriority(feature.getClient(), feature.getPriority());
		}
		FeatureRequest newFeature = FeatureRequestConvertor.convert(feature);
		newFeature = featureRequestRepository.save(newFeature);
		feature.setId(newFeature.getId().intValue());
		return feature;
	}

	/**
	 * This method will update existing feature request priority
	 * 
	 * @param client
	 * @param priority
	 */
	private void updateExistingFeatureRequestsPriority(String client, int priority) {
		int limit = featureRequestRepository.getUppperPriorityLimit(client, priority);
		featureRequestRepository.updateFeatureRequestsPriority(client, priority, limit);
	}

	/**
	 * Check whether same priority is used for any other feature request for given
	 * client
	 * 
	 * @param featureModel
	 * @return
	 */
	private boolean isPriorityAlreadyExists(FeatureRequestModel featureModel) {
		List<FeatureRequest> features = featureRequestRepository.findByClientAndPriority(featureModel.getClient(),
				featureModel.getPriority());
		return Objects.nonNull(features) && !features.isEmpty();
	}

	/**
	 * Retrieve all feature requests
	 */
	@Override
	public List<FeatureRequestModel> getFeatureRequests() {
		Iterable<FeatureRequest> featuresIterator = featureRequestRepository.findAll();
		List<FeatureRequest> result = new ArrayList<>();
		featuresIterator.forEach(result::add);
		return result.stream().map(FeatureRequestConvertor::convert).collect(Collectors.toList());
	}

}
