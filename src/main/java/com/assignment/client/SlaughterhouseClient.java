package com.assignment.client;

import com.assignment.protobuf.Animal;
import com.assignment.protobuf.SlaughterhouseServiceGrpc;
import com.google.protobuf.Descriptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Service
public class SlaughterhouseClient {
    ManagedChannel managedChannel = ManagedChannelBuilder
            .forAddress("localhost", 9090)
            .usePlaintext()
            .build();

    SlaughterhouseServiceGrpc.SlaughterhouseServiceBlockingStub synchronousStub
            = SlaughterhouseServiceGrpc.newBlockingStub(managedChannel);

    SlaughterhouseServiceGrpc.SlaughterhouseServiceStub asynchronousStub
            = SlaughterhouseServiceGrpc.newStub(managedChannel);


    public Optional<Animal> getAnimalById(long id) throws InterruptedException {
        Animal request = Animal.newBuilder().setRegNr(id).build();
        Animal animalResponse = synchronousStub.getAnimalById(request);

        return Optional.ofNullable(animalResponse);
    }

}
