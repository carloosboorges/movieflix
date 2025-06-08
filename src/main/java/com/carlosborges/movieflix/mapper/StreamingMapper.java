package com.carlosborges.movieflix.mapper;
import com.carlosborges.movieflix.controller.request.StreamingRequest;
import com.carlosborges.movieflix.controller.response.StreamingResponse;
import com.carlosborges.movieflix.entity.Streaming;

public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest){
        return Streaming
                .builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming){
        return StreamingResponse
                .builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
