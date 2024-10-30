package com.unicauca.smart_consumption.infrastructure.modules.product.dataproviders.jpa;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DetailEmbeddable {
    private  String description;
    private  String specifications;
}
