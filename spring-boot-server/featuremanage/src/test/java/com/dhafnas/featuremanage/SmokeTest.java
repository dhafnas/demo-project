package com.dhafnas.featuremanage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhafnas.featuremanage.controller.FeatureRequestController;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class SmokeTest {
	
	@Autowired
	FeatureRequestController featureRequestController;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(featureRequestController).isNotNull();
	}
}
