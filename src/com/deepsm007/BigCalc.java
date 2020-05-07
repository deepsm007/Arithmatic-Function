/**
 * 
 */
package com.deepsm007;

import java.io.IOException;
import java.math.BigInteger;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Deep Mistry
 *
 *         This class calculates the mathematical operations like addition,
 *         multiplication, relative prime, modulus, modulus inverse and power.
 */
@WebService
public class BigCalc extends HttpServlet {

	private static final long serialVersionUID = 3285358725941763191L;
	private static BigInteger x=BigInteger.ONE;
	private static BigInteger y=BigInteger.ONE;
	private static String operation;
	private static String result;

	/**
	 * This method performs the POST request and redirects it to GET method.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doGet(request, response);
	}

	/**
	 * This method performs the GET request. The input from the browser is stored in
	 * x and y BigInteger variables. and passed on to the result method to perform
	 * the selected operation by the user. The returned result is then forwarded
	 * back to the same page as the response.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		result = "";
		String first = request.getParameter("first"); //input from the first number i.e. x
		x = new BigInteger(first);
		String second = request.getParameter("second"); //input from the second number i.e. y
		y = new BigInteger(second);
		operation = request.getParameter("operation"); // operation selected from the dropdown list
		result = result(x, y, operation);
		request.setAttribute("output", "Result of operation for " + x + " and " + y + " = " + result);
		request.getRequestDispatcher("/").forward(request, response);
	}

	/**
	 * This method performs the mathematical operations and returning the result as
	 * a String.
	 * 
	 * @param x
	 * @param y
	 * @param operation
	 * @return
	 */
	public static String result(BigInteger x, BigInteger y, String operation) {
		if (operation.contains("1"))
			return x.add(y).toString(); //addition
		else if (operation.contains("2"))
			return x.multiply(y).toString(); //multiplication
		else if (operation.contains("3")) //check for prime by taking gcd of 2 numbers
			if (x.gcd(y).toString().equals(1)) {
				return "Relatively prime"; 
			} else {
				return "Relatively not prime";
			}
		else if (operation.contains("4"))
			return x.mod(y).toString(); //modulus
		else if (operation.contains("5"))
			return x.modInverse(y).toString(); //modulus inverse
		else if (operation.contains("6"))
			return x.pow(y.intValue()).toString(); //power
		else
			return "Invalid Output";
	}

}
