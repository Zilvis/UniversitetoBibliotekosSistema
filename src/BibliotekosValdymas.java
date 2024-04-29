public interface BibliotekosValdymas {
    void pridetiNaujaLeidini(Leidinys leidinys);
    void pasalintiLeidini(String pavadinimas);
    Leidinys ieskotiLeidinio(String pavadinimas);
}
