//Categoria, Mensaje, Reservacion, Cliente , Ortesis
//1.Modelo o Entidad
//2.Interface
//3.Repositorio
//4.Servicios
//5.Controlador o Web

// reportes status, fechas y clientes



package tutoria.domingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"tutoria.domingo.modelo"})
public class Reto5Application {

	public static void main(String[] args) {
		SpringApplication.run(Reto5Application.class, args);
	}

}
