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
            Aluno aluno = new Aluno("Nome" + i, i * 10, i * 7);
            listaAlunos.add(aluno);
        }
        
//        System.out.println("Alunos com idade > 20:\n\n\n");
//        IteratorSuperPower iterator = new IteratorSuperPower(listaAlunos, "idade", ">", 200);
//        
//        while(iterator.hasNext()) {
//            Aluno aluno = (Aluno) iterator.next();
//            System.out.println("Nome: " + aluno.getNome() + " - Altura: " + aluno.getAltura() + " - Idade: " + aluno.getIdade());
//        }
//        
//        System.out.println("Alunos com idade < 20:\n\n\n");
//        
//        IteratorSuperPower iterator2 = new IteratorSuperPower(listaAlunos, "idade", "<", 10);
//        
//        while(iterator2.hasNext()) {
//            Aluno aluno = (Aluno) iterator2.next();
//            System.out.println("Nome: " + aluno.getNome() + " - Altura: " + aluno.getAltura() + " - Idade: " + aluno.getIdade());
//        }
        
        System.out.println("Alunos com idade == 20:\n\n\n");
        
        IteratorSuperPower iterator3 = new IteratorSuperPower(listaAlunos, "idade", "!=", 14);
        
        while(iterator3.hasNext()) {
            Aluno aluno = (Aluno) iterator3.next();
            System.out.println("Nome: " + aluno.getNome() + " - Altura: " + aluno.getAltura() + " - Idade: " + aluno.getIdade());
        }
        
//        System.out.println("Alunos com idade != 20:\n\n\n");
//        
//        IteratorSuperPower iterator4 = new IteratorSuperPower(listaAlunos, "idade", "!=", 10);
//        
//        while(iterator4.hasNext()) {
//            Aluno aluno = (Aluno) iterator4.next();
//            System.out.println("Nome: " + aluno.getNome() + " - Altura: " + aluno.getAltura() + " - Idade: " + aluno.getIdade());
//        }
        
    }
    
}
