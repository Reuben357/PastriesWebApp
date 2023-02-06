package com.pastries.Pastries;

import com.pastries.Pastries.model.Cake;
import com.pastries.Pastries.service.CakeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cake")
public class CakeResource {
    private final CakeService cakeService;

    public CakeResource(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Cake>> getAllCakes(){
        List<Cake> cakes = cakeService.findAllCakes();
        return new ResponseEntity<>(cakes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Cake> getCakeById (@PathVariable("id") Long id){
        Cake cake = cakeService.findCakeById(id);
        return new ResponseEntity<>(cake, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Cake> addCake(@RequestBody Cake cake){
        Cake newCake = cakeService.addCake(cake);
        return new ResponseEntity<>(newCake, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Cake> updateCake(@RequestBody Cake cake){
        Cake updateCake = cakeService.updateCake((cake));
        return new ResponseEntity<>(updateCake, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCake(@PathVariable("id") Long id){
        cakeService.deleteCake(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
