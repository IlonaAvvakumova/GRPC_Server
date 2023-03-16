package org.example;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GrretingService;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImp extends GreetingServiceGrpc.GreetingServiceImplBase{
    @Override
public void greeting(GrretingService.HelloRequest request, StreamObserver<GrretingService.HelloResponse> responseObserver){
//такая запись для возможности стриминга потоковых данных
        System.out.println(request);
//ответ клиенту
        GrretingService.HelloResponse response = GrretingService.HelloResponse.newBuilder()
                .setGreeting("Hello from server, " + request.getName()).build();
responseObserver.onNext(response);
responseObserver.onCompleted();
}
}
