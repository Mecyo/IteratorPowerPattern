package patterniteratorpower;

/**
 *
 * @author Emerson
 */
public class Aluno {
    
    private String Nome;
    private Integer altura;
    private Integer idade;

    public Aluno(String Nome, Integer altura, Integer idade) {
        this.Nome = Nome;
        this.altura = altura;
        this.idade = idade;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}
