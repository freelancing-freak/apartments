package com.apartments.application.api;

import com.apartments.application.api.dto.ApartmentRequest;
import com.apartments.domain.apartments.Apartment;
import com.apartments.domain.apartments.ApartmentFacade;
import com.apartments.shared.pageable.PageResponse;
import com.apartments.shared.pageable.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
public class ApartmentController {

    private final ApartmentFacade facade;

    @PostMapping
    public void save(@RequestBody @Valid ApartmentRequest request) {
        facade.save(request);
    }

    @GetMapping
    public PageResponse<Apartment> findAll(@PageableDefault(value = 12) Pageable pageable) {
        return PageUtil.toPageResponse(facade.findAll(pageable));
    }
}
