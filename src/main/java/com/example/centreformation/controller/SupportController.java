package com.example.centreformation.controller;

import com.example.centreformation.entity.Support;
import com.example.centreformation.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supports")
public class SupportController {

    @Autowired
    private SupportService supportService;

    // إضافة support جديد
    @PostMapping
    public ResponseEntity<Support> createSupport(@RequestBody Support support) {
        Support createdSupport = supportService.createSupport(support);
        return ResponseEntity.ok(createdSupport);
    }

    // جلب كل ال supports
    @GetMapping
    public ResponseEntity<List<Support>> getAllSupports() {
        List<Support> supports = supportService.getAllSupports();
        return ResponseEntity.ok(supports);
    }

    // جلب support حسب ID
    @GetMapping("/{id}")
    public ResponseEntity<Support> getSupportById(@PathVariable Long id) {
        Support support = supportService.getSupportById(id);
        if (support != null) {
            return ResponseEntity.ok(support);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // تحديث support
    @PutMapping("/{id}")
    public ResponseEntity<Support> updateSupport(@PathVariable Long id, @RequestBody Support supportDetails) {
        Support updatedSupport = supportService.updateSupport(id, supportDetails);
        if (updatedSupport != null) {
            return ResponseEntity.ok(updatedSupport);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // حذف support
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSupport(@PathVariable Long id) {
        boolean deleted = supportService.deleteSupport(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
