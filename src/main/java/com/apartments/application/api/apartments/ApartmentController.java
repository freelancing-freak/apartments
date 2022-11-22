package com.apartments.application.api.apartments;

import com.apartments.domain.apartments.ApartmentFacade;
import com.apartments.domain.apartments.ApartmentVO;
import com.apartments.shared.pageable.PageResponse;
import com.apartments.shared.pageable.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/apartments")
@RequiredArgsConstructor
class ApartmentController {

    private final ApartmentFacade facade;

    @GetMapping
    public PageResponse<ApartmentVO> findAll(@PageableDefault(value = 12) Pageable pageable) {
        return PageUtil.toPageResponse(facade.findAll(pageable));
    }
}
