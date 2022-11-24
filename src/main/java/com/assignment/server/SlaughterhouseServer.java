package com.assignment.server;

import com.assignment.protobuf.Animal;
import com.assignment.protobuf.SlaughterhouseServiceGrpc;
import com.assignment.server.dao.first_station.AnimalDao;
import com.assignment.server.repositories.first_station.AnimalRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@GRpcService
public class SlaughterhouseServer extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {

    @Autowired
    AnimalRepository animalRepository;
    @Override
    public void createAnimal(Animal request, StreamObserver<Animal> responseObserver)
    {
        AnimalDao animal = new AnimalDao(
                request.getRegNr(),
                request.getArriveDate(),
                request.getWeight(),
                request.getOrigin()
        );

        animalRepository.save(animal);
    }




    /*

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

    public Animal setAnimal(AnimalDao animalDao)
    {
        return Animal.newBuilder()
                .setRegNr(animalDao.getRegNr())
                .setArriveDate(animalDao.getArriveDate())
                .setWeight(animalDao.getWeight())
                .setOrigin(animalDao.getOrigin())
                .build();
    }

     */
}
