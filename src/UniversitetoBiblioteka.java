import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UniversitetoBiblioteka implements BibliotekosValdymas{
    private List<Leidinys> leidiniuSarasas = new ArrayList<>();
    private Scanner scannerStr = new Scanner(System.in);
    private String pavadinimas;
    private boolean veikia;
    private ToFile toFile = new ToFile();

    public void run (){
        System.out.println("1. Bibliotekos sarasas");
        System.out.println("2. Prideti leidini");
        System.out.println("3. Istrinti leidini");
        System.out.println("4. Ieskoti leidinio");
        System.out.println("5. Iseiti");
        veikia = true;
        while (veikia){
            String pasirinkimas = scannerStr.nextLine();
            switch (pasirinkimas){
                case "1":
                    atspauzdintiLeidiniuSarasa();
                    veikia = false;
                    break;
                case "2":
                    sukurtiLeidini();
                    veikia = false;
                    break;
                case "3":
                    System.out.println("Iveskite leidinio pavadinima: ");
                    pavadinimas = scannerStr.nextLine();
                    pasalintiLeidini(pavadinimas);
                    veikia = true;
                    run();
                    break;
                case "4":
                    System.out.println("Iveskite leidinio pavadinima: ");
                    pavadinimas = scannerStr.nextLine();
                    System.out.println(ieskotiLeidinio(pavadinimas));
                    run();
                    break;
                case "5":
                    veikia = false;
                    break;
                default:
                    System.out.println("Blogas pasirinkimas");
                    run();
                    break;
            }
        }

    }

    private void sukurtiLeidini() {
        String pavadinimas;
        while (veikia){
            System.out.println("1. Zurnalas");
            System.out.println("2. Knyga");
            System.out.println("3. Gryzti atgal");
            String pasirinkimas = scannerStr.nextLine();

            switch (pasirinkimas){
                case "1":
                    System.out.print("Iveskite pavadinima: ");
                    pavadinimas = scannerStr.nextLine();
                    System.out.print("Iveskite isleidimo data: ");
                    System.out.print("Isleidimo metai: ");
                    String isleidimoData = scannerStr.nextLine();
                    pridetiNaujaLeidini(new Zurnalas(pavadinimas,isleidimoData));
                    veikia = false;
                    run();
                    break;
                case "2":
                    System.out.print("Iveskite pavadinima: ");
                    pavadinimas = scannerStr.nextLine();
                    System.out.println("Iveskite autoriu:");
                    String autorius = scannerStr.nextLine();
                    pridetiNaujaLeidini(new Knyga(pavadinimas,autorius));
                    veikia = false;
                    run();
                    break;
                case "3":
                    veikia = false;
                    run();
                    break;
                default:
                    System.out.println("Blogas pasirinkimas");
                    break;
            }
        }
    }

    private void atspauzdintiLeidiniuSarasa() {
        if (leidiniuSarasas.isEmpty()){
            System.out.println("Sarasas tuscias!");
        } else {
            for (int i = 0; i < leidiniuSarasas.size(); i++){
                System.out.println(leidiniuSarasas.get(i));
            }
        }
//        List<Leidinys> leidinys = toFile.getList();
//        for (int i = 0; i < leidinys.size(); i++){
//            System.out.println(leidinys.get(i));
//        }
        run();
    }

    @Override
    public void pridetiNaujaLeidini(Leidinys leidinys) {
        leidiniuSarasas.add(leidinys);
        toFile.pridetiNaujaLeidini(leidinys);
    }

    @Override
    public void pasalintiLeidini(String pavadinimas) {
        leidiniuSarasas.removeIf(leidinys -> leidinys.getPavadinimas().equalsIgnoreCase(pavadinimas));
        //toFile.pasalintiLeidini(pavadinimas);
    }

    @Override
    public Leidinys ieskotiLeidinio(String pavadinimas) {
        if (leidiniuSarasas.isEmpty()){
            System.out.println("Sarasas tusciaas!");
        }else {
            for (Leidinys l : leidiniuSarasas){
                if (l.getPavadinimas().equalsIgnoreCase(pavadinimas)){
                    return l;
                }
            }
        }
        return null;
    }
}
