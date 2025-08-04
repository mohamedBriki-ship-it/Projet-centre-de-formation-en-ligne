package com.example.centreformation.controller;

import com.example.centreformation.dto.SupportDTO;
import com.example.centreformation.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supports")
@CrossOrigin(origins = "*")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @PostMapping
    public ResponseEntity<SupportDTO> createSupport(@RequestBody SupportDTO dto) {
        SupportDTO created = supportService.createSupport(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<SupportDTO>> getAllSupports() {
        List<SupportDTO> list = supportService.getAllSupports();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportDTO> getSupportById(@PathVariable Long id) {
        SupportDTO dto = supportService.getSupportById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SupportDTO> updateSupport(@PathVariable Long id, @RequestBody SupportDTO dto) {
        SupportDTO updated = supportService.updateSupport(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupport(@PathVariable Long id) {
        boolean deleted = supportService.deleteSupport(id);
        if (deleted) return ResponseEntity.noContent().build();
        else return ResponseEntity.notFound().build();
    }
}
