package com.vertex.repository.dao;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import com.mongodb.reactivestreams.client.MongoCollection;
import com.vertex.config.MongoDbConfiguration;
import com.vertex.model.InvoiceDTO;
import com.vertex.repository.InvoiceRepo;
import io.micronaut.core.annotation.NonNull;
import jakarta.inject.Singleton;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static com.vertex.util.AppConstants.*;
import static com.vertex.util.TransformationUtil.toInvoiceDoc;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

@Singleton
public class InvoiceDAO implements InvoiceRepo {

    private final MongoDbConfiguration mongoConf;
    private final MongoClient mongoClient;

    public InvoiceDAO(MongoDbConfiguration mongoConf) {
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder()
                .codecRegistry(codecRegistry)
                .build();
        MongoClient mongoClient = MongoClients.create(clientSettings);
        this.mongoConf = mongoConf;
        this.mongoClient = mongoClient;
    }

    @Override
    public Publisher<Document> getAllInvoices() {
        return getCollection().find();
    }

    @Override
    public Mono<Document> getInvoiceById(@NonNull String id) {
        Bson filter = Filters.eq(BSON_ID, id);
        return Mono.from(getCollection().find(filter).first());
    }

    @Override
    public Mono<Boolean> saveInvoice(@NonNull InvoiceDTO invoice) {
        return Mono.from(getCollection().insertOne(toInvoiceDoc(invoice)))
                .map(insertOneResult -> Boolean.TRUE)
                .onErrorReturn(Boolean.FALSE);
    }

    @Override
    public Mono<Boolean> deleteInvoice(@NonNull String id) {
        Bson filter = Filters.eq(BSON_ID, id);
        return Mono.from(getCollection().deleteOne(filter))
                .map(deleteInvoice -> Boolean.TRUE)
                .onErrorReturn(Boolean.FALSE);
    }

    @Override
    public Mono<Document> updateInvoice(@NonNull String id, @NonNull @Valid InvoiceDTO invoice) {
        Bson filter = Filters.eq(BSON_ID, id);
        return Mono.from(getCollection().replaceOne(filter, toInvoiceDoc(invoice)))
                .map(updatedInvoice -> toInvoiceDoc(invoice));
    }

    @NonNull
    private MongoCollection<Document> getCollection() {
        return mongoClient.getDatabase(mongoConf.getName()).getCollection(mongoConf.getCollection(), Document.class);
    }
}
