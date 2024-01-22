package model;

public class sessionManager {
  private static String currentUserID;
  public static void setUserID(String userID) {
	  currentUserID = userID;
  }
  
  public static String getUserID()
  {
	  return currentUserID;
  }
}
