package com.vertex.repository.dao;

import com.mongodb.client.model.Filters;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.vertex.config.MongoDbConfiguration;
import com.vertex.model.InvoiceDTO;
import com.vertex.repository.InvoiceRepo;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

@Singleton
public class InvoiceDAO implements InvoiceRepo {

    private final MongoDbConfiguration mongoConf;
    private final MongoClient mongoClient;

    public InvoiceDAO(MongoDbConfiguration mongoConf, MongoClient mongoClient) {
        this.mongoConf = mongoConf;
        this.mongoClient = mongoClient;
    }

    @Override
    public Publisher<InvoiceDTO> getAllInvoices() {
        return getCollection().find();
    }

    @Override
    public Mono<InvoiceDTO> getInvoiceById(@NonNull String id) {
        Bson filter = Filters.eq("_id", id);
        return Mono.from(getCollection().find(filter).first());
    }

    @Override
    public Mono<Boolean> saveInvoice(@NonNull InvoiceDTO invoice) {
        return Mono.from(getCollection().insertOne(invoice))
                .map(insertOneResult -> Boolean.TRUE)
                .onErrorReturn(Boolean.FALSE);
    }

    @Override
    public Mono<Boolean> deleteInvoice(@NonNull String id) {
        Bson filter = Filters.eq("_id", id);
        return Mono.from(getCollection().deleteOne(filter))
                .map(deleteInvoice -> Boolean.TRUE)
                .onErrorReturn(Boolean.FALSE);
    }

    @Override
    public Mono<Boolean> updateInvoice(@NonNull String id, @NonNull InvoiceDTO invoice) {
        Bson filter = Filters.eq("_id", id);
        return Mono.from(getCollection().replaceOne(filter, invoice))
                .map(updateResult -> Boolean.TRUE)
                .onErrorReturn(Boolean.FALSE);
    }

    @NonNull
    private MongoCollection<InvoiceDTO> getCollection() {
        return mongoClient.getDatabase(mongoConf.getName()).getCollection(mongoConf.getCollection(), InvoiceDTO.class);
    }
}
