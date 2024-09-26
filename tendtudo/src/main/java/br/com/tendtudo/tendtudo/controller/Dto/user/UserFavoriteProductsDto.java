package br.com.tendtudo.tendtudo.controller.Dto.user;

import lombok.Data;

@Data
public class UserFavoriteProductsDto {
    private Long userId;
    private Long productId;
}
