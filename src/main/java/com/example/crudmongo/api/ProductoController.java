package com.example.crudmongo.api;

import com.example.crudmongo.model.Documents.Producto;
import com.example.crudmongo.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
        RequestMethod.DELETE })
@RequestMapping("api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    @PostMapping("/producto")
    public Producto create(@Validated @RequestBody Producto producto) {
        return repository.insert(producto);
    }

    @GetMapping("/")
    public List<Producto> readAll() {
        return repository.findAll();
    }

    @PutMapping("/producto/{id}")
    public Producto update(@PathVariable String id, @Validated @RequestBody Producto producto) {
        return repository.save(producto);
    }

    @DeleteMapping("/producto/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
