package springLiquibase;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

@Repository
public interface mobileRepo extends JpaRepository<Mobile, String>{

}
