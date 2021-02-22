package at.ac.htlstp.s2020.k5bhet.demoserver.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "adresse")
@Data
public class AdresseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idadresse", nullable = false)
    private Integer idAdresse;

    @Column(name = "strasse", nullable = false, length=40)
    private String strasse;

    @Column(name = "hausnr", nullable = false)
    private Integer hausnr;

    @ManyToOne
    @JoinColumn(name="idort")
    private OrtEntity ort;

}
