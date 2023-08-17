import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Consultas {

    private LeArquivo dados;
    private List<RegistroDoTempo> registros;

    public Consultas(String nomeArquivo){
        dados= new LeArquivo(nomeArquivo);
        registros= new LinkedList<>();
        registros= dados.carregaDados();
    }


    public String diaQueMaisChoveuNoAno(int ano){
        RegistroDoTempo registro = registros
        .stream()
        .filter(reg->reg.getAno() == ano)
        .max(Comparator.comparing(RegistroDoTempo::getPrecipitacao))
        .orElseThrow(IllegalArgumentException::new);
        String resp = registro.getDia()+"/"+registro.getMes()+"/"+registro.getAno()+", "+registro.getPrecipitacao();
        return resp;
    }

    public List<String> datasEmQueChouveuMaisDe(double milimetros){
        return registros
            .stream()
            .filter(r->r.getPrecipitacao() > milimetros)
            .map(r->r.getDia()+"/"+r.getMes()+"/"+r.getAno())
            .toList();
    }
}

