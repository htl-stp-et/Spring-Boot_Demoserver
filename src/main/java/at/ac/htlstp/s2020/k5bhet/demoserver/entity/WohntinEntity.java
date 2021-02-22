package at.ac.htlstp.s2020.k5bhet.demoserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "wohntin")
@Data
public class WohntinEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idwohntin", nullable = false)
    private Integer idWohntin;

    @Column(name = "seit")
    private Date seit;

    @Column(name = "idperson")
    private Integer idPerson;

    @Column(name = "idadresse")
    private Integer idAdresse;

}
