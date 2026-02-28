import com.sistemabanco.entitys.ContaBancaria;
import java.util.Scanner;


public class SistemaBanco {

    static Scanner scanner = new Scanner(System.in);
    static ContaBancaria[] ListaBanco = new ContaBancaria[10];
    static int escolha;
    static int Idconta = 0;

    public static void main(String[] args) {

        do {
            System.out.println("MENU BANCARIO");
            System.out.println("1 - CRIAR CONTA");
            System.out.println("2 - Listar contas");
            System.out.println("3 - Deposito");
            System.out.println("4 - Saque");
            System.out.println("5 - Realizar Transferencia");
            System.out.println("6 - Sair");
            System.out.println("Digite sua escolha:");
            escolha = scanner.nextInt();
            scanner.nextLine();
            switch (escolha){
                case 1 -> Criarconta();
                case 2 -> ListarConta();
                case 3 -> Depositar();
                case 4 -> Sacar();
                case 5 -> TranferirDinheiro();
                case 6 -> System.out.println("Saindo...");

            }
        }while (escolha != 6);
    }

    public static void Criarconta() {
        System.out.println("Digite Nome");
        String NomeConta = scanner.nextLine();
        ContaBancaria NovaConta = new ContaBancaria();
        NovaConta.setNumeroDaconta(Idconta);
        NovaConta.setNomedaconta(NomeConta);
        ListaBanco[Idconta] = NovaConta;
        System.out.println("Conta criada: " + NomeConta + "ID: " + Idconta);
        Idconta++;
    }
    public static void ListarConta(){
        System.out.println("Lista de contas:");
        for (int i = 0; i < Idconta; i++) {
            System.out.println("Nome :" + ListaBanco[i].getNomedaconta());
            System.out.println("ID :" + ListaBanco[i].getNumeroDaconta());
            System.out.println("Saldo :" + ListaBanco[i].getSaldo());
        }
    }
    public static void Sacar(){
        System.out.println("Sacar Dinheiro");
        System.out.println("Digite o ID da sua conta para Logar nela");
        int ContaID = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < Idconta; i++) {
            if (ListaBanco[i].getNumeroDaconta() == ContaID){
                System.out.println("Conta Logada");
                System.out.println("Nome :" + ListaBanco[i].getNomedaconta());
                System.out.println("ID :" + ListaBanco[i].getNumeroDaconta());
                System.out.println("Saldo :" + ListaBanco[i].getSaldo());
                System.out.println("Digite o valor que deseja sacar");
                int saque = scanner.nextInt();
                scanner.nextLine();
                if (saque > ListaBanco[i].getSaldo()){
                    System.out.println("Saldo insuficiente");
            }
                else{
                    System.out.println("Saque Concluido");
                    ListaBanco[i].setSaldo(ListaBanco[i].getSaldo() - saque);
                }
            }
        }
    }
    public static void Depositar(){
        System.out.println("Depositar Dinheiro");
        System.out.println("Digite o ID da sua conta para Logar nela");
        int ContaID = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < Idconta; i++) {
            if (ListaBanco[i].getNumeroDaconta() == ContaID){
                System.out.println("Conta Logada");
                System.out.println("Nome :" + ListaBanco[i].getNomedaconta());
                System.out.println("ID :" + ListaBanco[i].getNumeroDaconta());
                System.out.println("Saldo :" + ListaBanco[i].getSaldo());
                System.out.println("Digite o valor que deseja Depositar");
                int deposito = scanner.nextInt();
                scanner.nextLine();
                ListaBanco[i].setSaldo(ListaBanco[i].getSaldo() + deposito);

                }
            }
        }
    public static void TranferirDinheiro() {
        System.out.println("DIGITE O ID DA SUA CONTA");
        int conta = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual Conta deseja transferir o dinheiro");
        int id = scanner.nextInt();
        scanner.nextLine();
        int indexOrigem = -1;
        int indexDestino = -1;
        for (int i = 0; i < Idconta; i++) {
            if (ListaBanco[i].getNumeroDaconta() == conta) {
                indexOrigem = i;
            }
            if (ListaBanco[i].getNumeroDaconta() == id) {
                indexDestino = i;
            }
        }
        if (indexOrigem != -1 && indexDestino != -1) {
            if (indexOrigem == indexDestino) {
                System.out.println("Nao é possivel fazer transferencia para si msm");
                return;
            }
            System.out.println("Qual valor deseja transferir");
            int transferencia = scanner.nextInt();
            scanner.nextLine();
            if (ListaBanco[indexOrigem].getSaldo() >= transferencia) {
                ListaBanco[indexOrigem].setSaldo(ListaBanco[indexOrigem].getSaldo() - transferencia);
                ListaBanco[indexDestino].setSaldo(ListaBanco[indexDestino].getSaldo() + transferencia);
                System.out.println("Tranferencia sucedida para " + ListaBanco[indexDestino].getNomedaconta() + " no valor de " + transferencia);
            } else {
                System.out.println("Valor insuficiente");
            }
        } else {
            System.out.println("Conta de origem ou destino nao encontrada");
        }
    }
    }



