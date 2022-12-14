package com.assignment.client;

import com.assignment.client.dto.first_station.AnimalDto;
import com.assignment.client.dto.second_station.AnimalPartDto;
import com.assignment.client.dto.second_station.TrayDto;
import com.assignment.client.dto.third_station.PartPackDto;
import com.assignment.protobuf.*;
import com.google.protobuf.Descriptors;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

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



    public Map<Descriptors.FieldDescriptor, Object> createAnimal(AnimalDto animal){
        Animal animalProto = Animal.newBuilder()
                .setRegNr(animal.getRegNr())
                .setArriveDate(animal.getArriveDate())
                .setWeight(animal.getWeight())
                .setOrigin(animal.getOrigin())

                .build();
        Animal animalProtoResponse = synchronousStub.createAnimal(animalProto);
        return animalProtoResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> createAnimalPart(AnimalPartDto animalPart){
        AnimalPart animalPartProto = AnimalPart.newBuilder()
                .setRegNr(animalPart.getRegNr())
                .setType(animalPart.getType())
                .setAnimalRef(animalPart.getAnimalRef())
                .setWeight(animalPart.getWeight())

                .build();
        AnimalPart animalPartProtoResponse = synchronousStub.createAnimalPart(animalPartProto);
        return animalPartProtoResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> createTray(TrayDto tray){
        Tray trayProto = Tray.newBuilder()
                .setRegNr(tray.getRegNr())
                .setWeight(tray.getWeight())
                .setPartType(tray.getPartType())
                .addAllPartRef(tray.getPartRef())

                .build();
        Tray trayResponse = synchronousStub.createTray(trayProto);
        return trayResponse.getAllFields();
    }

    public Map<Descriptors.FieldDescriptor, Object> createPartPack(PartPackDto pack){
        PartPack partPackProto = PartPack.newBuilder()
                .setRegNr(pack.getRegNr())
                .addAllTrayRef(pack.getTrayRef())

                .build();
        PartPack partPackResponse = synchronousStub.createPartPack(partPackProto);
        return partPackResponse.getAllFields();
    }


    public List<AnimalDto> getAnimalsInvolvedInProductId(Long id){
        RequestLongId requestId = RequestLongId.newBuilder()
                .setId(id).build();

        final List<AnimalDto> response = new ArrayList<>();

        asynchronousStub.getAnimalsInvolvedInProductId(requestId, new StreamObserver<Animal>() {
            @Override
            public void onNext(Animal animal) {
                AnimalDto animalDto = new AnimalDto(
                        animal.getRegNr(),
                        animal.getArriveDate(),
                        animal.getWeight(),
                        animal.getOrigin()
                );
                response.add(animalDto);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        List<AnimalDto> distinctAnimals = response
                .stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctAnimals;
    }

/*
    public List<PartPackDto> getProductsFromAnimalId(Long id)
    {

        final List<PartPackDto> response = new ArrayList<>();

        asynchronousStub.getProductsFromAnimalId(RequestLongId.newBuilder().setId(id).build(), new StreamObserver<PartPack>() {
            @Override
            public void onNext(PartPack partPack) {
                PartPackDto partPackDto = new PartPackDto(
                        partPack.getRegNr(),
                        partPack.getTrayRefList()
                );

                response.add(partPackDto);
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        return response;
    }



 */










/*


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

    public List<Map<Descriptors.FieldDescriptor, Object>> getAnimalsInvolvedInProductId(long id)
    {
        PartPack partPackRequest = PartPack.newBuilder().setPackRegNr(id).build();
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();

        asynchronousStub.getAnimalsInvolvedInProductId(partPackRequest, new StreamObserver<Animal>() {
            @Override
            public void onNext(Animal animal) {
                response.add(animal.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onCompleted() {

            }
        });
        return null;
    }

    public List<Map<Descriptors.FieldDescriptor, Object>> getProductsFromAnimalId(long id)
    {
        Animal animalRequest = Animal.newBuilder().setRegNr(id).build();
        final List<Map<Descriptors.FieldDescriptor, Object>> response = new ArrayList<>();

        asynchronousStub.getProductsFromAnimalId(animalRequest, new StreamObserver<PartPack>() {
            @Override
            public void onNext(PartPack partPack) {
                response.add(partPack.getAllFields());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {

            }
        });
        return null;
    }


    public Map<Descriptors.FieldDescriptor, Object> updateAnimal(AnimalDao animalDao)
    {
        Animal animalRequest = Animal.newBuilder()
                .setRegNr(animalDao.getRegNr())
                .setArriveDate(animalDao.getArriveDate())
                .setOrigin(animalDao.getOrigin())
                .setWeight(animalDao.getWeight()).build();
        Animal animalResponse = synchronousStub.updateAnimal(animalRequest);
        return animalResponse.getAllFields();
    }

 */
}
