public class Knyga extends Leidinys{
    private String autorius;

    public Knyga(String pavadinimas, String autorius) {
        super(pavadinimas);
        this.autorius = autorius;
    }

    public String getAutorius() {
        return autorius;
    }

    public void setAutorius(String autorius) {
        this.autorius = autorius;
    }
    @Override
    public String toString() {
        return super.toString() + String.format(",%s", this.autorius);
    }
}
