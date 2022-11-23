package com.ideas2it.cricketplayermanagement.util.constant;

/**
 *<p>
 * CricketPlayerConstants contains all the constant value used in 
 * the program. 
 *</p>
 */
public class CricketPlayerConstants {
    public static final String MENU = "Choose: \n1.Create  Player \n2.Display Players" 
                                              + "\n3.Get     Player \n4.Update  Player" 
                                              + "\n5.Delete  Player \n6.Search  Player \n7.Get details between date of birth"
                                              + "\n8.Get players by their ids \n9.assign team\n10.Display player along with team \n11.Exit";
    public static final int CREATE_PLAYER = 1;
    public static final int DISPLAY_PLAYERS = 2;
    public static final int GET_PLAYER = 3;
    public static final int UPDATE_PLAYER = 4;
    public static final int DELETE_PLAYER = 5;
    public static final int SEARCH_PLAYER = 6;

    public static final String CREATED = "You have successfully created a player";
    public static final String NAME = "Enter player name :";
    public static final String DATE_OF_BIRTH = "Enter player date of birth in this format(DD-MM-YYYY) :";
    public static final String COUNTRY_NAME = "Enter player country name :"; 
    public static final String GENDER ="Enter your gender :\n1.Female\n2.Male\n3.Transgender";
    public static final String DELETED = "Deleted successfully";
    public static final String INVALID = "Invalid input";
    public static final String NOT_FOUND = "Record not found";
    public static final String MENU_FOR_UPDATE = "Which detail you want to update?"
                                                      + " \n1.name \n2.date of birth \n3.country \n4.email \n5.gender\n6.Exit";
    public static final String ENTER_ID_TO_UPDATE = "Enter player id to update";
    public static final int UPDATE_NAME = 1;
    public static final int UPDATE_DATEOFBIRTH = 2;
    public static final int UPDATE_COUNTRY_NAME = 3;
    public static final int UPDATE_GMAIL = 4;
    public static final String UPDATED = "updated successfully";
    public static final String INVALID_NAME = "The player name should contain only alphabets"
                                                  + " and can either have one space or not :";
    public static final String INVALID_COUNTRY_NAME = "The player country name should contain only alphapets and"
                                                           + " can either have one space or not";
    public static final int EXIT = 0;
    public static final String MESSAGE = "Something went wrong";
    public static final String INVALID_MESSAGE = "You must enter the following number to access\n1 2 3 4 5 6 0";
    public static final String CHOICE = "Enter your choice";
    public static final String SHOW_MENU_AGAIN = "Press 1 to show main menu \n        (OR)\n"
                                                  +"Press any number to exit";
    public static final String UPDATE_AGAIN = "Press 1 to update \n      (OR)\n" 
                                                   +"Press any number to exit from update";
    public static final int GET_DETAILS_BETWEEN_IDS = 7;

}