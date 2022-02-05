package com.vertex.invoice;

import com.vertex.model.InvoiceDTO;
import com.vertex.utils.MongoDbUtils;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.micronaut.test.support.TestPropertyProvider;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

@MicronautTest
@TestInstance(Lifecycle.PER_CLASS)
public class InvoiceControllerTest implements TestPropertyProvider {

    @Test
    void invoiceEndpointInterfaceWithMongo(InvoiceClient invoiceClient) {
        //Empty list of invoices is returned initially
        List<InvoiceDTO> invoices = invoiceClient.getAll();
        assertTrue(invoices.isEmpty());

        //new invoice creation with only ID
        InvoiceDTO invoice1 = new InvoiceDTO("1");
        HttpStatus status = invoiceClient.saveInvoice(invoice1);
        System.out.println("Inside test2 -> " + status);
        assertEquals(HttpStatus.CREATED, status);

        //check for the record existance in database
        invoices = invoiceClient.getAll();
        assertFalse(invoices.isEmpty());
        /*assertEquals(invoice1.getId(), invoices.get(0).getId());
        assertNull(invoices.get(0).getProfileID());

        //check for another record with all data
        InvoiceDTO invoice2 = new InvoiceDTO("2", "urn:cen.eu:en16931:2017#compliant#urn:fdc:peppol.eu:2017:poacc:billing:3.0",
                "urn:fdc:peppol.eu:2017:poacc:billing:01:1.0", "2017-11-13", "2017-12-01",
                "380", "EUR", "4025:123:4343", "0150abc");
        status = invoiceClient.saveInvoice(invoice2);
        assertEquals(HttpStatus.CREATED, status);
        invoices = invoiceClient.getAll();
        assertTrue(invoices.stream()
                .anyMatch(f -> f.getProfileID() != null && f.getProfileID().equals(invoice2.getProfileID())));

        //check getInvoiceWithId in the collection
        InvoiceDTO invoiceOut = invoiceClient.getInvoiceById("2").get(0);
        assertEquals(invoiceOut, invoice2);*/

    }

    @AfterAll
    static void cleanup() { MongoDbUtils.closeMongoDb(); }

    @NonNull
    @Override
    public Map<String, String> getProperties() {
        MongoDbUtils.startMongoDb();
        return Collections.singletonMap("mongodb.uri", MongoDbUtils.getMongoDbUri());
    }
}
