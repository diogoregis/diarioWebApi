package br.com.diogoregis.diarioapiweb.controller;

import br.com.diogoregis.diarioapiweb.model.Registro;
import br.com.diogoregis.diarioapiweb.service.RegistroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/diario")
public class RegistroController {

    private RegistroService service;

    public RegistroController(RegistroService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Registro>> list(){
        return ResponseEntity.status(HttpStatus.OK).body(service.list());
    }

    @PostMapping
    public ResponseEntity<Registro> save(@RequestBody Registro registro){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(registro));
    }

    @PutMapping
    public ResponseEntity<Registro> update(@RequestBody Registro registro){
        var retorno = service.update(registro);
        if(retorno == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id){
        if(service.deleteById(id)){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("!!! EXCLUIDO !!!");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("NOT FOUND - NOT DELETE");
    }

}
