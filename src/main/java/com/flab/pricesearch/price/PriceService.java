package com.flab.pricesearch.price;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(@Autowired PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public PriceDto findById(long id) {
        return PriceDto.priceOf(priceRepository.findById(id).orElseGet(Price::new));
    }

    public List<PriceDto> findAll() {
        return priceRepository.findAll()
                .stream()
                .map(PriceDto::priceOf)
                .collect(Collectors.toList());
    }

    public PriceDto insertPrice(Price price) {
        return PriceDto.priceOf(priceRepository.save(price));
    }

    public PriceDto updatePrice(long id) {
        return PriceDto.priceOf(priceRepository.save(priceRepository.getById(id)));
    }
}
