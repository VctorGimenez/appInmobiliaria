
package Uegg.appInmobiliaria.repositorios;

import Uegg.appInmobiliaria.entidades.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InmuebleRepositorio extends JpaRepository<Inmueble, Long>{
    
}
