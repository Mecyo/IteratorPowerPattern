package patterniteratorpower;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Emerson
 */
public class PatternIteratorPower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Aluno> listaAlunos = new ArrayList<>();
        
        for (int i = 0; i < 20; i++) {
            Aluno aluno = new Aluno("Nome" + i, Double.valueOf(i * 10), i * 7);
            listaAlunos.add(aluno);
        }
        
        IteratorSuperPower iterator = new IteratorSuperPower(listaAlunos, "idade", ">", "20");
        
        while(iterator.hasNext()) {
            Aluno aluno = (Aluno) iterator.next();
            System.out.println("Nome: " + aluno.getNome() + " - Altura: " + aluno.getAltura() + " - Idade: " + aluno.getIdade());
        }
        
    }
    
}
