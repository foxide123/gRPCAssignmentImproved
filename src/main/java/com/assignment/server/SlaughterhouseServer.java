package com.assignment.server;

import com.assignment.protobuf.Animal;
import com.assignment.protobuf.SlaughterhouseServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class SlaughterhouseServer extends SlaughterhouseServiceGrpc.SlaughterhouseServiceImplBase {
    @Override
    public void getAnimalById(Animal request, StreamObserver<Animal> responseObserver) {
        Animal animalFromDB = Database.getAnimalById(request.getRegNr());
        responseObserver.onNext(animalFromDB);
        responseObserver.onCompleted();
    }
}
