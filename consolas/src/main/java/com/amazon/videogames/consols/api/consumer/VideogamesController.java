package com.amazon.videogames.consols.api.consumer;

import com.amazon.videogames.consols.api.model.dao.ConsolsDAO;
import com.amazon.videogames.consols.api.model.entity.Consols;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/amazon/videogames/")
public class VideogamesController {

    @Autowired
    private ConsolsDAO consolsDAO;

    //DONE: GET serch All
    @GetMapping("consols/")
    public ResponseEntity<List<Consols>> getConsolas() {
       List<Consols> consols = consolsDAO.findAll();

        return ResponseEntity.ok(consols);
    }

    //DONE: GET serch By Id
    @GetMapping("platform/{idConsols}")
    public ResponseEntity<Consols> getConsolaById(@PathVariable("idConsols") Integer idConsols) {
        Optional<Consols> optionalConsols = consolsDAO.findById(idConsols);
        if (optionalConsols.isPresent()) {
            return ResponseEntity.ok(optionalConsols.get());
        } else {
            return ResponseEntity.noContent().build();
        }

    }

    //DONE: POST create Product
    @PostMapping("add/")
    public ResponseEntity<Consols> createConsol(@RequestBody Consols consols) {
        Consols newConsol = consolsDAO.save(consols);
        return ResponseEntity.ok(newConsol);
    }

    //DONE: DELETE Product By Id
    @DeleteMapping("delete/{idConsols}")
    public ResponseEntity<Void> deleteConsolById(@PathVariable("idConsols") Integer idConsols) {
        consolsDAO.deleteById(idConsols);
        return ResponseEntity.ok(null);
    }

    //DONE: PUT update Product By Id
    @PutMapping("update/")
    public ResponseEntity<Consols> updateConsol(@RequestBody Consols consols) {
        Optional<Consols> optionalConsols = consolsDAO.findById(consols.getIdConsols());
        if (optionalConsols.isPresent()) {
            Consols updateConsole = optionalConsols.get();
            updateConsole.setName(consols.getName());
            updateConsole.setProductInf(consols.getProductInf());
            consolsDAO.save(updateConsole);
            return ResponseEntity.ok(updateConsole);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
