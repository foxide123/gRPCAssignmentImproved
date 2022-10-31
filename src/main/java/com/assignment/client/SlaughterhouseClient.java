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



    public List<Map<Descriptors.FieldDescriptor, Object>> getAllAnimals()
    {
        Animal request = Animal.newBuilder().build();
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();
        asynchronousStub.getAllAnimals(request, new StreamObserver<Animal>() {
            @Override
            public void onNext(Animal animal) {
                response.add(animal.getAllFields());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }

        });
        return response;


    }



    public Map<Descriptors.FieldDescriptor, Object> getAnimalById(long id) throws InterruptedException {
        Animal request = Animal.newBuilder().setRegNr(id).build();
        Animal animalResponse = synchronousStub.getAnimalById(request);

        return animalResponse.getAllFields();
    }

    public List<Map<Descriptors.FieldDescriptor, Object>> getAnimalsByDate(String date)
    {
        Animal animalRequest = Animal.newBuilder().setArriveDate(date).build();
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();
        asynchronousStub.getAnimalsByDate(animalRequest, new StreamObserver<Animal>() {
            @Override
            public void onNext(Animal animal) {
                response.add(animal.getAllFields());
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }

        });
        return response;
    }


}
