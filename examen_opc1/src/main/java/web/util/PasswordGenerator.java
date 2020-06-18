package web.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(4);


    public String encriptador(String password) {

        return encoder.encode(password);
        
    }
	/*public static void main(String ...args) {
		PasswordGenerator p = new PasswordGenerator();
		
		System.out.println(p.encriptador("1234"));
	}*/
    
}