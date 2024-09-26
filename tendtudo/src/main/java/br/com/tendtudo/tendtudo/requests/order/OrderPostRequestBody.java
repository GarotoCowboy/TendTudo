package br.com.tendtudo.tendtudo.requests.order;

import br.com.tendtudo.tendtudo.models.ProductInCart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class OrderPostRequestBody {

    private Long demandId;

    private Date date;

    private boolean paid;

    private List<ProductInCart> productInCart;
}
