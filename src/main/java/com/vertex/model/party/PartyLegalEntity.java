package com.vertex.model.party;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import static com.vertex.util.AppConstants.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Introspected
public class PartyLegalEntity {

    @NonNull
    @JsonProperty(REGISTRATION_NAME)
    @BsonProperty(REGISTRATION_NAME)
    private String registrationName;

    @NonNull
    @JsonProperty(COMPANY_ID)
    @BsonProperty(COMPANY_ID)
    private String companyID;

}
