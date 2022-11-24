package com.assignment.server;

import com.assignment.protobuf.*;
import com.assignment.server.dao.first_station.AnimalDao;
import com.assignment.server.dao.second_station.AnimalPartDao;
import com.assignment.server.dao.second_station.TrayDao;
import com.assignment.server.dao.third_station.PartPackDao;
import com.assignment.server.repositories.first_station.AnimalRepository;
import com.assignment.server.repositories.second_station.AnimalPartRepository;
import com.assignment.server.repositories.second_station.TrayRepository;
import com.assignment.server.repositories.third_station.PartPackRepository;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@GRpcService
@Transactional
public class SlaughterhouseServer extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    AnimalPartRepository animalPartRepository;
    @Autowired
    TrayRepository trayRepository;
    @Autowired
    PartPackRepository partPackRepository;
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

    @Override
    public void createAnimalPart(AnimalPart request, StreamObserver<AnimalPart> responseObserver)
    {
        AnimalPartDao animalPart = null;
        try {
            animalPart = new AnimalPartDao(
                    request.getRegNr(),
                    request.getType(),
                    animalRepository.findById(request.getAnimalRef()).orElseThrow(() -> new Exception("animal reference not found")),
                    request.getWeight()
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        animalPartRepository.save(animalPart);
    }

    @Override
    public void createTray(Tray request, StreamObserver<Tray> responseObserver)
    {
        List<AnimalPartDao> ids = new ArrayList<>();
        List<Long> requestList = request.getPartRefList();

        for(int i=0; i<requestList.size(); i++)
        {
            try {
                ids.add(animalPartRepository.findById(requestList.get(i)).orElseThrow(()->new Exception("")));
                System.out.println(ids.get(i).getRegNr());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        TrayDao tray = null;
        try {
            tray = new TrayDao(
                    request.getRegNr(),
                    request.getWeight(),
                    request.getPartType(),
                    ids

            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        trayRepository.save(tray);
    }

    @Override
    public void createPartPack(PartPack request, StreamObserver<PartPack> responseObserver) {
        List<TrayDao> ids = new ArrayList<>();
        List<Long> requestList = request.getTrayRefList();

        for(int i=0; i<requestList.size(); i++)
        {
            try {
                ids.add(trayRepository.findById(requestList.get(i)).orElseThrow(()->new Exception("")));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


        PartPackDao partPack = null;
        try {
            partPack = new PartPackDao(
                    request.getRegNr(),
                   ids
            );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        partPackRepository.save(partPack);
    }

    @Override
    public void getAnimalsInvolvedInProductId(RequestLongId request, StreamObserver<Animal> responseObserver) {
        partPackRepository.findById(request.getId()).get()
                .getTrayRef().forEach(
                        tray -> {
                            trayRepository.findById(tray.getRegNr()).get()
                                    .getPartRef().forEach(
                                            part-> {
                                                AnimalDao animalDao =  animalPartRepository.findById(part.getRegNr()).get().getAnimalRef();
                                                Animal animalProto = Animal.newBuilder()
                                                        .setRegNr(animalDao.getRegNr())
                                                        .setArriveDate(animalDao.getArriveDate())
                                                        .setWeight(animalDao.getWeight())
                                                        .setOrigin(animalDao.getOrigin()).build();
                                                responseObserver.onNext(animalProto);
                                            }
                                    );
                        }
                );
        responseObserver.onCompleted();
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
