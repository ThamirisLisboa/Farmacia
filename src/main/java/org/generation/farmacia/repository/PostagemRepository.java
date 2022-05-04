package org.generation.farmacia.repository;
import java.util.List;

import org.generation.farmacia.model.Postagens;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface PostagemRepository extends JpaRepository<Postagens, Long>{
 public List<Postagens> findAllByTituloContainingIgnoreCase( String titulo);
}
