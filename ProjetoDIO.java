/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projetodio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author GFS_Mac
 */
public class ProjetoDIO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int escolha = 4;
        ArrayList<Conta> ListaConta = new ArrayList<>();

        // dados populacionais para testes:
        ListaConta.add(new ContaCorrente("001", "João", 123456789));
        ListaConta.add(new ContaPoupanca("002", "Maria", 987654321));
        ListaConta.add(new ContaCorrente("003", "Ana", 127776789));
        ListaConta.add(new ContaPoupanca("002", "Bia", 999654321));
        ListaConta.add(new ContaCorrente("001", "Caio", 123455559));
        ListaConta.add(new ContaPoupanca("002", "Lia", 987611111));

        Scanner teclado = new Scanner(System.in);

        do {
            System.out.println("   * * * Menu inicial * * *\n\nDigite um número para escolher uma categoria:\n\n1 - Funcionário\n2 - Cliente\n\n\n0 - Encerrar o programa");
            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("   | | | Menu funcionário | | |\n\nSelecione a operação desejada:\n\n1 - Abrir uma nova conta\n2 - Consultar um cliente\n3 - Consultar extrato bancário\n4 - Exibir contas cadastradas \n5 - Voltar para menu inicial");
                    int opcao = teclado.nextInt();
                    if (opcao == 1) {
                        System.out.println("\n\n\n| - | - |  ABRIR NOVA CONTA | - | - |  \n\n");
                        System.out.println("\nInforme os dados da nova conta:\n");
                        System.out.println("\nNome do cliente:");
                        String nome = teclado.next();
                        System.out.println("\nCPF do cliente:");
                        int cpf = teclado.nextInt();
                        Cliente clienteNovo = new Cliente(nome, cpf);

                        System.out.println("\nAgência do banco:");
                        String agencia = teclado.next();

                        System.out.println("\nTipo de conta |  C - corrente  |   P - poupança   | :\n");
                        String tipoConta = teclado.next();
                        if (tipoConta.equalsIgnoreCase("C")) {
                            Conta novaConta = new ContaCorrente(agencia, nome, cpf);
                            ListaConta.add(novaConta);
                        } else if (tipoConta.equalsIgnoreCase("P")) {
                            Conta novaConta = new ContaPoupanca(agencia, nome, cpf);
                            ListaConta.add(novaConta);

                        } else {
                            System.out.println("> > > > Opção inválida! < < < <\n\n");
                            System.out.println("-----------------------------");
                        }
                        escolha = 4;
                    }
                    if (opcao == 2) {
                        System.out.println("\n\n\n| - | - |  CONSULTAR DADOS CLIENTE  | - | - |  \n\n");
                        System.out.println("\nInforme o nome do cliente:\n");
                        String nomeBusca = teclado.next();

                        Conta contaEncontrada = null;
                        for (Conta c : ListaConta) {
                            if (c.getNomeCliente().equalsIgnoreCase(nomeBusca)) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada != null) {
                            contaEncontrada.imprimirDados();
                        } else {
                            System.out.println(" > > > > Conta com o nome " + nomeBusca + " não encontrada.\n\n");
                            System.out.println("-----------------------------");
                        }
                        escolha = 4;
                    }
                    if (opcao == 3) {
                        System.out.println("\n\n\n| - | - |  CONSULTAR EXTRATO BANCÁRIO  | - | - |  \n\n");
                        System.out.println("\nInforme o número da conta do cliente:");
                        int contaBusca = teclado.nextInt();

                        Conta contaEncontrada = null;
                        for (Conta c : ListaConta) {
                            if (c.getNumeroConta() == contaBusca) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada != null) {
                            contaEncontrada.imprimirExtrato();
                        } else {
                            System.out.println(" > > > > Conta com o número " + contaBusca + " não encontrada.\n\n");
                            System.out.println("-----------------------------");
                        }
                        escolha = 4;
                    }
                    if (opcao == 4) {
                        System.out.println("\n\n\n| - | - |  LISTA DE CONTAS  | - | - |  \n\n");
                        System.out.println("Total de contas cadastradas: " + ListaConta.size() + "\n");
                        for (Conta conta : ListaConta) {
                            conta.exibirDadosContas();
                            if (conta instanceof ContaCorrente) {
                                ContaCorrente contaCorrente = (ContaCorrente) conta;
                                System.out.println("Limite aprovado: " + contaCorrente.getLimite());
                            }
                            System.out.println("-----------------------------");
                        }
                        escolha = 4;

                    }
                    if (opcao == 5) {
                        escolha = 4;

                    }

                    break;

                case 2:
                    System.out.println("   | | | Menu cliente | | |\n\nSelecione a operação desejada:\n\n1 - Saque\n2 - Depósito\n3 - Transferência\n4 - Consultar extrato bancário\n5 - Voltar para menu inicial");
                    opcao = teclado.nextInt();
                    if (opcao == 1) {
                        System.out.println("\n\n\n| - | - |  SAQUE | - | - |  \n\n");
                        System.out.println("\nInforme o número da conta:\n");
                        int contaBusca = teclado.nextInt();
                        Conta contaEncontrada = null;
                        for (Conta c : ListaConta) {
                            if (c.getNumeroConta() == contaBusca) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada == null) {
                            System.out.println(" > > > > Conta com o número " + contaBusca + " não encontrada. < < < < \n\n");
                            System.out.println("-----------------------------");
                        } else if (contaEncontrada != null) {
                            System.out.println("Informe o valor que deseja sacar:");
                            double valor = teclado.nextDouble();
                            if (contaEncontrada instanceof ContaCorrente) {
                                double saqueDisponivel = (contaEncontrada.getSaldo()) + ((ContaCorrente) contaEncontrada).getLimite();

                                if (valor > saqueDisponivel) {
                                    System.out.println("\n\n > > > >  Saldo insuficiente!  < < < <  ");
                                    System.out.println("\n\n > > > >  Limite insuficiente! Valor disponível para saque: " + saqueDisponivel + " < < < <  ");

                                    System.out.println("-----------------------------");
                                } else if (valor > contaEncontrada.getSaldo()) {
                                    double diferenca = valor - contaEncontrada.getSaldo();
                                    contaEncontrada.setSaldo(0);
                                    ((ContaCorrente) contaEncontrada).setLimite(((ContaCorrente) contaEncontrada).getLimite() - diferenca);
                                    System.out.println("Operação realizada com sucesso!\n\nNovo saldo: " + contaEncontrada.getSaldo());
                                    System.out.println("\nLimite atualizado: " + ((ContaCorrente) contaEncontrada).getLimite());
                                } else if (valor < contaEncontrada.getSaldo()) {
                                    double saque = contaEncontrada.sacar(valor);
                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() - saque);
                                    System.out.println("Operação realizada com sucesso!\n\nNovo saldo: " + contaEncontrada.getSaldo());
                                    System.out.println("\nLimite disponível: " + ((ContaCorrente) contaEncontrada).getLimite());

                                }

                                System.out.println("-----------------------------");
                            }

                            if (contaEncontrada instanceof ContaPoupanca) {
                                if (valor > contaEncontrada.getSaldo()) {
                                    System.out.println("\n\n > > > >  Saldo insuficiente! < < < <  ");
                                    System.out.println("-----------------------------");

                                } else {
                                    double saque = contaEncontrada.sacar(valor);
                                    contaEncontrada.setSaldo(contaEncontrada.getSaldo() - saque);
                                    System.out.println("Operação realizada com sucesso!\n\nNovo saldo: " + contaEncontrada.getSaldo());
                                    System.out.println("-----------------------------");
                                }
                            }
                        }
                        escolha = 4;

                    }

                    if (opcao == 2) {
                        System.out.println("\n\n\n| - | - |  DEPÓSITO | - | - |  \n\n");
                        System.out.println("\nInforme o número da conta:\n");
                        int contaBusca = teclado.nextInt();

                        Conta contaEncontrada = null;
                        for (Conta c : ListaConta) {
                            if (c.getNumeroConta() == contaBusca) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada == null) {
                            System.out.println(" > > > > Conta com o número " + contaBusca + " não encontrada. < < < < \n\n");
                            System.out.println("-----------------------------");
                        } else {
                            System.out.println("Informe o valor que deseja depositar:");
                            double valor = teclado.nextDouble();

                            double novoSaldo = contaEncontrada.depositar(valor);
                            System.out.println("Operação realizada com sucesso!\n\nNovo saldo: " + novoSaldo);
                            System.out.println("-----------------------------");
                        }

                        escolha = 4;

                    }

                    if (opcao == 3) {
                        System.out.println("\n\n\n| - | - |  TRANSFERÊNCIA | - | - |  \n\n");
                        System.out.println("\nInforme o número da conta de origem:\n");
                        int contaOrigem = teclado.nextInt();

                        Conta contaEncontrada = null;
                        for (Conta c : ListaConta) {
                            if (c.getNumeroConta() == contaOrigem) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada == null) {
                            System.out.println("\n\n > > > > Conta com o número " + contaOrigem + " não encontrada. < < < < \n\n");
                            System.out.println("-----------------------------");
                        } else {
                            System.out.println("Informe a conta para receber a transferência:");
                            int contaDestino = teclado.nextInt();
                            Conta novaContaEncontrada = null;
                            for (Conta c : ListaConta) {
                                if (c.getNumeroConta() == contaDestino) {
                                    novaContaEncontrada = c;
                                    break;
                                }
                            }
                            if (novaContaEncontrada == null) {
                                System.out.println("\n\n > > > > Conta com o número " + contaDestino + " não encontrada. < < < <\n\n");
                                System.out.println("-----------------------------");
                            } else {

                                System.out.println("Informe o valor a ser transferido para a conta: " + contaDestino);
                                double valor = teclado.nextDouble();

                                if (contaEncontrada instanceof ContaCorrente) {
                                    double saqueDisponivel = (contaEncontrada.getSaldo()) + ((ContaCorrente) contaEncontrada).getLimite();

                                    if (valor > saqueDisponivel) {
                                        System.out.println("\n\n > > > >  Saldo insuficiente!  < < < <  ");
                                        System.out.println("\n\n > > > >  Limite insuficiente! Valor disponível para transferência: " + saqueDisponivel + " < < < <  ");

                                        System.out.println("-----------------------------");
                                    } else if (valor > contaEncontrada.getSaldo()) {
                                        double diferenca = valor - contaEncontrada.getSaldo();
                                        contaEncontrada.setSaldo(0);
                                        ((ContaCorrente) contaEncontrada).setLimite(((ContaCorrente) contaEncontrada).getLimite() - diferenca);
                                        System.out.println("Operação realizada com sucesso!\n\nNovo saldo da conta de origem: " + contaEncontrada.getSaldo());
                                        System.out.println("\nLimite atualizado: " + ((ContaCorrente) contaEncontrada).getLimite());
                                        novaContaEncontrada.setSaldo(valor + novaContaEncontrada.getSaldo());
                                        System.out.println("\nNovo saldo da conta de destino: " + novaContaEncontrada.getSaldo());

                                    } else if (valor < contaEncontrada.getSaldo()) {
                                        //double saque = contaEncontrada.sacar(valor);
                                        contaEncontrada.setSaldo(contaEncontrada.getSaldo() - valor);
                                        novaContaEncontrada.setSaldo(valor + novaContaEncontrada.getSaldo());

                                        System.out.println("Operação realizada com sucesso!\n\nNovo saldo conta de origem: " + contaEncontrada.getSaldo());
                                        System.out.println("\nLimite disponível: " + ((ContaCorrente) contaEncontrada).getLimite());
                                        System.out.println("\nNovo saldo conta de destino: " + novaContaEncontrada.getSaldo());

                                    }

                                    System.out.println("-----------------------------");
                                }

                                if (contaEncontrada instanceof ContaPoupanca) {
                                    if (valor > contaEncontrada.getSaldo()) {
                                        System.out.println("\n\n > > > >  Saldo insuficiente! < < < <  ");
                                        System.out.println("-----------------------------");

                                    } else {
                                        contaEncontrada.setSaldo(contaEncontrada.getSaldo() - valor);
                                        novaContaEncontrada.setSaldo(valor + novaContaEncontrada.getSaldo());
                                        System.out.println("Operação realizada com sucesso!\n\nNovo saldo conta de origem: " + contaEncontrada.getSaldo());
                                     
                                    }
                                }

                              
                            }

                            escolha = 4;

                        }
                    }

                    if (opcao == 4) {
                        System.out.println("\n\n\n| - | - |  CONSULTAR EXTRATO | - | - |  \n\n");
                        System.out.println("\nInforme o número da conta:\n");
                        int contaBusca = teclado.nextInt();

                        Conta contaEncontrada = null;
                        for (Conta c : ListaConta) {
                            if (c.getNumeroConta() == contaBusca) {
                                contaEncontrada = c;
                                break;
                            }
                        }
                        if (contaEncontrada == null) {
                            System.out.println(" > > > > Conta com o número " + contaBusca + " não encontrada. < < < < \n\n");
                            System.out.println("-----------------------------");
                        } else {
                            contaEncontrada.imprimirExtrato();
                            if (contaEncontrada instanceof ContaCorrente) {
                                ContaCorrente contaCorrente = (ContaCorrente) contaEncontrada;
                                System.out.println("Limite disponível: " + contaCorrente.getLimite());
                            }
                            
                            System.out.println("\n-----------------------------");
                        }

                        escolha = 4;
                    }
                    if (opcao == 5) {
                        escolha = 4;

                    }

                    break;

                case 0:
                    System.out.println("\n\n\n - - - - - - Programa encerrado! - - - - - - \n");
                    System.exit(0);

                default:
                    System.out.println("> > > > Opção inválida! < < < <\n\n");
                    System.out.println("-----------------------------");
                    break;
            }

        } while (escolha != 1 && escolha
                != 2);
        teclado.close();
    }

}
