package jorge;

/**
 * Created by jogonzal on 10/31/2015.
 */
public class ObtainLastNCharacters {
    public static String ObtainLastNCharacters(String word, int n){
        int length = word.length();
        if (length >= n){
            return word.substring(word.length() - n, word.length());
        } else {
            String returnValue = "";
            for  (int i = 0; i < n - word.length(); i++){
                returnValue += "<NOCHAR>";
            }
            return returnValue + word;
        }
    }
}