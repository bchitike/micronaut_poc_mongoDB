package com.vertex.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Introspected
public class InvoiceDTO {

    @NonNull
    @NotBlank
    @BsonId
    @JsonProperty("ID")
    private final String id;

    @Nullable
    @BsonProperty("CustomizationID")
    @JsonProperty("CustomizationID")
    private String customizationID;

    @Nullable
    @BsonProperty("ProfileID")
    @JsonProperty("ProfileID")
    private String profileID;

    @Nullable
    @BsonProperty("IssueDate")
    @JsonProperty("IssueDate")
    private String issueDate;

    @Nullable
    @BsonProperty("DueDate")
    @JsonProperty("DueDate")
    private String dueDate;

    @Nullable
    @BsonProperty("InvoiceTypeCode")
    @JsonProperty("InvoiceTypeCode")
    private String invoiceTypeCode;

    @Nullable
    @BsonProperty("DocumentCurrencyCode")
    @JsonProperty("DocumentCurrencyCode")
    private String documentCurrencyCode;

    @Nullable
    @BsonProperty("AccountingCost")
    @JsonProperty("AccountingCost")
    private String accountingCost;

    @Nullable
    @BsonProperty("BuyerReference")
    @JsonProperty("BuyerReference")
    private String buyerReference;

   /* @Nullable
    @JsonProperty("AccountingSupplierParty")
    @BsonProperty("AccountingSupplierParty")
    private Party accountingSupplierParty;

    @Nullable
    @JsonProperty("AccountingCustomerParty")
    @BsonProperty("AccountingCustomerParty")
    private Party accountingCustomerParty;*/

    public InvoiceDTO(@NonNull String id) {
        this(id, null, null, null, null, null, null, null, null);
    }

    @Creator
    @BsonCreator
    public InvoiceDTO(@NonNull @JsonProperty("ID") @BsonId String id,
                      @Nullable @JsonProperty("CustomizationID") @BsonProperty("CustomizationID") String customizationID,
                      @Nullable @JsonProperty("ProfileID") @BsonProperty("ProfileID") String profileID,
                      @Nullable @JsonProperty("IssueDate") @BsonProperty("IssueDate") String issueDate,
                      @Nullable @JsonProperty("DueDate") @BsonProperty("DueDate") String dueDate,
                      @Nullable @JsonProperty("InvoiceTypeCode") @BsonProperty("InvoiceTypeCode") String invoiceTypeCode,
                      @Nullable @JsonProperty("DocumentCurrencyCode") @BsonProperty("DocumentCurrencyCode") String documentCurrencyCode,
                      @Nullable @JsonProperty("AccountingCost") @BsonProperty("AccountingCost") String accountingCost,
                      @Nullable @JsonProperty("BuyerReference") @BsonProperty("BuyerReference") String buyerReference
                      //@Nullable @JsonProperty("AccountingSupplierParty") @BsonProperty("AccountingSupplierParty") Party accountingSupplierPart,
                      //@Nullable @JsonProperty("AccountingCustomerParty") @BsonProperty("AccountingCustomerParty") Party accountingCustomerParty
                      ) {
        this.id = id;
        this.customizationID = customizationID;
        this.profileID = profileID;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.invoiceTypeCode = invoiceTypeCode;
        this.documentCurrencyCode = documentCurrencyCode;
        this.accountingCost = accountingCost;
        this.buyerReference = buyerReference;
        //this.accountingSupplierParty = accountingSupplierPart;
        //this.accountingCustomerParty = accountingCustomerParty;
    }

}
