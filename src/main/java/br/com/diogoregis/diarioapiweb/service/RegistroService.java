package br.com.diogoregis.diarioapiweb.service;

import br.com.diogoregis.diarioapiweb.model.Registro;
import br.com.diogoregis.diarioapiweb.repository.RegistroRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistroService {

    private RegistroRepository repository;

    public RegistroService(RegistroRepository repository) {
        this.repository = repository;
    }

    public List<Registro> list(){
        Sort sort = Sort.by("data").descending();
        return repository.findAll(sort);
    }

    public Registro save(Registro registro){
        return repository.save(registro);
    }

    public Optional<Registro> findById(Long id){
        return repository.findById(id);
    }

    public Registro update(Registro registro){
        if(repository.existsById(registro.getId())){
            return save(registro);
        }
        return null;
    }

    public boolean deleteById(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
