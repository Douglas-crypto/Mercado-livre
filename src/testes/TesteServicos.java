package testes;

import servicos.ServicoItensVenda;


public class TesteServicos {
    public static void main(String[] args) {

        ServicoItensVenda servicoItensVenda = new ServicoItensVenda();

       servicoItensVenda.cadastrarItemVenda(4,2,1,15,5,30);

    }
}
