package banco.meubanco.dados;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "transações_de_dinheiro")
public class Transações {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_da_trasação;

    private long id_de_quem_vai_receber;
    private long id_de_quem_envio;
    private BigDecimal dinheiro_enviado;
}
