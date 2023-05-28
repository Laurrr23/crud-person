package com.example.proiectalex.interfaces;

import com.example.proiectalex.domain.Produs;
import com.example.proiectalex.dto.CreateUpdateProdusDto;
import com.example.proiectalex.service.ProdusService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProdusRestController {
    private ProdusService service;

    @PostMapping
    public ResponseEntity<Void>save(final @RequestBody CreateUpdateProdusDto dto){
        this.service.save(dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{produsId}")
    public ResponseEntity<Void>delete(final @PathVariable String produsId){
        this.service.deleteById(produsId);
        return ResponseEntity.ok().build();

    }

    @PatchMapping("/{produsId}")
    public ResponseEntity<Void>update(final @PathVariable String produsId, final @RequestBody CreateUpdateProdusDto dto){
        this.service.update(produsId,dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Produs>>getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }

}
