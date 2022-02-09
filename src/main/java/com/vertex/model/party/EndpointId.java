package com.vertex.model.party;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;

import static com.vertex.util.AppConstants.SCHEME_ID;
import static com.vertex.util.AppConstants.TEXT;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Introspected
public class EndpointId {

    @NonNull
    @JsonProperty(SCHEME_ID)
    @BsonProperty(SCHEME_ID)
    private String schemeID;

    @NonNull
    @JsonProperty(TEXT)
    @BsonProperty(TEXT)
    private String text;

}
