package com.vertex.controller;

import com.vertex.model.InvoiceDTO;
import com.vertex.repository.InvoiceRepo;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;
import org.bson.Document;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Controller("/e-invoice")
public class InvoiceController {

    @Inject
    InvoiceRepo invoiceService;

    @Get
    public Publisher<InvoiceDTO> getAll() { return invoiceService.getAllInvoices(); }

    @Get("/{id}")
    public Mono<InvoiceDTO> getInvoiceById(@NonNull @NotBlank String id){
        return invoiceService.getInvoiceById(id);
    }

    @Post
    public Mono<HttpStatus> saveInvoice(@NonNull @NotNull @Valid @Body InvoiceDTO invoice) {
        return invoiceService.saveInvoice(invoice)
                .map(added -> (added) ? HttpStatus.CREATED : HttpStatus.CONFLICT);
        /*
        Boolean val = invoiceService.saveInvoice(invoice);
        if(val){
            return CREATED;
        }else{

        }

         */
    }

    @Put("/{id}")
    public Mono<HttpStatus> updateInvoice(@NonNull @NotBlank String id, @NonNull @NotNull @Valid @Body InvoiceDTO invoice){
        return invoiceService.updateInvoice(id, invoice)
                .map(updated -> (updated)? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @Delete("/{id}")
    public Mono<HttpStatus> deleteInvoice(@NonNull @NotBlank String id){
        return invoiceService.deleteInvoice(id)
                .map(deleted -> (deleted) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
