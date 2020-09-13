package com.dhafnas.featuremanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhafnas.featuremanage.model.FeatureRequestModel;
import com.dhafnas.featuremanage.service.FeatureRequestService;

@RestController
@RequestMapping("/v1/feature/requests")
public class FeatureRequestController {

	@Autowired
	FeatureRequestService featureRequestService;

	@RequestMapping(produces = "application/json")
	@GetMapping
	public List<FeatureRequestModel> getFeatureRequests() {
		return featureRequestService.getFeatureRequests();
	}

	@PostMapping(produces = "application/json")
	public FeatureRequestModel createFeatureRequest(@RequestBody FeatureRequestModel feature) {
		return featureRequestService.createFeatureRequest(feature);
	}
}
