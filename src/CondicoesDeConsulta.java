import java.util.List;
import java.util.function.Predicate;

public interface CondicoesDeConsulta {
    public String diaQueMaisChoveNoAno(int ano);
    public List<String> datasEmQueChouveuMaisDe(double milimetros);
    public List<String> diasEmQue();
    public void alteraConsultaPadrao(Predicate<RegistroDoTempo> consulta);
}
