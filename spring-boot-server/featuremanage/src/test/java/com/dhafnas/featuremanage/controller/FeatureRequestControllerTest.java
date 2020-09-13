package com.dhafnas.featuremanage.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.dhafnas.featuremanage.model.FeatureRequestModel;
import com.dhafnas.featuremanage.service.FeatureRequestService;
@WebMvcTest(FeatureRequestController.class)
public class FeatureRequestControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private FeatureRequestService featureRequestService;

	@Test
	public void getFeaturerequstShouldReturnEmptyList() throws Exception {
		when(featureRequestService.getFeatureRequests()).thenReturn(Collections.emptyList());
		this.mockMvc.perform(get("/v1/feature/requests")).andExpect(status().isOk());
	}
	@Test
	public void getFeaturerequstShouldReturnList() throws Exception {
		List<FeatureRequestModel> featureRequests = new ArrayList<>();
		featureRequests.add(new FeatureRequestModel() {{
			setId(1);
			setTitle("Feature 1");
			setDescription("Feature 1 description");
			setClient("Client 1");
			setPriority(2);
			setProductArea("Claims");
		}});
		when(featureRequestService.getFeatureRequests()).thenReturn(featureRequests);
		this.mockMvc.perform(get("/v1/feature/requests"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].id", is(1)))
        .andExpect(jsonPath("$[0].description", is("Feature 1 description")))
        .andExpect(jsonPath("$[0].title", is("Feature 1")));
	}
}
