import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;


public class Consultas {

    private LeArquivo dados;
    private List<RegistroDoTempo> registros;
    private Predicate<RegistroDoTempo> condicaoTotal;

    public Consultas(String nomeArquivo) {
        dados = new LeArquivo(nomeArquivo);
        registros = new LinkedList<>();
        registros = dados.carregaDados(); //classe Consultas depende da classe LeArquivo 
        condicaoTotal = c -> true;
    }

    public String diaQueMaisChoveuNoAno(int ano) {
        RegistroDoTempo registro = registros
                .stream()
                .filter(reg -> reg.getAno() == ano)
                .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
                .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia() + "/" + registro.getMes() + "/" + registro.getAno() + ", "
                + registro.getPrecipitacao();
        return resp;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros) {
        return registros
                .stream()
                .filter(r -> r.getPrecipitacao() > milimetros)
                .map(r -> r.getDia() + "/" + r.getMes() + "/" + r.getAno())
                .toList();
    }

    public List<String> diasEmQue(){
        return registros
               .stream()
               .filter(condicaoTotal)
               .map(d -> d.getDia() + "/" + d.getMes() + "/" + d.getAno())
               .toList();
    }

    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta){
        this.condicaoTotal = consulta;
    }

}
