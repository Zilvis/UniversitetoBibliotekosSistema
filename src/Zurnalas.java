import java.time.LocalDate;

public class Zurnalas extends Leidinys{
    private String isleidimoData;

    public Zurnalas(String pavadinimas, String isleidimoData) {
        super(pavadinimas);
        this.isleidimoData = isleidimoData;
    }

    public String getIsleidimoData() {
        return isleidimoData;
    }

    public void setIsleidimoData(String isleidimoData) {
        this.isleidimoData = isleidimoData;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(",%s", this.isleidimoData);
    }
}
