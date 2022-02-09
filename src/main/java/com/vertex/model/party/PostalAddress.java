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
public class PostalAddress {

    @NonNull
    @JsonProperty(STREET_NAME)
    @BsonProperty(STREET_NAME)
    private String streetName;

    @NonNull
    @JsonProperty(ADDITIONAL_STREET_NAME)
    @BsonProperty(ADDITIONAL_STREET_NAME)
    private String additionalStreetName;

    @NonNull
    @JsonProperty(CITY_NAME)
    @BsonProperty(CITY_NAME)
    private String cityName;

    @NonNull
    @JsonProperty(POSTAL_ZONE)
    @BsonProperty(POSTAL_ZONE)
    private String postalZone;

    @NonNull
    @JsonProperty(COUNTRY)
    @BsonProperty(COUNTRY)
    private Country country;

}
