import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToFile implements BibliotekosValdymas{
    private String path = "src/Leidiniai.csv";
    private List<Leidinys> leidiniuSarasas = new ArrayList<>();

    @Override
    public void pridetiNaujaLeidini(Leidinys leidinys) {
        try {
            FileWriter fileWriter = new FileWriter(path, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(leidinys.toString());
            bufferedWriter.newLine();

            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Nepavyko rasyti failo: " + e.getMessage());
        }
    }

    @Override
    public void pasalintiLeidini(String pavadinimas) {
        List<Leidinys> sarasas = getList();

        for (Leidinys s : sarasas){
            if (s.getPavadinimas().equalsIgnoreCase(pavadinimas)){
                sarasas.remove(s);
            }
        }
    }

    @Override
    public Leidinys ieskotiLeidinio(String pavadinimas) {
        List<Leidinys> sarasas = getList();

        for (Leidinys s : sarasas){
            if (s.getPavadinimas().equalsIgnoreCase(pavadinimas)){
               return s;
            }
        }
        return null;
    }

    public List<Leidinys> getList(){
        List<String> failoSarasas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] lineValues = line.split(",");
                failoSarasas.add(Arrays.toString(lineValues));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < failoSarasas.size(); i++) {
            String[] lineValues = failoSarasas.get(i).split(",");
            String pavadinimas = lineValues[0];
            String antras = lineValues[1];
            leidiniuSarasas.add(new Knyga(pavadinimas,antras));
        }
        return leidiniuSarasas;
    }
}
