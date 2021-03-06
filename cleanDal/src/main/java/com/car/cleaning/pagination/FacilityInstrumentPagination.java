package com.car.cleaning.pagination;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class FacilityInstrumentPagination extends CleanPagination {
    @Override
    public int getPageNumber() {
        return 1;
    }

    @Override
    public int getPageSize() {
        return 5;
    }

    @Override
    public long getOffset() {
        return 0;
    }

    @Override
    public Sort getSort() {
        return new Sort(Sort.Direction.ASC, "facilityInstrumentId");
    }

    @Override
    public Pageable next() {
        return null;
    }

    @Override
    public Pageable previousOrFirst() {
        return null;
    }

    @Override
    public Pageable first() {
        return null;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }
}
