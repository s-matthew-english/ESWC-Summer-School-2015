package data;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: aba-sah
 * Date: 18/02/2013
 * Time: 17:15
 * To change this template use File | Settings | File Templates.
 */
public enum Term {

  //English 
  Python(Code.advanced_computing, "python", "(python)"),
  AdvancedComputing(Code.advanced_computing, "advanced computing", "(advanced computing)"),
  Programming(Code.advanced_computing, "programming", "(programming)"),
  ComputationalSystems(Code.advanced_computing, "computational systems", "(computational systems)"),
  Coding(Code.advanced_computing, "coding", "(coding)"),
  CloudComputing(Code.advanced_computing, "Cloud computing", "(\\Cloud computing)"),
  
  Databases(Code.data_skills, "databases", "(databases)"),
  DataManagement(Code.data_skills, "data management", "(data management)"),
  DataEngineering(Code.data_skills, "data engineering", "(data engineering)"),
  DataMining(Code.data_skills, "data mining", "(data mining)"),
  DataFormats(Code.data_skills, "data formats", "(data formats)"),
  LinkedData(Code.data_skills, "linked data", "(\\linked data)"),
  InformationExtraction(Code.data_skills, "information extraction", "(information extraction)"),
  StreamProcessing(Code.data_skills, "stream processing", "(stream processing)"),
  
  EnterpriseProcess(Code.domain_expertise, "enterprise process", "(enterprise process)"),
  BusinessIntelligence(Code.domain_expertise, "business intelligence", "(business intelligence)"),
  DataAnonymisation(Code.domain_expertise, "data anonymisation", "(data anonymisation)"),
  Semantics(Code.domain_expertise, "semantics", "(semantics)"),
  Schema(Code.domain_expertise, "schema", "(schema)"),
  DataLicensing(Code.domain_expertise, "data licensing", "(data licensing)"),
  DataQuality(Code.domain_expertise, "data quality", "(data quality)"),
  DataGovernance(Code.domain_expertise, "data governance", "(data governance)"),
  
  DataScience(Code.general, "data science", "(data science)"),
  BigData(Code.general, "big data", "(big data)"),
  OpenData(Code.general, "open data", "(open data)"),
  
  MachineLearning(Code.machine_learning, "machine learning", "(machine learning)"),
  SocialNetworkAnalysis(Code.machine_learning, "social network analysis", "(social network analysis)"),
  Inference(Code.machine_learning, "inference", "(inference)"),
  Reasoning(Code.machine_learning, "reasoning", "(reasoning)"),
  ProcessMining(Code.machine_learning, "process mining", "(process mining)"),
  
  LinearAlgebra(Code.math_and_statistics, "Linear algebra", "(Linear algebra)"),
  Calculus(Code.math_and_statistics, "Calculus", "(Calculus)"),
  Mathematics(Code.math_and_statistics, "Mathematics", "(Mathematics)"),
  Statistics(Code.math_and_statistics, "Statistics", "(Statistics)"),
  Probability(Code.math_and_statistics, "Probability", "(Probability)"),
  RStudio(Code.math_and_statistics, "RStudio", "(RStudio)"),
  DataAnalytics(Code.math_and_statistics, "Data analytics", "(Data analytics)"),
  DataAnalysis(Code.math_and_statistics, "Data analysis", "(Data analysis)"),
  
  DataVisualisation(Code.visualisation, "data visualisation", "(data visualisation)"),
  Infographics(Code.visualisation, "infographics", "(infographics)"),
  Interaction(Code.visualisation, "interaction", "(interaction)"),
  DataMapping(Code.visualisation, "data mapping", "(data mapping)"),
  DataStories(Code.visualisation, "data stories", "(data stories)"),
  DataJournalism(Code.visualisation, "data journalism", "(data journalism)"),
  D3js(Code.visualisation, "d3js", "(d3js)"),
  Tableau(Code.visualisation, "tableau", "(tableau)"),
  
  //Deutsch
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
//  Coding(Code.advanced_computing, "coding", "(coding)"),
 
  ;
  /*
   Landing("Landing", "(\\bland)"),  // allows match to, e.g., "landen" (multi-lingual in concept diag highs) - see "Marte" below
  Landen("Landen", "(\\blanden)"),  // allows match to, e.g., "landen" (multi-lingual in concept diag highs) - see "Marte" below
 */

  public static final String PIPE_DELIMITER = "\u007c";  //" | " - play safe, in some cases needs escaping or searches for empty string
  private String  term,
                  regex;
  private int matcherGroupId,
              frequency;
  private Code codingFrame;


  private Term(Code code, String regularExpr) {
    init(code, name(), regularExpr, ordinal() + 1);
  }

  private Term(Code code, String value, String regularExpr) {
    init(code, value, regularExpr, ordinal() + 1);
  }

