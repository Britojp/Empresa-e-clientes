import javax.swing.*;
import java.util.ArrayList;

public class Cliente extends Pessoa {
    ArrayList <Pessoa> clientes = new ArrayList<Pessoa>();
    public boolean status;


    //constructor
    Cliente(String nome, String cpf, String telefone, int idade) {
        super(nome, cpf, telefone, idade);
        this.status = true;
    }

    //get
    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }
        @Override
    public String toString() {

         return "----------- Clientes -----------" + "\n" +
                "Nome: " + getNome() +  "\n" +
                 "CPF: " + getCpf() +  "\n" +
                 "Telefone: " + getTelefone() +  "\n" +
                 "Idade: " + getIdade() + "\n"
                 + "Status do cliente: " + getStatus();
    }

}
