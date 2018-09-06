package com.castor.database.repositories;

import com.castor.database.entities.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DemoRepository extends JpaRepository<Demo, Long> {

	List<Demo> findAllByName(String name);

}
