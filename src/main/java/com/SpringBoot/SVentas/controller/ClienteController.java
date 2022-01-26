package com.SpringBoot.SVentas.controller;

import com.SpringBoot.SVentas.exception.ModelNotFound;
import com.SpringBoot.SVentas.model.Cliente;
import com.SpringBoot.SVentas.service.Impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.create(cliente),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.update(cliente),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable ("id") Integer idCliente) {
        Cliente cliente = clienteService.findById(idCliente);
        if(cliente == null) {
            throw  new ModelNotFound("cliente no encontrado.");
        }
        return new ResponseEntity<>(clienteService.findById(idCliente),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable ("id") Integer idCliente) throws Exception {
        Cliente cliente = clienteService.findById(idCliente);
        if(cliente == null){
            throw new ModelNotFound("El cliente que desea eliminar no existe.");
        }

        clienteService.delete(idCliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
