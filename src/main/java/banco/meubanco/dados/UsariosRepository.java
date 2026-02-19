package banco.meubanco.dados;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsariosRepository extends JpaRepository<Usuario,Long>{
    List<Usuario> findByNome(String nome);
    List<Usuario> findById(int id);
}
