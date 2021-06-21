package izzi.ssorhh.users.util;


import izzi.ssorhh.users.service.IGposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS GRUPOS.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */

@Component
public class CreateGpos implements CommandLineRunner{
	
	@Autowired
	IGposService gpoService;

	@Override
	public void run(String... args) throws Exception {
		
		/**Grupos gpoBajas = new Grupos(GpoNombre.BAJAS);
		Grupos gpoDenuncias = new Grupos(GpoNombre.DENUNCIAS);
		Grupos gpoUsuarios = new Grupos(GpoNombre.USUARIOS);
	    gpoService.save(gpoBajas);
	    gpoService.save(gpoDenuncias);
	    gpoService.save(gpoUsuarios);
		 **/
	}

}
