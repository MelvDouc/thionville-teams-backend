package com.chess.thionvilleteams.controller;

import com.chess.thionvilleteams.service.IService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class ApiController<T> {
    protected IService<T> service;

    public ApiController(IService<T> service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<T> getOne(@RequestParam("id") long id) {
        return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<T>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ResponseEntity<T> create(@RequestBody T entity) {
        return new ResponseEntity<>(service.create(entity), HttpStatus.OK);
    }

    @RequestMapping(path = "/update", method = RequestMethod.PUT)
    public ResponseEntity<T> update(@RequestBody T entity, @RequestParam("id") long id) {
        return new ResponseEntity<>(service.update(entity, id), HttpStatus.OK);
    }

    @RequestMapping(path = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Long> delete(@RequestParam("id") long id) {
        service.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
