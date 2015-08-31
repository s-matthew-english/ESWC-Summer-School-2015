package data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: aba-sah
 * Date: 26/03/2013
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 */
public enum Code {

   /****************************
	*                          *
	* MUST CHANGE THESE LABELS *
	*                          *
	****************************/
  OffTopic(CodeType.Uncoded, "Off Topic"),
  OtherLanguages(CodeType.Uncoded, "Other Languages"),
  Positive(CodeType.Sentiment),
  Negative(CodeType.Sentiment),
  Neutral(CodeType.Sentiment),
  Scientific(CodeType.Frame),
  Political(CodeType.Frame),
  Economic(CodeType.Frame),
  ELSI(CodeType.Frame, "Ethical Legal and Social"),
  Fun(CodeType.Frame),
  Ambiguous(CodeType.Frame);


  private String label;
  private CodeType codeType;

  private List<Term> matchingTerms;
  private String regex;

  private int frequency;

  private Code(CodeType type) {
    init(type, name());
  }

  private Code(CodeType type, String codeLabel) {
    init(type, codeLabel);
  }

  private void init(CodeType type, String codeLabel) {
    codeType = type;
    label = codeLabel;
    matchingTerms = new ArrayList<Term>();
    frequency = 0;
  }

  public CodeType getCodeType() {
    return codeType;
  }

  public void updateFrequency() {
    frequency++;
    codeType.updateFrequency();
  }

  public static void clearAllFrequencies() {
    for (Code code : Code.values()) {
      code.frequency = 0;
      code.codeType.clearAllFrequencies();
    }
  }

  public int getFrequency() {
    return frequency;
  }

  public void setRelevantTerms(List<Term> terms) {
    matchingTerms = terms;
    generateRegex();
  }

  public void addRelevantTerms(List<Term> terms) {
    matchingTerms.addAll(terms);
    generateRegex();
  }

  public void clearRelevantTerms() {
    matchingTerms.clear();
    regex = null;
    frequency = 0;
  }

  public String generateRegex() {
    if (matchingTerms.isEmpty())
      return null;
    if ((regex != null) && (regex.length() > 0))
      return regex;

    // otherwise generate and set...
    StringBuilder regularExpr = new StringBuilder();
    for (Term term : matchingTerms)
      regularExpr.append(term.getRegex() + Term.PIPE_DELIMITER);
    regularExpr.deleteCharAt(regularExpr.lastIndexOf(Term.PIPE_DELIMITER));

    return (regex = regularExpr.toString());
  }

 @Override
  public String toString() {
    return label;
  }
}
