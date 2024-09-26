package br.com.tendtudo.tendtudo.requests.products;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductsPutRequestBody {

    private Long productsID;
    private String name;
    private String type;
    private String size;
    private String color;
    private String image;
    private String producer ;
    private String category;
    private String subCategory;
    private String description;
    private BigDecimal value;
    private int amount;

}