  private Term(Code code, String value, String regularExpr, int groupId) {
    init(code, value, regularExpr, groupId);
  }

  private void init(Code code, String value, String regularExpr, int groupId) {
    term = value;
    codingFrame = code;

    regex = regularExpr;
    matcherGroupId = groupId;

    frequency = 0;
  }

  public String getTerm() {
    return term;
  }

  public Code getCodingFrame() {
    return codingFrame;
  }

  /*
   * gives a case-insensitive regex - Pattern.compile MUST set the flag...
   */
  public String getRegex() {
    return regex;
  }

  public int getMatcherGroupId() {
    return matcherGroupId;
  }

  public void updateFrequency() {
    frequency++;
    codingFrame.updateFrequency();
  }

  public static void clearAllFrequencies() {
    for (Term term : Term.values()) {
      term.frequency = 0;
      term.codingFrame.clearAllFrequencies();
    }
  }

  public int getFrequency() {
    return frequency;
  }

  public static String getLineRegex() {
    StringBuilder regularExpr = new StringBuilder();
    for (Term term : Term.values())
      regularExpr.append(term.regex + PIPE_DELIMITER);

    // chop off trailing |
    return regularExpr.substring(0, regularExpr.lastIndexOf(PIPE_DELIMITER));
  }

  public static Map<String,String> getFrequenciesAsCsvDump(String label, String labelValue, boolean omitHeader) {
    StringBuilder dump = new StringBuilder(),
                  codingFrameDump = new StringBuilder(),
                  frameTypeDump = new StringBuilder();
    if (!omitHeader) {  // recording the frame info only makes sense if writing out the headers... for summaries rather than detail...
      if ((label != null) && (label.length() > 0)) {
        dump.append(label.concat(","));
        codingFrameDump.append(label.concat(","));
        frameTypeDump.append(label.concat(","));
      }

      for (Term term : Term.values())
        dump.append(term.toString().concat(","));
      dump.deleteCharAt(dump.lastIndexOf(","))
          .append("\n");

      // codingFrame ...
      for (Code codingFrame : Code.values())
        codingFrameDump.append(codingFrame.toString().concat(","));
      codingFrameDump.deleteCharAt(codingFrameDump.lastIndexOf(","))
                      .append("\n");

      // frameType ...
      for (CodeType codeType : CodeType.values())
        frameTypeDump.append(codeType.toString().concat(","));
      frameTypeDump.deleteCharAt(frameTypeDump.lastIndexOf(","))
                    .append("\n");
    }

    if ((label != null) && (label.length() > 0)) {
      if ((labelValue == null) || (labelValue.length() == 0))
        labelValue = label;
      dump.append(labelValue.concat(","));
      codingFrameDump.append(labelValue.concat(","));
      frameTypeDump.append(labelValue.concat(","));
    }

    // and dump frequencies ...
    for (Term term : Term.values())
      dump.append(term.getFrequency() + ",");
    dump.deleteCharAt(dump.lastIndexOf(","));

//    if (!omitHeader) {
      for (Code code : Code.values())
        codingFrameDump.append(code.getFrequency() + ",");
      codingFrameDump.deleteCharAt(codingFrameDump.lastIndexOf(","));
      for (CodeType codeType : CodeType.values())
        frameTypeDump.append(codeType.getFrequency() + ",");
      frameTypeDump.deleteCharAt(frameTypeDump.lastIndexOf(","));
//    }

    Map<String,String> dumps = new HashMap<String,String>();
    dumps.put(Term.class.getSimpleName(), dump.toString());
    dumps.put(Code.class.getSimpleName(), codingFrameDump.toString());
    dumps.put(CodeType.class.getSimpleName(), frameTypeDump.toString());
    return dumps;
//    return dump.toString();
  }

//  public static void writeFrequenciesToCsvDump(String label, String labelValue, String filePath) throws IOException {
//    FileUtils.writeStringToFile(new File(filePath), getFrequenciesAsCsvDump(label, labelValue, false).get(Term.class.getSimpleName()));
//  }

  public static void writeFrequenciesToCsvDump(List<? extends Enum> headers, String filePath, String label, List<String> frequencies) throws IOException {
    // need to generate header first...
    StringBuilder dump = new StringBuilder();
    if ((label != null) && (label.length() > 0))
      dump.append(label.concat(","));
//    for (Term term : Term.values())
//      dump.append(term.toString().concat(","));
    for (Enum header : headers)
      dump.append(header.toString().concat(","));
    dump.deleteCharAt(dump.lastIndexOf(","));

    frequencies.add(0, dump.toString());
    FileUtils.writeLines(new File(filePath), frequencies);
  }

  @Override
  public String toString() {
    return term;
  }
}
