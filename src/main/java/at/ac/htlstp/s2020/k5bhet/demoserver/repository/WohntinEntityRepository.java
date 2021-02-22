package at.ac.htlstp.s2020.k5bhet.demoserver.repository;

import at.ac.htlstp.s2020.k5bhet.demoserver.entity.WohntinEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface WohntinEntityRepository extends JpaRepository<WohntinEntity, Integer>, JpaSpecificationExecutor<WohntinEntity> {

}