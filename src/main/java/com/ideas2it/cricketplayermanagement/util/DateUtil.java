package com.ideas2it.cricketplayermanagement.util;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ideas2it.cricketplayermanagement.util.exception.PlayerManagementException;

/**
 * <p>
 * DateUtil program simply convert string to date format.
 * </p>
 */
public class DateUtil {
	public static Date currentDate = new Date();
	public static DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	public static boolean isValidDate(String userDate) throws PlayerManagementException {
		boolean value = false;
		formatter.setLenient(false);
		try {
			Date parsedDate = formatter.parse(userDate);
			value = true;
		} catch (ParseException parseException) {
			value = false;
		}
		return value;
	}

	/**
	 * This method is used to convert the date to string format.
	 *
	 * @param dateOfBirth is the parameter to isValidName method
	 * @throws ParseException
	 * @return date.
	 */
	public static String convertDateToString(Date dateOfBirth) {
		String date = formatter.format(dateOfBirth);
		return date;
	}

	/**
	 * This method is used to convert util date to sql.
	 *
	 * @return sql date.
	 */
	public static java.sql.Date convertUtilDateToSql(Date dateOfBirth) {
		return new java.sql.Date(dateOfBirth.getTime());
	}

	/**
	 * This method is used to convert Sql Date To Util.
	 *
	 * @return util date.
	 */
	public static Date convertSqlDateToUtil(Date dateOfBirth) {
		return new java.util.Date(dateOfBirth.getTime());
	}

	/**
	 * This method is used to convert the string to date format.
	 *
	 * @param dateOfBirth is the parameter to isValidName method
	 * @throws ParseException
	 * @return date.
	 */
	public static Date convertStringToDate(String dateOfBirth) throws PlayerManagementException {
		try {
			Date date = formatter.parse(dateOfBirth);
			return date;
		}catch (ParseException parseException) {
			throw new PlayerManagementException(parseException.getMessage());
		}
	}

	/**
	 * This method is used to know the differnce between two years.
	 *
	 * @param date is the parameter to isValidName method
	 * @throws ParseException
	 * @return date.
	 */
	public static int getAge(Date date, Date currentDate) {
		int age = 0;
		if (null != date && null != currentDate) {
			long ageInMiliSecond = currentDate.getTime() - date.getTime();
			age = (int) (ageInMiliSecond / (1000l * 60 * 60 * 24 * 365));
		}
		return age;
	}
}