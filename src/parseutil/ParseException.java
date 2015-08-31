package parseutil;

/**
 * Created with IntelliJ IDEA.
 * User: aba-sah
 * Date: 18/02/2013
 * Time: 14:25
 * To change this template use File | Settings | File Templates.
 */
public class ParseException extends Exception {

  private String entry;

  public ParseException(String input) {
    entry = input;
  }

  @Override
  public String getMessage() {
    String message = "Error creating new parsed log from entry: " + entry;
    return message;
  }
}