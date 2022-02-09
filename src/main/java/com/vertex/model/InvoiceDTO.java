package com.vertex.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vertex.model.party.Party;
import com.vertex.util.TransformationUtil;
import io.micronaut.core.annotation.Creator;
import io.micronaut.core.annotation.Introspected;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;

import static com.vertex.util.AppConstants.*;
import javax.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Introspected
public class InvoiceDTO {

    @NonNull
    @NotBlank
    @BsonId
    @JsonProperty(ID)
    private final String id;

    @Nullable
    @BsonProperty(CUSTOMIZATION_ID)
    @JsonProperty(CUSTOMIZATION_ID)
    private String customizationID;

    @Nullable
    @BsonProperty(PROFILE_ID)
    @JsonProperty(PROFILE_ID)
    private String profileID;

    @Nullable
    @BsonProperty(ISSUE_DATE)
    @JsonProperty(ISSUE_DATE)
    private String issueDate;

    @Nullable
    @BsonProperty(DUE_DATE)
    @JsonProperty(DUE_DATE)
    private String dueDate;

    @Nullable
    @BsonProperty(INVOICE_TYPE_CODE)
    @JsonProperty(INVOICE_TYPE_CODE)
    private String invoiceTypeCode;

    @Nullable
    @BsonProperty(DOCUMENT_CURRENCY_CODE)
    @JsonProperty(DOCUMENT_CURRENCY_CODE)
    private String documentCurrencyCode;

    @Nullable
    @BsonProperty(ACCOUNTING_COST)
    @JsonProperty(ACCOUNTING_COST)
    private String accountingCost;

    @Nullable
    @BsonProperty(BUYER_REFERENCE)
    @JsonProperty(BUYER_REFERENCE)
    private String buyerReference;

    @Nullable
    @JsonProperty(ACCOUNTING_SUPPLIER_PARTY)
    @BsonProperty(ACCOUNTING_SUPPLIER_PARTY)
    private PartyDTO accountingSupplierParty;

    @Nullable
    @JsonProperty(ACCOUNTING_CUSTOMER_PARTY)
    @BsonProperty(ACCOUNTING_CUSTOMER_PARTY)
    private PartyDTO accountingCustomerParty;

    public InvoiceDTO(@NonNull String id) {
        this(id, null, null, null, null, null, null, null, null, null, null);
    }

    @Creator
    @BsonCreator
    public InvoiceDTO(@NonNull @JsonProperty(ID) @BsonId String id,
                      @Nullable @JsonProperty(CUSTOMIZATION_ID) @BsonProperty(CUSTOMIZATION_ID) String customizationID,
                      @Nullable @JsonProperty(PROFILE_ID) @BsonProperty(PROFILE_ID) String profileID,
                      @Nullable @JsonProperty(ISSUE_DATE) @BsonProperty(ISSUE_DATE) String issueDate,
                      @Nullable @JsonProperty(DUE_DATE) @BsonProperty(DUE_DATE) String dueDate,
                      @Nullable @JsonProperty(INVOICE_TYPE_CODE) @BsonProperty(INVOICE_TYPE_CODE) String invoiceTypeCode,
                      @Nullable @JsonProperty(DOCUMENT_CURRENCY_CODE) @BsonProperty(DOCUMENT_CURRENCY_CODE) String documentCurrencyCode,
                      @Nullable @JsonProperty(ACCOUNTING_COST) @BsonProperty(ACCOUNTING_COST) String accountingCost,
                      @Nullable @JsonProperty(BUYER_REFERENCE) @BsonProperty(BUYER_REFERENCE) String buyerReference,
                      @Nullable @JsonProperty(ACCOUNTING_SUPPLIER_PARTY) @BsonProperty(ACCOUNTING_SUPPLIER_PARTY) PartyDTO accountingSupplierParty,
                      @Nullable @JsonProperty(ACCOUNTING_CUSTOMER_PARTY) @BsonProperty(ACCOUNTING_CUSTOMER_PARTY) PartyDTO accountingCustomerParty
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
        this.accountingSupplierParty = accountingSupplierParty;
        this.accountingCustomerParty = accountingCustomerParty;

    }

}
