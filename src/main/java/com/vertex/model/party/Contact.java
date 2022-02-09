package com.vertex.model.party;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
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
public class Contact {

    @Nullable
    @JsonProperty(NAME)
    @BsonProperty(NAME)
    private String name;

    @Nullable
    @JsonProperty(TELEPHONE)
    @BsonProperty(TELEPHONE)
    private String telephone;

    @Nullable
    @JsonProperty(ELECTRONIC_MAIL)
    @BsonProperty(ELECTRONIC_MAIL)
    private String electronicMail;

}
