package co.com.ias.training.ServicioMantenimiento.controller;

import co.com.ias.training.ServicioMantenimiento.controller.models.ServicioDTO;
import co.com.ias.training.ServicioMantenimiento.controller.models.ServicioInput;
import co.com.ias.training.ServicioMantenimiento.domain.Servicio;
import co.com.ias.training.ServicioMantenimiento.domain.ServicioDescription;
import co.com.ias.training.ServicioMantenimiento.domain.ServicioId;
import co.com.ias.training.ServicioMantenimiento.domain.ServicioName;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class ServicioController {

    @RequestMapping(value="/services", method= RequestMethod.POST)
    public ServicioDTO createService(
            //@RequestHeader("Authorization") String authorizationToken,
            @RequestBody ServicioInput servicioInput ){

        Servicio servicio = new Servicio(
                new ServicioId(UUID.randomUUID().toString()),
                new ServicioName(servicioInput.getName()),
                new ServicioDescription(servicioInput.getDescription())
        );

        return ServicioDTO.fromDomain(servicio);
    }

    @RequestMapping(value="/services/{id}", method= RequestMethod.GET)
    public ServicioDTO getServicio(
            @PathVariable("id") String servicioId
    ){
        return new ServicioDTO(
                servicioId,
                "fake",
                "fake"
        );
    }

    //Metodo para listar los servicios de mantenimiento de manera paginada
    @RequestMapping(value="/services", method = RequestMethod.GET)
    public List<ServicioDTO> listServices(
            @RequestParam(name="skip", defaultValue = "0") Integer skip,
            @RequestParam(name="limit", defaultValue = "50") Integer limit
    ){
        return List.of();
    }




}
