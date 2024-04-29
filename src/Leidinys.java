public abstract class Leidinys {
    private String pavadinimas;

    public Leidinys(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    void rodytiInformacija(){
        System.out.println(pavadinimas);
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    @Override
    public String toString() {
        return String.format("%s", this.pavadinimas);
    }
}
