
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoadTester {
    public static void main(String[] args) {
        SchuelerBL bl = new SchuelerBL();
        try {
            bl.load(new File("./klasse.csv"));
        } catch (Exception ex) {
            Logger.getLogger(LoadTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        bl.print();
        
        
}
}
