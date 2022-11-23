package com.ideas2it.cricketplayermanagement.util.constant;

/**
 * This class represents the gender of the cricket player.
 */
public enum Gender {
	FEMALE(1), MALE(2), TRANSGENDER(3);

	private int userChoice;

	Gender(int userChoice) {
		this.userChoice = userChoice;
	}

	/**
	 * This method is used check the enum is available in the enum class or not.
	 *
	 * @param value the user choice
	 * @return enum constant
	 */
	public static Gender getGender(int userChoice) {
		Gender result = null;
		for (Gender gender : Gender.values()) {
			if (gender.userChoice == userChoice) {
				result = gender;
				break;
			}
		}
		return result;
	}
}
