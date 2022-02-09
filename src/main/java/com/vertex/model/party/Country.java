package com.vertex.model.party;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import static com.vertex.util.AppConstants.IDENTIFICATION_CODE;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Introspected
public class Country {

    @NonNull
    @JsonProperty(IDENTIFICATION_CODE)
    @BsonProperty(IDENTIFICATION_CODE)
    private String identificationCode;

}
