package com.porfolioDanielLlanes.demo.Controlador;

import com.porfolioDanielLlanes.demo.Dto.Dtohys;
import com.porfolioDanielLlanes.demo.Entidad.HyS;
import com.porfolioDanielLlanes.demo.Security.Controller.Mensaje;
import com.porfolioDanielLlanes.demo.Servicio.SHyS;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/skills")
@CrossOrigin(origins = "https://porfoliofronted.web.app")

public class CHys {

    @Autowired
    SHyS shys;

    @GetMapping("/lista")
    public ResponseEntity<List<HyS>> list() {
        List<HyS> list = shys.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Dtohys dtohys) {
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (shys.existsByNombre(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = new HyS(dtohys.getNombre(), dtohys.getPorcent());
        shys.save(hys);

        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Dtohys dtohys) {
        //Validacion de id
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara el nombre de la skill
        if (shys.existsByNombre(dtohys.getNombre()) && shys.getByNombre(dtohys.getNombre()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        }
        //Si el campo esta vacío
        if (StringUtils.isBlank(dtohys.getNombre())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        HyS hys = shys.getOne(id).get();
        hys.setNombre(dtohys.getNombre());
        hys.setPorcent(dtohys.getPorcent());

        shys.save(hys);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        //Validacion de existencia del id
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("El id no existe"), HttpStatus.BAD_REQUEST);
        }
        shys.delete(id);

        return new ResponseEntity(new Mensaje("Skill eliminada"), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<HyS> getById(@PathVariable("id") int id) {
        if (!shys.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        HyS hys = shys.getOne(id).get();
        return new ResponseEntity(hys, HttpStatus.OK);
    }
}
