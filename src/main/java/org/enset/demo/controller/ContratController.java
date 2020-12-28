package org.enset.demo.controller;


import lombok.extern.java.Log;
import org.enset.demo.aspects.*;
import org.enset.demo.model.Contrat;
import org.enset.demo.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ContratController {
        @Autowired
        private ContratRepository contratRepository;

        @GetMapping("contrats")
        @Decrypt(values = {"titre","nomClient","cinClient"})
        @SecuredByAspect(roles = {"ADMIN","USER"})
        @MyLog
        public List<Contrat> index() {
            return contratRepository.findAll();
        }

        @GetMapping("contrats/{id}")
        @Decrypt(values = {"titre","nomClient","cinClient"})
        @SecuredByAspect(roles = {"ADMIN","USER"})
        @MyLog
        public Contrat get(@PathVariable Long id) {
            return contratRepository.findById(id).get();
        }

        @GetMapping("contrats/cin/{cin}")
        @Decrypt(values = {"titre","nomClient","cinClient"})
        @SecuredByAspect(roles = {"ADMIN","USER"})
        @MyLog
        public Contrat get(@PathVariable String cin) {
            return contratRepository.findByCinClient(cin);
        }

        @PostMapping("contrats/save")
        @Encrypt(values = {"titre","nomClient","cinClient"})
        @SecuredByAspect(roles = {"ADMIN"})
        @MyLog
        //@CachableAspect(values = {"titre","nomClient","cinClient"})
        public String save(@RequestBody Contrat contrat) {
            contrat.setDate(new Date());
           //System.out.println(contrat.getMontant());
            contratRepository.save(contrat);
            return "Vous avez ajouté ce contrat avec succès!";
        }

}
