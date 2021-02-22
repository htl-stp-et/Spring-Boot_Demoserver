package at.ac.htlstp.s2020.k5bhet.demoserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ort")
@Data
public class OrtEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idort", nullable = false)
    private Integer idOrt;

    @Column(name = "plz")
    private Integer plz;

    @Column(name = "ortsname")
    private String ortsname;

    @Column(name = "telefon")
    private String telefon;

    @OneToMany(mappedBy = "ort")
    private List<AdresseEntity> adressen = new ArrayList<AdresseEntity>();

}
