package com.apartments.shared.pageable;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageResponse<T> {

    private List<T> data;
    private Pagination pagination;

    @Data
    @AllArgsConstructor
    public static class Pagination {
        private int pageNumber;
        private long totalElements;
        private int totalPages;
        private int pageSize;
    }
}
