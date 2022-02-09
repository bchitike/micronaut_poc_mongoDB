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
public class Party {

    @Nullable
    @JsonProperty(ENDPOINT_ID)
    @BsonProperty(ENDPOINT_ID)
    private EndpointId endpointId;

    @Nullable
    @JsonProperty(PARTY_IDENTIFICATION)
    @BsonProperty(PARTY_IDENTIFICATION)
    private PartyIdentification partyIdentification;

    @Nullable
    @JsonProperty(PARTY_NAME)
    @BsonProperty(PARTY_NAME)
    private PartyName partyName;

    @Nullable
    @JsonProperty(POSTAL_ADDRESS)
    @BsonProperty(POSTAL_ADDRESS)
    private PostalAddress postalAddress;

    @Nullable
    @JsonProperty(PARTY_TAX_SCHEME)
    @BsonProperty(PARTY_TAX_SCHEME)
    private PartyTaxScheme partyTaxScheme;

    @Nullable
    @JsonProperty(PARTY_LEGAL_ENTITY)
    @BsonProperty(PARTY_LEGAL_ENTITY)
    private PartyLegalEntity partyLegalEntity;

    @Nullable
    @JsonProperty(CONTACT)
    @BsonProperty(CONTACT)
    private Contact contact;
    
}
