public class App {
    public static void main(String[] args) {
        Consultas poaTemp = new Consultas("poa_temps.txt");
        System.out.println("Dia em que mais choveu no ano de 1980: ");
        System.out.println(poaTemp.diaQueMaisChoveuNoAno(1980));
        System.out.println("Datas em que choveu mais de 90 milimetros");
        poaTemp.datasEmQueChouveuMaisDe(90)
                .forEach(System.out::println);
        
        System.out.println(poaTemp.diasEmQue());
        System.out.println("------------------------------------------------");
        poaTemp.alteraConsultaPadrao(c -> c.getDia() == 25 && c.getMes() == 2 && c.getAno() == 2016);
        System.out.println(poaTemp.diasEmQue());
        
        CondicoesDeConsulta geracaoAlpha = con -> con.getAno() >= 2010 && con.getAno() <= 2024; // exemplo qualquer para teste
        System.out.println(geracaoAlpha);
        

    }

    
}
