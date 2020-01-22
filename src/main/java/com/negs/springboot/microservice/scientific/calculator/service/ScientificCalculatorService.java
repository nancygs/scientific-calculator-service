/**
 * 
 */
package com.negs.springboot.microservice.scientific.calculator.service;

import java.math.BigInteger;

/**
 * @author Nancy GS
 *
 */
public interface ScientificCalculatorService {

	Double square(Double value);

	BigInteger factorial(Integer value);

	boolean prime(Integer value);

}
