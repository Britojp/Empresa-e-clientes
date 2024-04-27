
public class Pessoa {
    private String nome;
    private String cpf;
    private String telefone;
    private int idade;

    // getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone(){
        return telefone;
    }
    public int getIdade(){
        return idade;
    }

    //constructor
    Pessoa(String nome, String cpf, String telefone, int idade){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.idade = idade;
    }


}