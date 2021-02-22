package at.ac.htlstp.s2020.k5bhet.demoserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "person")
@Data
public class PersonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson", nullable = false)
    private Integer idPerson;

    @Column(name = "vorname", nullable = false)
    private String vorname;

    @Column(name = "familienname", nullable = false)
    private String familienname;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "geburt")
    private Date geburt;

}
