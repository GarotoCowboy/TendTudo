package br.com.tendtudo.tendtudo.service;

import br.com.tendtudo.tendtudo.controller.Dto.order.OrderDto;
import br.com.tendtudo.tendtudo.models.Demand;
import br.com.tendtudo.tendtudo.requests.order.OrderPostRequestBody;
import br.com.tendtudo.tendtudo.requests.order.OrderPutRequestBody;

import java.util.List;

public interface DemandService {

    List<Demand> findAll();

    Demand findById(Long idOrder);

    Demand save(OrderPostRequestBody orderPostRequestBody);

    Demand replace(OrderPutRequestBody orderPutRequestBody);

    void delete(OrderDto orderDto);
}
