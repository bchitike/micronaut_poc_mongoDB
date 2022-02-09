package com.vertex.repository;

import com.vertex.model.InvoiceDTO;
import io.micronaut.core.annotation.NonNull;
import org.bson.Document;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

public interface InvoiceRepo {

    Publisher<Document> getAllInvoices();

    Mono<Document> getInvoiceById(@NonNull @NotBlank String id);

    Mono<Boolean> saveInvoice(@NonNull @NotBlank @Valid InvoiceDTO invoice);

    Mono<Boolean> deleteInvoice(@NonNull @NotBlank String id);

    Mono<Document> updateInvoice(@NonNull @NotBlank String id, @NonNull @NotBlank @Valid InvoiceDTO invoice);
}
