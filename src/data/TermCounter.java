package data;

import org.apache.commons.io.FileUtils;
import parseutil.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: aba-sah
 * Date: 18/02/2013
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 */
public class TermCounter {

  private String  post,
                  statusId,
                  creationDate;
  private long creationTime;
  private int matchCount;
  private Map<Term, Integer> terms;
  private String regex;

  public TermCounter(String entry, String id, String timeStamp, String timezoneId) throws ParseException {
    post = entry;
    statusId = id;
    creationTime = getTimeInMillis(creationDate = timeStamp, timezoneId);
    matchCount = 0;

    terms = new HashMap<Term, Integer>();
    for (Term term : Term.values())
      terms.put(term, 0);

    regex = Term.getLineRegex();
    parseEntry(false);
  }

  private void parseEntry(boolean printOutputToErr) throws ParseException {
    boolean found = false;

//    String  regex = "(#?curiosity)|" +
//                    "(MSL)|" +
//                    "(@marscuriosity)|" +
//                    "((7|seven).*(terror))";

    Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    Matcher matcher = pattern.matcher(post);

    String match;
    try {
      while (matcher.find()) {
        found = true;
        matchCount++;

        int matcherGroupID;
        for (Term term : Term.values()) {
          match = matcher.group(matcherGroupID = term.getMatcherGroupId());

          if ((match == null) || match.equals(""))
            continue;

          if (printOutputToErr)
            System.err.println("Term '" + term + "' with match:\t'" + matcher.group(matcherGroupID) + "'");
          updateTermCounter(term);
          break;  // only one match per loop
        }
      }

      if (printOutputToErr) {
        System.err.println("\nTotal no. of matches: " + matchCount + "\n");
         for (Term term : Term.values())
          System.err.println("Term '" + term + "' - frequency:\t" + getFrequency(term));
      }

      if(!found)
        throw new ParseException(post);

    } catch (Exception e) { // playing safe... shouldn't happen but some Unicode x'ters may throw an exception...
      throw new ParseException(post);
    }
  }

  public void updateTermCounter(Term term) {
    terms.put(term, (terms.get(term) + 1));

    for (Term currentTerm : Term.values()) {
      if (term == currentTerm) {
        term.updateFrequency();
        break;
      }
    }
  }

  public String getPost() {
    return post;
  }

  public int getFrequency(Term term) {
    return terms.get(term);
  }

  public Map<Term, Integer> getTermFrequencies() {
    return terms;
  }

  public String getStatusId() {
    return statusId;
  }

  private int getMatchCount() {
    return matchCount;
  }

  public String getCreationDate() {
    return creationDate;
  }

  public long getTimeInMillis(String timestamp, String timezoneId) {
//      // format -  Sat Aug 04 19:11:10 BST 2012

    return -1;

//    TimeZone timeZone;
    //@todo - check if contained in timestamp ...
//    if (timezoneId != null)
//      timeZone = TimeZone.getTimeZone(timezoneId);
//    else
//      timeZone = TimeZone.getDefault();//TimeZone.getTimeZone(TimeZone.getAvailableIDs(0)[0]);  // UTC

//    try {
//
//      Calendar timestamp = Calendar.getInstance(timeZone);
//      timestamp.set(Integer.parseInt(dateParts[2]),
//        Month.getMonthFieldAsInt(dateParts[1]),
//        Integer.parseInt(dateParts[0]),
//        Integer.parseInt(timeParts[0]),
//        Integer.parseInt(timeParts[1]),
//        Integer.parseInt(timeParts[2])
//      );
//      // set milliseconds as aplicable...
//      if (timeWithMillisecsParts.length > 1)
//        timestamp.set(Calendar.MILLISECOND, Integer.parseInt(timeWithMillisecsParts[1].substring(1)));
//      else
//        timestamp.set(Calendar.MILLISECOND, 0);
//      return timestamp.getTimeInMillis();
//
//    } catch (NumberFormatException e) {
//      return -1;
//    } catch (IndexOutOfBoundsException e) {
//      return -1;
//    }
  }

  @Override // as csv... post, term0, term1, ... term_n
  public String toString() {
    StringBuilder asStr = new StringBuilder(post.concat(","));
    for (Term term : Term.values())
      asStr.append(getFrequency(term) + ",");

    return asStr.substring(0, asStr.lastIndexOf(","));
  }


  public static List<TermCounter> generateCsvDump(String filePath) throws IOException {
    List<TermCounter> output = new ArrayList<TermCounter>();

    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String line;
    String [] entries;

    while ((line = reader.readLine()) != null) {
      if (line.startsWith("SELECT statusid")) // ignore header...
        continue;

      entries = line.split(","); // only interested in first three for now...
      try {
        output.add(new TermCounter(entries[2], entries[0], entries[1], null));

      } catch (IndexOutOfBoundsException e) {
        try {
          throw new ParseException(line);
        } catch (ParseException e1) {
          System.err.println(e.getMessage());
        }

      } catch (ParseException e) {
        System.err.println(e.getMessage());
      }
    }
    reader.close();

    return output;
  }

  public static String generateCsvDump(List<TermCounter> output) {
    StringBuilder dump = new StringBuilder("statusid, createdat,post,");
    for (Term term : Term.values())
      dump.append(term.toString().concat(","));
    dump.deleteCharAt(dump.lastIndexOf(","))
        .append("\n");

    for (TermCounter entry : output)
      dump.append(entry.getStatusId() + "," + entry.getCreationDate() + "," + entry + "\n");

    return dump.toString();
  }

  public static void writeToCsvDump(String filePath, List<TermCounter> output) throws IOException {
    FileUtils.writeStringToFile(new File(filePath), generateCsvDump(output));
  }
}
