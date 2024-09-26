package br.com.tendtudo.tendtudo.requests.cart;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartPostRequestBody {

    private BigDecimal allValue;
}
