package com.vertex.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vertex.model.party.Party;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.Nullable;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonProperty;
import static com.vertex.util.AppConstants.PARTY;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Introspected
public class PartyDTO {

    @Nullable
    @BsonProperty(PARTY)
    @JsonProperty(PARTY)
    private Party party;

}
