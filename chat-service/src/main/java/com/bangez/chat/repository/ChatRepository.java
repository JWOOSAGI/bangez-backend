package com.bangez.chat.repository;

import com.bangez.chat.domain.model.ChatModel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;


@Repository
public interface ChatRepository extends ReactiveMongoRepository<ChatModel,String> {
    Flux<ChatModel> findByChatRoomId(String chatRoomId);

    Flux<ChatModel> findByReceiverIdAndReadFalse(String senderId);

    Flux<ChatModel> findByChatRoomIdAndReceiverIdAndReadFalse(String roomId, String userId);


}
