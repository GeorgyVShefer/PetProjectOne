package org.example.service;

import org.example.dao.StudentDAO;
import org.example.dao.UniversityDAO;
import org.example.dto.UniversityDTO;
import org.example.model.University;

import java.util.List;

public class UniversityService {
   private UniversityDAO universityDAO;
    public University university;
    public void save(int id, String title){
        UniversityDTO universityDTO = mapToDTO(university);
        universityDAO.saveUniversity(universityDTO.getId(),universityDTO.getName());
    }
    public University get(){
        return universityDAO.getUniversity();
    }
    public void update(int id, String title ){
        UniversityDTO universityDTO = mapToDTO(university);
        universityDAO.updateUniversity(universityDTO.getId(),universityDTO.getName());
    }
    public void delete(int id){
        UniversityDTO universityDTO = mapToDTO(university);
        universityDAO.deleteUniversity(universityDTO.getId());
    }

    private UniversityDTO mapToDTO(University university){
        if(university == null){
            return null;
        }
        UniversityDTO universityDTO = new UniversityDTO();
        universityDTO.setId(university.getId());
        universityDTO.setName(university.getName());

        return universityDTO;
    }
}
