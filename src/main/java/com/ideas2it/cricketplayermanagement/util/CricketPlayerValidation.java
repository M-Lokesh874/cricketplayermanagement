package com.ideas2it.cricketplayermanagement.util;

import java.text.ParseException;
import java.util.regex.Pattern;

import com.ideas2it.cricketplayermanagement.util.constant.CricketPlayerConstants;

/**
 * <p>
 * CricketPlayerValidation validate the details of the cricket players.
 * </p>
 */
public class CricketPlayerValidation {
	/**
	 * <p>
	 * This method is used to validate the name.
	 * </p>
	 *
	 * @param name name of the cricket player
	 * @return true if pattern mataches name.
	 */
	public static boolean isValidName(String name) {
		return Pattern.matches("(^[A-Za-z][A-Za-z]*\\s*[a-zA-z]*)", name);
	}

	/**
	 * <p>
	 * This method is used to validate the country name.
	 * </p>
	 *
	 * @param country name of the country
	 * @return true if pattern matches country name
	 */
	public static boolean isValidCountryName(String country) {
		return Pattern.matches("(^[A-Za-z][A-Za-z]*\\s*[a-zA-z]*)", country);
	}

	/**
	 * <p>
	 * This method is used to validate the email of the player.
	 * </p>
	 *
	 * @param email of the player
	 * @return true if pattern matches email
	 */
	public static boolean isValidEmail(String email) {
		return Pattern.matches(
				"^([a-zA-Z])([\\w]{3,50})([\\.||\\_])?([\\w])*([\\@])([\\w]){3,20}([\\.]){1}([a-zA-Z]){3,5}$", email);
	}

	/**
	 * <p>
	 * This method is used to validate number whether it is number or not.
	 * </p>
	 *
	 * @param - number given by user
	 * @return - true
	 */
	public static boolean isValidNumber(int playerStats) {
		return Pattern.matches("(^[0-9]*$)", Integer.toString(playerStats));
	}
}
