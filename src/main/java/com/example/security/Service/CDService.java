package com.example.security.Service;

import com.example.security.Model.CD;
import com.example.security.Repository.CDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CDService {
    private final CDRepository cdRepository;

    @Autowired
    public CDService(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }
    public List<CD> findAllCDs() {
        return cdRepository.findAll();
    }
    public CD findBookById(long id) {
        return cdRepository.findById(id).orElse(null);
    }
    public boolean deleteBookById(long id) {
        return cdRepository.findAll().remove(id);
    }
    public void createCD(CD cd) {
        cdRepository.save(cd);
    }
}
