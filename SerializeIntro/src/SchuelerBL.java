
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

public class SchuelerBL extends AbstractListModel{

    private LinkedList<Schueler>schueler = new LinkedList<>();
    
    
    public void add(Schueler s){
        schueler.add(s);
        fireIntervalAdded(this, 0, schueler.size()-1);
    }
    
    @Override
    public int getSize() {
        return schueler.size();
    }

    @Override
    public Object getElementAt(int index) {
        return schueler.get(index);
    }
    
    public void load(File f)throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while((line = br.readLine())!=null){
            String[]parts = line.split(";");
            add(new Schueler(parts[0],LocalDate.parse(parts[1], DateTimeFormatter.ISO_DATE)));
        }
    }
    public void save(File f)throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        for (Schueler s : schueler) {
            bw.write(s.getName());
            bw.write(";");
            bw.write(s.getBirthday().toString());
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
    
    public void print(){
        for (Schueler s : schueler) {
            System.out.println(s.toString());
        }
    }

}
