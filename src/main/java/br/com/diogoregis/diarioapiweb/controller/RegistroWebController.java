package br.com.diogoregis.diarioapiweb.controller;

import br.com.diogoregis.diarioapiweb.model.Registro;
import br.com.diogoregis.diarioapiweb.service.RegistroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class RegistroWebController {

    private RegistroService service;

    public RegistroWebController(RegistroService service) {
        this.service = service;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Registro> registros = service.list();
        model.addAttribute("registros", registros);
        return "list";
    }

    @GetMapping("/save")
    public String save(Model model) {
        model.addAttribute("registro", new Registro());
        return "save";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Registro registro) {
        service.save(registro);
        return "redirect:/diario/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model) {
        Registro registro = service.findById(id).orElse(null);
        if (registro == null) {
            return "redirect:/diario/list";
        }
        model.addAttribute("registro", registro);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Registro registro) {
        service.update(registro);
        return "redirect:/diario/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/diario/list";
    }
}