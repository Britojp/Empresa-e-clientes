import javax.swing.JOptionPane;
import java.util.Objects;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();

        Funcionario f1 =  new Funcionario("João Pedro", "043.547.771.42","629933305260", 22, "Gerente", 10000f, 30, "Jurídica" );
        funcionarios.add(f1);
        Cliente c1 = new Cliente("Jorge", "058.569.478-00", "899665263", 33);
        Cliente c2 = new Cliente("Clara", "058.569.478-00", "899665263", 54);
        Cliente c3 = new Cliente("Josefa", "058.569.478-00", "899665263", 67);
        Cliente c4 = new Cliente("Maria Eduarda", "085.659.854-69", "8555669635",22);
        clientes.add(c1);
        clientes.add(c2);
        clientes.add(c3);
        clientes.add(c4);



        int input=0;

        while(input==0) {
            input = Integer.parseInt(JOptionPane.showInputDialog("Bem vindo ao APP de controle empresarial \n" +
                    "Escreva qual opção deseja:\n\n" +
                    "1. Cadastrar funcionários\n" +
                    "2. Cadastrar clientes\n" +
                    "3. Mostrar todos os funcionários\n" +
                    "4. Mostrar todos os clientes ativos\n" +
                    "5. Mostrar clientes desativados\n" +
                    "6. Desativar cliente \n\n"));

            if (input == 1) {
                String nome = JOptionPane.showInputDialog("Insira o nome do funcionário");
                String cpf = JOptionPane.showInputDialog("Insira o CPF do funcionário");
                String telefone = JOptionPane.showInputDialog("Qual o telefone do funcionário " + nome + " pela empresa?");
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do funcionário?"));
                String funcao = JOptionPane.showInputDialog("Digite a função do " + nome);
                float salario = Float.parseFloat(JOptionPane.showInputDialog("Digite o salário do funcionário "));
                float bonificacao = 0;
                if (Objects.equals(funcao, "Gerente") || Objects.equals(funcao, "gerente")) {
                    bonificacao = Float.parseFloat(JOptionPane.showInputDialog("Digite a bonificação do gerente (Em %) " + nome));
                }
                String tipoPessoa = JOptionPane.showInputDialog("Digite se é pessoa física ou jurídica");
                Funcionario funcionario = new Funcionario(nome, cpf, telefone, idade, funcao, salario, bonificacao, tipoPessoa);
                funcionarios.add(funcionario);
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
                input = 0;

            }

            if (input == 2) {
                String nome = JOptionPane.showInputDialog("Insira o nome do cliente");
                String cpf = JOptionPane.showInputDialog("Insira o CPF do cliente");
                String telefone = JOptionPane.showInputDialog("Qual o telefone do cliente " + nome);
                int idade = Integer.parseInt(JOptionPane.showInputDialog("Qual a idade do cliente?"));
                Cliente cliente = new Cliente(nome, cpf, telefone, idade);
                clientes.add(cliente);
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                input = 0;
            }

            if (input == 3) {
                int autalIndice = 0;
                while (true) {
                    Funcionario funcionario = funcionarios.get(autalIndice);
                    int option = JOptionPane.showOptionDialog(null, funcionario.toString(),
                            "Mostrar clientes",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[]{"Anterior", "Próximo", "Sair"}, "Anterior");
                    if (option == 0) {
                        autalIndice = (autalIndice - 1 + funcionarios.size()) % funcionarios.size();
                    } else if (option == 1) {
                        autalIndice = (autalIndice + 1) % funcionarios.size();
                    }else{
                        break;
                    }
                }
                input=0;

            }

            if (input == 4) {
                int atualIndice = 0;
                while (true) {
                    Cliente cliente = clientes.get(atualIndice);
                    if (cliente.getStatus()) {
                        int option = JOptionPane.showOptionDialog(null, cliente.toString(),
                                "Mostrar clientes",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                new String[]{"Anterior", "Próximo", "Sair"}, "Anterior");
                        if (option == 0) {
                            atualIndice = (atualIndice - 1 + clientes.size()) % clientes.size();
                        } else if (option == 1) {
                            atualIndice = (atualIndice + 1) % clientes.size();
                        } else {
                            break;
                        }
                    } else {
                        atualIndice = (atualIndice + 1) % clientes.size();
                    }
                }
                input = 0;
            }

            if(input==5){
                int atualIndice = 0;
                while (true) {
                    Cliente cliente = clientes.get(atualIndice);
                    if (!cliente.getStatus()) {
                        int option = JOptionPane.showOptionDialog(null, cliente.toString(),
                                "Mostrar clientes desativados",
                                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                                new String[]{"Anterior", "Próximo", "Sair"}, "Anterior");
                        if (option == 0) {
                            atualIndice = (atualIndice - 1 + clientes.size()) % clientes.size();
                        } else if (option == 1) {
                            atualIndice = (atualIndice + 1) % clientes.size();
                        }else{
                            break;
                        }
                    } else {
                        atualIndice = (atualIndice + 1) % clientes.size();
                    }
                }
                input=0;
            }

            if (input == 6) {
                String nomeCliente = JOptionPane.showInputDialog("Insira o nome do cliente que será desativado");
                boolean EncontradoEDesativado = false;
                for (Cliente cliente : clientes) {
                    if (cliente.getNome().equals(nomeCliente)) {
                        cliente.setStatus(false);
                        EncontradoEDesativado = true;
                        JOptionPane.showMessageDialog(null, "Cliente " + nomeCliente + " foi desativado.");
                        break;
                    }
                }
                if (!EncontradoEDesativado) {
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                }
                input=0;
            }

        }
        }
    }