package br.com.livrinhodavovo.api.Repository;

import br.com.livrinhodavovo.api.models.Receitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReceitasRepository extends JpaRepository<Receitas, Long> {

    List<Receitas> findByCategoria(String categoria);

    @Query("SELECT r FROM Receitas r ORDER BY r.custoProducao DESC")
    List<Receitas> findTop10ReceitasMaisCaras();
}
