package jorge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jogonzal on 10/31/2015.
 */
public class PseudoWordClassifier {

    private static String decimalDescriptor = "<decimal>";
    private static String dateDescriptor = "<date>";
    private static String fourDigitNumDescriptor = "<fourdigit>";
    private static String numDescriptor = "<num>";
    private static String uppercaseDotDescriptor = "<uppercasedot>";
    private static String initCapDescriptor = "<initcap>";
    private static String uppercaseDescriptor = "<uppercase>";
    private static String lowercaseDescriptor = "<lowercase>";
    private static String otherDescriptor = "<other>";

    private static String decimalRegexString = "[\\d,]+\\.\\d*";
    private static String dateRegexString = "\\d+/\\d+/\\d+";
    private static String fourDigitNumRegexString = "\\d\\d\\d\\d";
    private static String numRegexString = "\\d+";
    private static String upperCaseDotString = "[A-Z]+\\.";
    private static String initCapString = "[A-Z][a-z]*";
    private static String upperCaseString = "[A-Z]+";
    private static String lowercaseString = "[a-z]+";

    private static Pattern decimalRegex = Pattern.compile(decimalRegexString);
    private static Pattern dateRegex = Pattern.compile(dateRegexString);
    private static Pattern fourDigitNumRegex = Pattern.compile(fourDigitNumRegexString);
    private static Pattern numRegex = Pattern.compile(numRegexString);
    private static Pattern upperCaseDot = Pattern.compile(upperCaseDotString);
    private static Pattern initCap = Pattern.compile(initCapString);
    private static Pattern upperCase = Pattern.compile(upperCaseString);
    private static Pattern lowercase = Pattern.compile(lowercaseString);

    private static class PatternMap{
        public String name;
        public Pattern pattern;
        public PatternMap(String Name, Pattern pattern2){
            name = Name;
            pattern = pattern2;
        }
    }

    private static final ArrayList<PatternMap> patternMap;
    static{
        patternMap = new ArrayList<PatternMap>();
        patternMap.add(new PatternMap(decimalDescriptor, decimalRegex));
        patternMap.add(new PatternMap(dateDescriptor, dateRegex));
        patternMap.add(new PatternMap(fourDigitNumDescriptor, fourDigitNumRegex));
        patternMap.add(new PatternMap(numDescriptor, numRegex));
        patternMap.add(new PatternMap(uppercaseDotDescriptor, upperCaseDot));
        patternMap.add(new PatternMap(initCapDescriptor, initCap));
        patternMap.add(new PatternMap(uppercaseDescriptor, upperCase));
        patternMap.add(new PatternMap(lowercaseDescriptor, lowercase));
    }

    public static String GetPseudoWord(String word) {
        for (PatternMap p : patternMap) {
            Pattern pattern = p.pattern;
            String bucket = p.name;
            Matcher m = pattern.matcher(word);
            if (m.matches()){
                return bucket;
            }
        }
        return otherDescriptor;
    }
}
