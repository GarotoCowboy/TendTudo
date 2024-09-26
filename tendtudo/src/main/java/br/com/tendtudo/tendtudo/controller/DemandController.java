package br.com.tendtudo.tendtudo.controller;

import br.com.tendtudo.tendtudo.models.Demand;
import br.com.tendtudo.tendtudo.requests.order.OrderPostRequestBody;
import br.com.tendtudo.tendtudo.service.implementation.DemandServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/demands")
public class DemandController {


    @Autowired
    private DemandServiceImp demandService;

    @GetMapping
    private ResponseEntity<List<Demand>> findAll(){
        return new ResponseEntity<>(demandService.findAll(), HttpStatus.OK);
    }

    @GetMapping("get/{demandId}")
    private ResponseEntity<Demand> findById(@PathVariable Long demandId){
        return new ResponseEntity<>(demandService.findById(demandId), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Demand> save(@RequestBody OrderPostRequestBody orderPostRequestBody){
        return new ResponseEntity<>(demandService.save(orderPostRequestBody), HttpStatus.CREATED);
    }

//    @DeleteMapping
//    private ResponseEntity<Void> delete(@RequestBody ReviewDto review){
//        demandService.delete(review);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
