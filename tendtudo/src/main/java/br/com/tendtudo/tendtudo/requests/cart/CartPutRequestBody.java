package br.com.tendtudo.tendtudo.requests.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartPutRequestBody {

    private Long cartId;

    private BigDecimal allValue;
}
