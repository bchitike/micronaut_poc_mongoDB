package com.vertex.invoice;

import com.vertex.model.InvoiceDTO;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.client.annotation.Client;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Client("/e-invoice")
public interface InvoiceClient {

    @Get
    @NonNull
    List<InvoiceDTO> getAll();

    @Get("/{id}")
    List<InvoiceDTO> getInvoiceById(@NonNull @NotBlank String id);

    @Post
    HttpStatus saveInvoice(@NonNull @NotNull @Valid @Body InvoiceDTO invoice);

}
