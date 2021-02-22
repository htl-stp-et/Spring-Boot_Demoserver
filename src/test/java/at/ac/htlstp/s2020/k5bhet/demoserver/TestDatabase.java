package at.ac.htlstp.s2020.k5bhet.demoserver;


import at.ac.htlstp.s2020.k5bhet.demoserver.service.AdressService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDatabase {

    @Autowired
    private AdressService adressService;

    @Test
    public void testDB1() {
        System.out.println(adressService.getOrtsnameFromAdressID(1));

    }

}
