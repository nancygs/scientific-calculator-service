/**
 * 
 */
package com.negs.springboot.microservice.scientific.calculator.service;

import java.math.BigInteger;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Nancy GS
 *
 */
@Service
@Slf4j
public class ScientificCalculatorServiceImpl implements ScientificCalculatorService {

	@Override
	public Double square(Double value) {
		log.debug("Method square starts - parameters value: {}", value);
		return Math.pow(value, 2);
	}

	@Override
	public BigInteger factorial(Integer value) {
		log.debug("Method factorial starts - parameters value: {}", value);
		BigInteger result = BigInteger.ONE;
		for (int i = 2; i <= value; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}
		log.debug("Method factorial ends");
		return result;
	}

	@Override
	public boolean prime(Integer value) {
		log.debug("Method prime starts - parameters value: {}", value);
		Boolean isPrime = true;
		for (int i = 2; i <= value / 2; i++) {
			if ((value % i) == 0) {
				isPrime = false;
				break;
			}
		}
		log.debug("Method prime ends");
		return isPrime;
	}

}
