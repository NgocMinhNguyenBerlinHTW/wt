package de.htwberlin.webtech.webtech.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// Jpa Repository always needs a class that is the Model Entity and a type of the primary key
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
     List<ProductEntity> findAllByName(String name);
}

