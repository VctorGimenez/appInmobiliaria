package Uegg.appInmobiliaria.servicios;

import Uegg.appInmobiliaria.entidades.Inmueble;
import Uegg.appInmobiliaria.enums.Tipo;
import Uegg.appInmobiliaria.excepciones.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Uegg.appInmobiliaria.repositorios.InmuebleRepositorio;
import java.util.Date;
import javax.transaction.Transactional;

@Service
public class inmuebleServicio {

    @Autowired
    private InmuebleRepositorio inmuebleRepositorio;

    @Transactional
    public void crearInmueble(Tipo tipo, String ubicacion, Double superficie, Integer ambientes, String descripcion, Double precioVenta, Double precioAlquiler,
            String tipoOferta) throws MyException {

        Inmueble inmueble = new Inmueble();
        inmueble.setTipo(tipo);
        inmueble.setUbicacion(ubicacion);
        inmueble.setSuperficie(superficie);
        inmueble.setAmbientes(ambientes);
        inmueble.setDescripcion(descripcion);
        inmueble.setPrecioVenta(precioVenta);
        inmueble.setPrecioAlquiler(precioAlquiler);
        inmueble.setDisponibildad(true);
        inmueble.setTipoOferta(tipoOferta);
        inmueble.setFechaAlta(new Date());
        //    agregar   Ente
        inmuebleRepositorio.save(inmueble);

    }

    public void validar(Long id, Tipo tipo, String ubicacion, Double superficie, Integer ambientes, String descripcion, Double precioVenta, Double precioAlquiler,
            String tipoOferta) throws MyException {

        if (id == null) {
            throw new MyException("El id no puede ser nulo");
        }

        if (tipo == null) {
            throw new MyException("El tipo no puede ser nulo");
        } 

        if (ubicacion == null || ubicacion.isEmpty()) {
            throw new MyException("La ubicacion no puede ser nula");
        }

        if (superficie == null) {
            throw new MyException("La superficie no puede ser nula");
        }

        if (ambientes == null) {
            throw new MyException("La cantidad de ambientes no puede ser nula");
        }

        if (tipoOferta == null || tipoOferta.isEmpty()) {
            throw new MyException("El tipo de oferta no puede ser nulo");
        } 
        
        

    }
}
