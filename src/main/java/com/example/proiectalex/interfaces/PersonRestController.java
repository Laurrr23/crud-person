package com.example.proiectalex.interfaces;

import com.example.proiectalex.domain.Person;
import com.example.proiectalex.dto.CreateUpdatePersonDto;
import com.example.proiectalex.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonRestController {
    private PersonService service;

    @PostMapping
    public ResponseEntity<Void>create(final @RequestBody CreateUpdatePersonDto dto){
        this.service.save(dto);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Person>>getAll(){
        return ResponseEntity.ok(this.service.getAll());

    }
    @DeleteMapping("/{personId}")
    public ResponseEntity<Void>delete(final @PathVariable String personId){
        this.service.delete(personId);
        return ResponseEntity.ok().build();
    }

}
