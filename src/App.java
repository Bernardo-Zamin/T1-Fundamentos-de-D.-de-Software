public class App {
    public static void main(String[] args) {
        Consultas poaTemp= new Consultas("poa_temps.txt");
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(poaTemp.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        poaTemp.datasEmQueChouveuMaisDe(90)
            .forEach(System.out::println);
    }
}
