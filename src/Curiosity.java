import data.Code;
import data.CodeType;
import data.Term;
import data.TermCounter;
import parseutil.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: aba-sah
 * Date: 18/02/2013
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class Curiosity {

  public static void main(String[] args) throws ParseException, IOException {

    String parentDir = "/Users/aba-sah/Documents/publications/due_2013/www2013/msm2013/data/coding_exercise/coding_samples_2000/";//2000RAND6Aug/";//

    List<String> termFrequencies = new ArrayList<String>(),
                  codingFrameFrequencies = new ArrayList<String>(),
                  frameTypeFrequencies = new ArrayList<String>();
    Map<String, String> tmp;
    String  label = "date_range_aug0"; //"aug_06"; //
    int labelValue = 4;//0;//

    for (File inputFile : new File(parentDir).listFiles()) {
      if (inputFile.isDirectory() || inputFile.isHidden())
        continue;

//      TermCounter.writeToCsvDump(parentDir.concat("parsed/" + "extended_multilingual_" + inputFile.getName()),
                                                  TermCounter.generateCsvDump(inputFile.getAbsolutePath());//);
      tmp = Term.getFrequenciesAsCsvDump(label, label.concat(""/*_q*/ + labelValue++), true);
      termFrequencies.add(tmp.get(Term.class.getSimpleName()));
      codingFrameFrequencies.add(tmp.get(Code.class.getSimpleName()));
      frameTypeFrequencies.add(tmp.get(CodeType.class.getSimpleName()));
      Term.clearAllFrequencies();
    }

    Term.writeFrequenciesToCsvDump(Arrays.asList(Term.values()), parentDir.concat("parsed/term_frequencies" + System.currentTimeMillis() + ".csv"), label, termFrequencies);
    Term.writeFrequenciesToCsvDump(Arrays.asList(Code.values()), parentDir.concat("parsed/code_frequencies" + System.currentTimeMillis() + ".csv"), label, codingFrameFrequencies);
    Term.writeFrequenciesToCsvDump(Arrays.asList(CodeType.values()), parentDir.concat("parsed/code_type_frequencies" + System.currentTimeMillis() + ".csv"), label, frameTypeFrequencies);
    //    Term.writeFrequenciesToCsvDump("date", label, parentDir.concat("parsed/term_frequencies_total_" + System.currentTimeMillis() + ".csv"));
  }
}
