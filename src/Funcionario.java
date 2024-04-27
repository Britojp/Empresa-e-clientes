import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;


public class Funcionario extends Pessoa {
    ArrayList <Pessoa> funcionario = new ArrayList<Pessoa>();
    private int matricula;
    private float salario;
    private float bonificacao;
    private String pessoa; // pessoa fisica ou pessoa juridica
    private float aumentoSalarial;
    private String funcao;
    static int globalMatricula = 1;



    // constructor without bonificacao
    public Funcionario(String nome, String cpf, String telefone, int idade, String funcao, float salario, String pessoa) {
        super(nome, cpf, telefone, idade);
        this.matricula = globalMatricula++;
        this.funcao = funcao;
        this.salario = salario;
        this.bonificacao = 0;
        this.pessoa = pessoa;
    }

    // constructor
    public Funcionario(String nome, String cpf, String telefone, int idade, String funcao, float salario, float bonificacao, String pessoa) {
        super(nome, cpf, telefone, idade);
        this.matricula = globalMatricula++;
        this.funcao = funcao;
        this.salario = salario;
        this.bonificacao = bonificacao;
        this.pessoa = pessoa;
    }

    // Getters
    public int getMatricula() {
        return matricula;
    }

    public float getSalario() {
        return salario;
    }

    public float getBonificacao() {
        return bonificacao;
    }

    public String isPessoa() {
        return pessoa;
    }
    public String getFuncao() {
        return funcao;
    }

    //Calculo salario anual
    public float calcularSalarioAnual() {
        if (bonificacao != 0) {
            float salarioTotal = salario;
            for (int i = 1; i <= 12; i++) {
                salarioTotal += calcularBonificacao();
            }
            return salarioTotal;
        } else {
            return salario * 12;
        }
    }


    private float calcularBonificacao() {
        return salario * (bonificacao / 100);
    }

    public float aumentoSalarial(){
        return salario = salario * ( 1 + (aumentoSalarial/100));
    }
    @Override
    public String toString() {
           return "Função: " + getFuncao() + "\n"
                    + "Nome: " + getNome() + "\n"
                    + "CPF: " + getCpf() + "\n"
                    + "Telefone: " + getTelefone() + "\n"
                    + "Idade: " + getIdade() + '\n'
                    + "Matrícula: " + getMatricula() + '\n' +
                    "Salário: " + getSalario() + "\n"
                    + "Bonificação mensal: " + getBonificacao() + "\n"
                    + "Tipo de pessoa: " + isPessoa() + '\n' +
                    "Salário anual: " + calcularSalarioAnual()
                    + "\n\n";
        }
}



