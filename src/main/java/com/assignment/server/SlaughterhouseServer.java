package com.assignment.server;

import com.assignment.model.AnimalModel;
import com.assignment.protobuf.Animal;
import com.assignment.protobuf.PartPack;
import com.assignment.protobuf.SlaughterhouseServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;


@GrpcService
public class SlaughterhouseServer extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {


    @Override
    public void getAllAnimals(Animal request, StreamObserver<Animal> responseObserver)
    {
        Database.getAllAnimals()
                .stream()
                .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getAnimalById(Animal request, StreamObserver<Animal> responseObserver) {
        //AnimalModel animalFromDB = Database.getAnimalById(request.getRegNr());
       // Animal animal = setAnimal(animalFromDB);
        Animal animal = Database.getAnimalById(request.getRegNr());
        responseObserver.onNext(animal);
        responseObserver.onCompleted();
    }

    @Override
    public void getAnimalsByDate(Animal request, StreamObserver<Animal> responseObserver) {
        Database.getAllAnimals()
                .stream()
                .filter(animal->animal.getArriveDate().equals(request.getArriveDate()))
                //onNext will send an object to client in real time
                //will not wait for forEach to be completed
                .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    @Override
    public void getAnimalsInvolvedInProductId(PartPack partPackRequest, StreamObserver<Animal> responseObserver)
    {
        //first loop through array of tray references
        for(Long trayId : partPackRequest.getTrayRefList())
        {
            Database.getAllAnimals()
                    .stream()
                    .filter(animal ->
                            animal.getRegNr() ==
                                    Database.getPartById(
                                            Database.getTrayById(trayId).getPartRef()).getAnimalRef()

                        )
                    .forEach(responseObserver::onNext);
            responseObserver.onCompleted();
        }
    }

    public void getProductsFromAnimalId(Animal animalRequest, StreamObserver<PartPack> responseObserver)
    {
        List<PartPack> products = Database.getAllProducts();

        for(PartPack product: products)
        {
            //loop through array of tray references
            for(int i=0; i<product.getTrayRefList().size(); i++)
            {
                boolean b = Database.getPartById(
                        Database.getTrayById(
                                product.getTrayRefList().get(0)).getPartRef()
                ).getAnimalRef() == animalRequest.getRegNr();
                if(b) responseObserver.onNext(product);
            }
        }


    }

    public void updateAnimal(Animal request, StreamObserver<Animal> responseObserver)
    {
        Animal animalFromDB = Database.updateAnimal(request);
        responseObserver.onNext(animalFromDB);
        responseObserver.onCompleted();
    }

    public Animal setAnimal(AnimalModel animalModel)
    {
        return Animal.newBuilder()
                .setRegNr(animalModel.getRegNr())
                .setArriveDate(animalModel.getArriveDate())
                .setWeight(animalModel.getWeight())
                .setOrigin(animalModel.getOrigin())
                .build();
    }
}
