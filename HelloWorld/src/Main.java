import edu.berkeley.nlp.Test;

public class Main {

    // This method is used to run the main test method!
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Test<MockClass> test = new Test<MockClass>();
        test.main(new String[]{
                "myParameter"
        });
    }
}
