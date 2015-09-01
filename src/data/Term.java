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
  Python(Code.advanced_computing, "python", "(?i)python"),
  AdvancedComputing(Code.advanced_computing, "advanced computing", "(?i)advanced.*computing"),
  Programming(Code.advanced_computing, "programming", "(?i)programming"),
  ComputationalSystems(Code.advanced_computing, "computational systems", "(?i)computational.*systems"),
  Coding(Code.advanced_computing, "coding", "(?i)coding"),
  CloudComputing(Code.advanced_computing, "Cloud computing", "(?i)cloud.*computing"),
  
  Databases(Code.data_skills, "databases", "(?i)databases"),
  DataManagement(Code.data_skills, "data management", "(?i)data.*management"),
  DataEngineering(Code.data_skills, "data engineering", "(?i)data.*engineering)"),
  DataMining(Code.data_skills, "data mining", "(?i)data.*mining"),
  DataFormats(Code.data_skills, "data formats", "(?i)data.*formats"),
  LinkedData(Code.data_skills, "linked data", "(?i)linked.*data"),
  InformationExtraction(Code.data_skills, "information extraction", "(?i)information.*extraction"),
  StreamProcessing(Code.data_skills, "stream processing", "(?i)stream.*processing"),
  
  EnterpriseProcess(Code.domain_expertise, "enterprise process", "(?i)enterprise.*process"),
  BusinessIntelligence(Code.domain_expertise, "business intelligence", "(?i)business.*intelligence"),
  DataAnonymisation(Code.domain_expertise, "data anonymisation", "(?i)data.*anonymisation"),
  Semantics(Code.domain_expertise, "semantics", "(?i)semantics"),
  Schema(Code.domain_expertise, "schema", "(?i)schema"),
  DataLicensing(Code.domain_expertise, "data licensing", "(?i)data.*licensing"),
  DataQuality(Code.domain_expertise, "data quality", "(?i)data.*quality"),
  DataGovernance(Code.domain_expertise, "data governance", "(?i)data.*governance"),
  
  DataScience(Code.general, "data science", "(?i)data.*science"),
  BigData(Code.general, "big data", "(?i)big.*data"),
  OpenData(Code.general, "open data", "(?i)open.*data"),
  
  MachineLearning(Code.machine_learning, "machine learning", "(?i)machine.*learning"),
  SocialNetworkAnalysis(Code.machine_learning, "social network analysis", "(?i)social.*network.*analysis"),
  Inference(Code.machine_learning, "inference", "(?i)inference"),
  Reasoning(Code.machine_learning, "reasoning", "(?i)reasoning"),
  ProcessMining(Code.machine_learning, "process mining", "(?i)process.*mining"),
  
  LinearAlgebra(Code.math_and_statistics, "Linear algebra", "(?i)Linear.*algebra"),
  Calculus(Code.math_and_statistics, "Calculus", "(?i)Calculus"),
  Mathematics(Code.math_and_statistics, "Mathematics", "(?i)Mathematics"),
  Statistics(Code.math_and_statistics, "Statistics", "(?i)Statistics"),
  Probability(Code.math_and_statistics, "Probability", "(?i)Probability"),
  RStudio(Code.math_and_statistics, "RStudio", "(?i)RStudio"),
  DataAnalytics(Code.math_and_statistics, "Data analytics", "(?i)Data.*analytics"),
  DataAnalysis(Code.math_and_statistics, "Data analysis", "(?i)Data.*analysis"),
  
  DataVisualisation(Code.visualisation, "data visualisation", "(?i)data.*visualisation"),
  Infographics(Code.visualisation, "infographics", "(?i)infographics"),
  Interaction(Code.visualisation, "interaction", "(?i)interaction"),
  DataMapping(Code.visualisation, "data mapping", "(?i)data.*mapping"),
  DataStories(Code.visualisation, "data stories", "(?i)data.*stories"),
  DataJournalism(Code.visualisation, "data journalism", "(?i)data.*journalism"),
  D3js(Code.visualisation, "d3js", "(?i)d3.*?js"),
  Tableau(Code.visualisation, "tableau", "(?i)tableau"),
  
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
