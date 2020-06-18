package web.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //@Autowired
    //EmpleadoRepository usuarioRepository;

	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
	    // Empleado appUser =  usuarioRepository.findById(Integer.parseInt(user)).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));

	    List<GrantedAuthority> roles = new ArrayList<>();
	    GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
	    roles.add(authority);
	    //UserDetails usuario = (UserDetails) new User(String.valueOf(appUser.getCedula()), appUser.getClave(), roles);
	   // System.out.println(usuario);
	     //    return usuario;
	    return null;
	}
}
    
