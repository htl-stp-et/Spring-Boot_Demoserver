package at.ac.htlstp.s2020.k5bhet.demoserver.service;

import at.ac.htlstp.s2020.k5bhet.demoserver.entity.AdresseEntity;
import at.ac.htlstp.s2020.k5bhet.demoserver.repository.AdresseEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdressService {

    @Autowired
    private AdresseEntityRepository adresseEntityRepository;

    public String getOrtsnameFromAdressID(int idAdresse) {
        AdresseEntity adresseEntity = adresseEntityRepository.findByIdAdresse(idAdresse).orElse(null);
        if (adresseEntity!=null) return adresseEntity.getOrt().getOrtsname();
        return null;
    }

}
