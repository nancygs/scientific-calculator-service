/**
 * 
 */
package com.negs.springboot.microservice.scientific.calculator.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.negs.springboot.microservice.scientific.calculator.service.ScientificCalculatorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Nancy GS
 *
 */

@RestController
@RequestMapping("/scientific-calculator")
@Slf4j
@Api(tags = "Scientific Calculator")
public class ScientificCalculatorController {

	@Autowired
	ScientificCalculatorService scientificCalculatorService;

	@GetMapping("/square/{value}")
	@ApiOperation(value = "Retrieve square operation result", notes = "Return the result of value ^2 operation")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred") })
	public Double square(@Valid @PathVariable Double value) {
		log.info("Method square starts - parameters value {}", value);
		return scientificCalculatorService.square(value);
	}

	@GetMapping("/factorial/{value}")
	@ApiOperation(value = "Retrieve factorial operation result", notes = "Return the result of value! operation")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred") })
	public BigInteger factorial(@PathVariable Integer value) {
		log.info("Method factorial starts - parameters value {}", value);
		return scientificCalculatorService.factorial(value);
	}

	@GetMapping("/prime/{value}")
	@ApiOperation(value = "Retrieve if a value is a prime number", notes = "Return true if the value is a prime number, return false if value is not prime number")
	@ApiResponses({ @ApiResponse(code = HttpServletResponse.SC_OK, message = "OK"),
			@ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "An unexpected error occurred") })
	public Boolean prime(@PathVariable Integer value) {
		log.info("Method prime starts - parameters value {}", value);
		return scientificCalculatorService.prime(value);

	}

}
