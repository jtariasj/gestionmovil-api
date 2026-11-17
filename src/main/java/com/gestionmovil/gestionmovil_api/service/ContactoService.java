package com.gestionmovil.gestionmovil_api.service;

import com.gestionmovil.gestionmovil_api.model.Contacto;
import com.gestionmovil.gestionmovil_api.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactoService {
    @Autowired
    private ContactoRepository contactoRepository;

    public List<Contacto> getContactos() {
        return contactoRepository.findAll();
    }

    public Optional<Contacto> getContactoById(int id) {
        return contactoRepository.findById(id);
    }

    public Contacto saveContacto(Contacto contacto) {
        return contactoRepository.save(contacto);
    }

    public void deleteContacto(int id) {
        if (contactoRepository.existsById(id)) {
            contactoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Contacto no encontrado");
        }
    }

    public Contacto updateContacto(Contacto contacto, int id) {
        Optional<Contacto> existe = getContactoById(id);
        if(existe.isEmpty()){
            throw new RuntimeException("Contacto no encontrado");
        } else {
            contacto.setId(id); //Aseguramos que se actualice el correcto
            return contactoRepository.save(contacto);
        }
    }

}
