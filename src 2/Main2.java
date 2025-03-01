import servicos.ServicoAvaliaCao;
import servicos.ServicoItensVenda;
import servicos.ServicoProduto;
import servicos.ServicoVendas;

import java.sql.Date;


public class Main2 {
    public static void main(String[] args) {

          ServicoItensVenda servicoItensVenda = new ServicoItensVenda();

       servicoItensVenda.cadastrarItemVenda(4,2,1,15,5,30);
    }
}
