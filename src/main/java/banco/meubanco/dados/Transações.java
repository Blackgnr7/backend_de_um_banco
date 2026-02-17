package banco.meubanco.dados;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "transações_de_dinheiro")
public class Transações {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_da_transação;

    private int id_de_quem_vai_receber;
    private int id_de_quem_envio;
}
