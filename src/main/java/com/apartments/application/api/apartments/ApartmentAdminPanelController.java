package com.apartments.application.api.apartments;

import com.apartments.domain.apartments.Apartment;
import com.apartments.domain.apartments.ApartmentFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin-panel/apartments")
@RequiredArgsConstructor
class ApartmentAdminPanelController {

    private final ApartmentFacade facade;

    @GetMapping
    public List<Apartment> findAll(@RequestParam(value = "filter_text", required = false) String filterText) {
        return facade.findAll(filterText);
    }

    @PostMapping
    public void save(@RequestBody Apartment apartment) {
        facade.save(apartment);
    }

    @PutMapping
    public void update(@RequestBody Apartment apartment) {
        facade.update(apartment);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        facade.deleteById(id);
    }
}
