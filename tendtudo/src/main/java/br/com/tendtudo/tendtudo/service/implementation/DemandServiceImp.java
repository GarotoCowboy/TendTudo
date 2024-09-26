package br.com.tendtudo.tendtudo.service.implementation;

import br.com.tendtudo.tendtudo.controller.Dto.order.OrderDto;
import br.com.tendtudo.tendtudo.models.Demand;
import br.com.tendtudo.tendtudo.models.ProductInCart;
import br.com.tendtudo.tendtudo.models.User;
import br.com.tendtudo.tendtudo.repository.DemandRepository;
import br.com.tendtudo.tendtudo.requests.order.OrderPostRequestBody;
import br.com.tendtudo.tendtudo.requests.order.OrderPutRequestBody;
import br.com.tendtudo.tendtudo.service.DemandService;
import br.com.tendtudo.tendtudo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class DemandServiceImp implements DemandService {

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private UserServiceImp userService;
    @Autowired
    private UserServiceImp userServiceImp;

    @Override
    public List<Demand> findAll() {
        return demandRepository.findAll();
    }

    @Override
    public Demand findById(Long idOrder) {
        return demandRepository.findById(idOrder)
                .orElseThrow(() -> new ResponseStatusException(BAD_REQUEST,"Order not found"));
    }

    //ARRUMAR ISSO AQ
    @Override
    public Demand save(OrderPostRequestBody orderPostRequestBody) {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        orderPostRequestBody.setDate(new Date(sdf.format(System.currentTimeMillis())));
//
//        User user = userServiceImp.findById(1L);
//
//        for(ProductInCart productInCart : orderPostRequestBody.getProductInCart()){
//            productInCart
//        }
//
//        List<ProductInCart> productsToSave = new ArrayList<>();
//        List<ProductInCart> productsInCart = orderPostRequestBody.getProductInCart();
//
//        for(ProductInCart pic:productsInCart){
//            productsToSave.add(pic);
//        }
//
//
//        Demand demand = Demand.builder()
//                .date(orderPostRequestBody.getDate())
//                .paid(orderPostRequestBody.isPaid())
//                .demandId(orderPostRequestBody.getDemandId())
//                .productInCart(productsToSave)
//                .build();
//
//        return demandRepository.save(demand);
        return null;
    }

    @Override
    public Demand replace(OrderPutRequestBody orderPutRequestBody) {
        return null;
    }

    @Override
    public void delete(OrderDto orderDto) {

    }
}
