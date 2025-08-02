package com.example.centreformation.service;

import com.example.centreformation.entity.Support;
import com.example.centreformation.repository.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupportService {

    @Autowired
    private SupportRepository supportRepository;

    // إنشاء support جديد
    public Support createSupport(Support support) {
        return supportRepository.save(support);
    }

    // جلب جميع supports
    public List<Support> getAllSupports() {
        return supportRepository.findAll();
    }

    // جلب support حسب ال ID
    public Support getSupportById(Long id) {
        return supportRepository.findById(id).orElse(null);
    }

    // تحديث support
    public Support updateSupport(Long id, Support supportDetails) {
        Support support = supportRepository.findById(id).orElse(null);
        if (support == null) {
            return null;
        }
        support.setFormation(supportDetails.getFormation());
        support.setTypeSupport(supportDetails.getTypeSupport());
        support.setTitre(supportDetails.getTitre());
        support.setUrl(supportDetails.getUrl());
        support.setDateAjout(supportDetails.getDateAjout());

        return supportRepository.save(support);
    }

    // حذف support
    public boolean deleteSupport(Long id) {
        if (supportRepository.existsById(id)) {
            supportRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
