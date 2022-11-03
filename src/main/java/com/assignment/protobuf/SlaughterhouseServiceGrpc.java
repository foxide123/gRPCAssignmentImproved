package com.assignment.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: shared.proto")
public final class SlaughterhouseServiceGrpc {

  private SlaughterhouseServiceGrpc() {}

  public static final String SERVICE_NAME = "com.assignment.protobuf.SlaughterhouseService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAllAnimalsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllAnimals",
      requestType = com.assignment.protobuf.Animal.class,
      responseType = com.assignment.protobuf.Animal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAllAnimalsMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal> getGetAllAnimalsMethod;
    if ((getGetAllAnimalsMethod = SlaughterhouseServiceGrpc.getGetAllAnimalsMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAllAnimalsMethod = SlaughterhouseServiceGrpc.getGetAllAnimalsMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAllAnimalsMethod = getGetAllAnimalsMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllAnimals"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getAllAnimals"))
              .build();
        }
      }
    }
    return getGetAllAnimalsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAnimalByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalById",
      requestType = com.assignment.protobuf.Animal.class,
      responseType = com.assignment.protobuf.Animal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAnimalByIdMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal> getGetAnimalByIdMethod;
    if ((getGetAnimalByIdMethod = SlaughterhouseServiceGrpc.getGetAnimalByIdMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalByIdMethod = SlaughterhouseServiceGrpc.getGetAnimalByIdMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalByIdMethod = getGetAnimalByIdMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getAnimalById"))
              .build();
        }
      }
    }
    return getGetAnimalByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAnimalsByDateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalsByDate",
      requestType = com.assignment.protobuf.Animal.class,
      responseType = com.assignment.protobuf.Animal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAnimalsByDateMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal> getGetAnimalsByDateMethod;
    if ((getGetAnimalsByDateMethod = SlaughterhouseServiceGrpc.getGetAnimalsByDateMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalsByDateMethod = SlaughterhouseServiceGrpc.getGetAnimalsByDateMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalsByDateMethod = getGetAnimalsByDateMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalsByDate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getAnimalsByDate"))
              .build();
        }
      }
    }
    return getGetAnimalsByDateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAnimalByOriginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalByOrigin",
      requestType = com.assignment.protobuf.Animal.class,
      responseType = com.assignment.protobuf.Animal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getGetAnimalByOriginMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal> getGetAnimalByOriginMethod;
    if ((getGetAnimalByOriginMethod = SlaughterhouseServiceGrpc.getGetAnimalByOriginMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalByOriginMethod = SlaughterhouseServiceGrpc.getGetAnimalByOriginMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalByOriginMethod = getGetAnimalByOriginMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalByOrigin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getAnimalByOrigin"))
              .build();
        }
      }
    }
    return getGetAnimalByOriginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.PartPack,
      com.assignment.protobuf.Animal> getGetAnimalsInvolvedInProductIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAnimalsInvolvedInProductId",
      requestType = com.assignment.protobuf.PartPack.class,
      responseType = com.assignment.protobuf.Animal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.PartPack,
      com.assignment.protobuf.Animal> getGetAnimalsInvolvedInProductIdMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.PartPack, com.assignment.protobuf.Animal> getGetAnimalsInvolvedInProductIdMethod;
    if ((getGetAnimalsInvolvedInProductIdMethod = SlaughterhouseServiceGrpc.getGetAnimalsInvolvedInProductIdMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetAnimalsInvolvedInProductIdMethod = SlaughterhouseServiceGrpc.getGetAnimalsInvolvedInProductIdMethod) == null) {
          SlaughterhouseServiceGrpc.getGetAnimalsInvolvedInProductIdMethod = getGetAnimalsInvolvedInProductIdMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.PartPack, com.assignment.protobuf.Animal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAnimalsInvolvedInProductId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.PartPack.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getAnimalsInvolvedInProductId"))
              .build();
        }
      }
    }
    return getGetAnimalsInvolvedInProductIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.PartPack> getGetProductsFromAnimalIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getProductsFromAnimalId",
      requestType = com.assignment.protobuf.Animal.class,
      responseType = com.assignment.protobuf.PartPack.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.PartPack> getGetProductsFromAnimalIdMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.Animal, com.assignment.protobuf.PartPack> getGetProductsFromAnimalIdMethod;
    if ((getGetProductsFromAnimalIdMethod = SlaughterhouseServiceGrpc.getGetProductsFromAnimalIdMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getGetProductsFromAnimalIdMethod = SlaughterhouseServiceGrpc.getGetProductsFromAnimalIdMethod) == null) {
          SlaughterhouseServiceGrpc.getGetProductsFromAnimalIdMethod = getGetProductsFromAnimalIdMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.Animal, com.assignment.protobuf.PartPack>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getProductsFromAnimalId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.PartPack.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("getProductsFromAnimalId"))
              .build();
        }
      }
    }
    return getGetProductsFromAnimalIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getUpdateAnimalMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateAnimal",
      requestType = com.assignment.protobuf.Animal.class,
      responseType = com.assignment.protobuf.Animal.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.assignment.protobuf.Animal,
      com.assignment.protobuf.Animal> getUpdateAnimalMethod() {
    io.grpc.MethodDescriptor<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal> getUpdateAnimalMethod;
    if ((getUpdateAnimalMethod = SlaughterhouseServiceGrpc.getUpdateAnimalMethod) == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        if ((getUpdateAnimalMethod = SlaughterhouseServiceGrpc.getUpdateAnimalMethod) == null) {
          SlaughterhouseServiceGrpc.getUpdateAnimalMethod = getUpdateAnimalMethod =
              io.grpc.MethodDescriptor.<com.assignment.protobuf.Animal, com.assignment.protobuf.Animal>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateAnimal"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.assignment.protobuf.Animal.getDefaultInstance()))
              .setSchemaDescriptor(new SlaughterhouseServiceMethodDescriptorSupplier("updateAnimal"))
              .build();
        }
      }
    }
    return getUpdateAnimalMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SlaughterhouseServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceStub>() {
        @java.lang.Override
        public SlaughterhouseServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SlaughterhouseServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceBlockingStub>() {
        @java.lang.Override
        public SlaughterhouseServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceBlockingStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SlaughterhouseServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SlaughterhouseServiceFutureStub>() {
        @java.lang.Override
        public SlaughterhouseServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SlaughterhouseServiceFutureStub(channel, callOptions);
        }
      };
    return SlaughterhouseServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SlaughterhouseServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getAllAnimals(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllAnimalsMethod(), responseObserver);
    }

    /**
     */
    public void getAnimalById(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalByIdMethod(), responseObserver);
    }

    /**
     */
    public void getAnimalsByDate(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalsByDateMethod(), responseObserver);
    }

    /**
     */
    public void getAnimalByOrigin(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalByOriginMethod(), responseObserver);
    }

    /**
     */
    public void getAnimalsInvolvedInProductId(com.assignment.protobuf.PartPack request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAnimalsInvolvedInProductIdMethod(), responseObserver);
    }

    /**
     */
    public void getProductsFromAnimalId(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.PartPack> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetProductsFromAnimalIdMethod(), responseObserver);
    }

    /**
     * <pre>
     *rpc getAllAnimals(google.protobuf.Empty) returns(stream Animal){}
     *rpc createAnimal(Animal) returns(google.protobuf.Empty){}
     * </pre>
     */
    public void updateAnimal(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateAnimalMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetAllAnimalsMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.assignment.protobuf.Animal,
                com.assignment.protobuf.Animal>(
                  this, METHODID_GET_ALL_ANIMALS)))
          .addMethod(
            getGetAnimalByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.assignment.protobuf.Animal,
                com.assignment.protobuf.Animal>(
                  this, METHODID_GET_ANIMAL_BY_ID)))
          .addMethod(
            getGetAnimalsByDateMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.assignment.protobuf.Animal,
                com.assignment.protobuf.Animal>(
                  this, METHODID_GET_ANIMALS_BY_DATE)))
          .addMethod(
            getGetAnimalByOriginMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.assignment.protobuf.Animal,
                com.assignment.protobuf.Animal>(
                  this, METHODID_GET_ANIMAL_BY_ORIGIN)))
          .addMethod(
            getGetAnimalsInvolvedInProductIdMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.assignment.protobuf.PartPack,
                com.assignment.protobuf.Animal>(
                  this, METHODID_GET_ANIMALS_INVOLVED_IN_PRODUCT_ID)))
          .addMethod(
            getGetProductsFromAnimalIdMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                com.assignment.protobuf.Animal,
                com.assignment.protobuf.PartPack>(
                  this, METHODID_GET_PRODUCTS_FROM_ANIMAL_ID)))
          .addMethod(
            getUpdateAnimalMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                com.assignment.protobuf.Animal,
                com.assignment.protobuf.Animal>(
                  this, METHODID_UPDATE_ANIMAL)))
          .build();
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceStub extends io.grpc.stub.AbstractAsyncStub<SlaughterhouseServiceStub> {
    private SlaughterhouseServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceStub(channel, callOptions);
    }

    /**
     */
    public void getAllAnimals(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllAnimalsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnimalById(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnimalsByDate(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAnimalsByDateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnimalByOrigin(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAnimalByOriginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAnimalsInvolvedInProductId(com.assignment.protobuf.PartPack request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAnimalsInvolvedInProductIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getProductsFromAnimalId(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.PartPack> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetProductsFromAnimalIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     *rpc getAllAnimals(google.protobuf.Empty) returns(stream Animal){}
     *rpc createAnimal(Animal) returns(google.protobuf.Empty){}
     * </pre>
     */
    public void updateAnimal(com.assignment.protobuf.Animal request,
        io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateAnimalMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SlaughterhouseServiceBlockingStub> {
    private SlaughterhouseServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.assignment.protobuf.Animal> getAllAnimals(
        com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllAnimalsMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.assignment.protobuf.Animal getAnimalById(com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.assignment.protobuf.Animal> getAnimalsByDate(
        com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAnimalsByDateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.assignment.protobuf.Animal getAnimalByOrigin(com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAnimalByOriginMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.assignment.protobuf.Animal> getAnimalsInvolvedInProductId(
        com.assignment.protobuf.PartPack request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAnimalsInvolvedInProductIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.assignment.protobuf.PartPack> getProductsFromAnimalId(
        com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetProductsFromAnimalIdMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     *rpc getAllAnimals(google.protobuf.Empty) returns(stream Animal){}
     *rpc createAnimal(Animal) returns(google.protobuf.Empty){}
     * </pre>
     */
    public com.assignment.protobuf.Animal updateAnimal(com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateAnimalMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SlaughterhouseServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SlaughterhouseServiceFutureStub> {
    private SlaughterhouseServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SlaughterhouseServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SlaughterhouseServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.assignment.protobuf.Animal> getAnimalById(
        com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.assignment.protobuf.Animal> getAnimalByOrigin(
        com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAnimalByOriginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     *rpc getAllAnimals(google.protobuf.Empty) returns(stream Animal){}
     *rpc createAnimal(Animal) returns(google.protobuf.Empty){}
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.assignment.protobuf.Animal> updateAnimal(
        com.assignment.protobuf.Animal request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateAnimalMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_ALL_ANIMALS = 0;
  private static final int METHODID_GET_ANIMAL_BY_ID = 1;
  private static final int METHODID_GET_ANIMALS_BY_DATE = 2;
  private static final int METHODID_GET_ANIMAL_BY_ORIGIN = 3;
  private static final int METHODID_GET_ANIMALS_INVOLVED_IN_PRODUCT_ID = 4;
  private static final int METHODID_GET_PRODUCTS_FROM_ANIMAL_ID = 5;
  private static final int METHODID_UPDATE_ANIMAL = 6;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SlaughterhouseServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SlaughterhouseServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_ALL_ANIMALS:
          serviceImpl.getAllAnimals((com.assignment.protobuf.Animal) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal>) responseObserver);
          break;
        case METHODID_GET_ANIMAL_BY_ID:
          serviceImpl.getAnimalById((com.assignment.protobuf.Animal) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal>) responseObserver);
          break;
        case METHODID_GET_ANIMALS_BY_DATE:
          serviceImpl.getAnimalsByDate((com.assignment.protobuf.Animal) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal>) responseObserver);
          break;
        case METHODID_GET_ANIMAL_BY_ORIGIN:
          serviceImpl.getAnimalByOrigin((com.assignment.protobuf.Animal) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal>) responseObserver);
          break;
        case METHODID_GET_ANIMALS_INVOLVED_IN_PRODUCT_ID:
          serviceImpl.getAnimalsInvolvedInProductId((com.assignment.protobuf.PartPack) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal>) responseObserver);
          break;
        case METHODID_GET_PRODUCTS_FROM_ANIMAL_ID:
          serviceImpl.getProductsFromAnimalId((com.assignment.protobuf.Animal) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.PartPack>) responseObserver);
          break;
        case METHODID_UPDATE_ANIMAL:
          serviceImpl.updateAnimal((com.assignment.protobuf.Animal) request,
              (io.grpc.stub.StreamObserver<com.assignment.protobuf.Animal>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SlaughterhouseServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.assignment.protobuf.Shared.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SlaughterhouseService");
    }
  }

  private static final class SlaughterhouseServiceFileDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier {
    SlaughterhouseServiceFileDescriptorSupplier() {}
  }

  private static final class SlaughterhouseServiceMethodDescriptorSupplier
      extends SlaughterhouseServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SlaughterhouseServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SlaughterhouseServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SlaughterhouseServiceFileDescriptorSupplier())
              .addMethod(getGetAllAnimalsMethod())
              .addMethod(getGetAnimalByIdMethod())
              .addMethod(getGetAnimalsByDateMethod())
              .addMethod(getGetAnimalByOriginMethod())
              .addMethod(getGetAnimalsInvolvedInProductIdMethod())
              .addMethod(getGetProductsFromAnimalIdMethod())
              .addMethod(getUpdateAnimalMethod())
              .build();
        }
      }
    }
    return result;
  }
}
