package data;

/**
 * Created with IntelliJ IDEA.
 * User: aba-sah
 * Date: 26/03/2013
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public enum CodeType {

  Uncoded,
  Sentiment,
  Frame;


  private int frequency;


  private CodeType() {
    frequency = 0;
  }

  public void updateFrequency() {
    frequency++;
  }

  public static void clearAllFrequencies() {
    for (CodeType codeType : CodeType.values())
      codeType.frequency = 0;
  }

  public int getFrequency() {
    return frequency;
  }
}
