/**
 * 
 */
package com.negs.springboot.microservice.scientific.calculator;

import java.math.BigInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.negs.springboot.microservice.scientific.calculator.controller.ScientificCalculatorController;
import com.negs.springboot.microservice.scientific.calculator.service.ScientificCalculatorService;

/**
 * @author Nancy GS
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ScientificCalculatorController.class)
public class ScientificCalculatorControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ScientificCalculatorService scientificCalculatorService;

	@Test
	public void squareOperation() throws Exception {

		Mockito.when(scientificCalculatorService.square(Mockito.anyDouble())).thenReturn(new Double(25));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/scientific-calculator/square/5")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "25.0";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void factorialOperation() throws Exception {

		Mockito.when(scientificCalculatorService.factorial(Mockito.anyInt())).thenReturn(new BigInteger("24"));

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/scientific-calculator/factorial/4")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "24";

		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}


}
