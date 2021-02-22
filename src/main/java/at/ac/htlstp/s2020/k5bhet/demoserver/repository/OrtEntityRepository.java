package at.ac.htlstp.s2020.k5bhet.demoserver.repository;

import at.ac.htlstp.s2020.k5bhet.demoserver.entity.OrtEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrtEntityRepository extends JpaRepository<OrtEntity, Integer>, JpaSpecificationExecutor<OrtEntity> {

}