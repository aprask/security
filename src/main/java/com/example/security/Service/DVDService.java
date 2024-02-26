package com.example.security.Service;

import com.example.security.Model.DVD;
import com.example.security.Repository.DVDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DVDService {
    private final DVDRepository dvdRepository;

    @Autowired
    public DVDService(DVDRepository dvdRepository) {
        this.dvdRepository = dvdRepository;
    }
    public List<DVD> findAllDVDs() {
        return dvdRepository.findAll();
    }
    public DVD findBookById(long id) {
        return dvdRepository.findById(id).orElse(null);
    }
    public boolean deleteBookById(long id) {
        return dvdRepository.findAll().remove(id);
    }
    public void createDVD(DVD dvd) {
        dvdRepository.save(dvd);
    }
}
