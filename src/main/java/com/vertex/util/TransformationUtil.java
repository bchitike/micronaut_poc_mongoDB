package com.vertex.util;

import com.vertex.model.InvoiceDTO;
import com.vertex.model.party.*;
import org.bson.Document;

import static com.vertex.util.AppUtil.isVoid;

public class TransformationUtil {

    public static Document toInvoiceDoc(InvoiceDTO invoice) {
        Document invoiceDoc = new Document();
        invoiceDoc = invoiceDoc.append("_id", invoice.getId())
                .append("CustomizationID", invoice.getCustomizationID())
                .append("ProfileID", invoice.getProfileID())
                .append("IssueDate", invoice.getIssueDate())
                .append("DueDate", invoice.getDueDate())
                .append("InvoiceTypeCode", invoice.getInvoiceTypeCode())
                .append("DocumentCurrencyCode", invoice.getDocumentCurrencyCode())
                .append("AccountingCost", invoice.getAccountingCost())
                .append("BuyerReference", invoice.getBuyerReference());
        if(!isVoid(invoice.getAccountingSupplierParty())){
            invoiceDoc = invoiceDoc.append("AccountingSupplierParty", toPartyDoc(invoice.getAccountingSupplierParty().getParty()));
        }
        if(!isVoid(invoice.getAccountingCustomerParty())){
            invoiceDoc = invoiceDoc.append("AccountingCustomerParty", toPartyDoc(invoice.getAccountingCustomerParty().getParty()));
        }
        return invoiceDoc;
    }

    public static Document toPartyDoc(Party party) {
        return new Document().
                append("EndpointID", party.getEndpointId() != null ?
                        new Document()
                                .append("@schemeID", party.getEndpointId().getSchemeID())
                                .append("#text", party.getEndpointId().getText()) : null )
                .append("PartyIdentification", party.getPartyIdentification() != null ?
                        new Document()
                                .append("ID", party.getPartyIdentification().getId()) : null)
                .append("PartyName", party.getPartyName() != null ?
                        new Document()
                                .append("Name", party.getPartyName().getName()) : null)
                .append("PostalAddress", party.getPostalAddress() != null ?
                        new Document()
                                .append("StreetName", party.getPostalAddress().getStreetName())
                                .append("AdditionalStreetName", party.getPostalAddress().getAdditionalStreetName())
                                .append("CityName", party.getPostalAddress().getCityName())
                                .append("PostalZone", party.getPostalAddress().getPostalZone())
                                .append("Country",
                                        new Document()
                                                .append("IdentificationCode",
                                                        party.getPostalAddress().getCountry().getIdentificationCode()))
                        : null)
                .append("PartyTaxScheme", party.getPartyTaxScheme() != null ?
                        new Document()
                                .append("CompanyID", party.getPartyTaxScheme().getCompanyID())
                                .append("TaxScheme",
                                        new Document()
                                                .append("ID", party.getPartyTaxScheme().getTaxScheme().getId())) : null)
                .append("PartyLegalEntity", party.getPartyLegalEntity() != null ?
                        new Document()
                                .append("RegistrationName", party.getPartyLegalEntity().getRegistrationName())
                                .append("CompanyID", party.getPartyLegalEntity().getCompanyID()) : null)
                .append("Contact", party.getContact() != null ?
                        new Document()
                                .append("Name", party.getContact().getName())
                                .append("Telephone", party.getContact().getTelephone())
                                .append("ElectronicMail", party.getContact().getElectronicMail()) : null);
    }

}
