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
  general(CodeType.Frame),
  machine_learning(CodeType.Frame),
  math_and_statistics(CodeType.Frame),
  visualisation(CodeType.Frame),
  advanced_computing(CodeType.Frame),
  data_skills(CodeType.Frame);
  domain_expertise(CodeType.Frame);
  advanced_computing(CodeType.Frame);


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
