package com.carlosborges.movieflix.controller.request;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import org.aspectj.bridge.IMessage;

import java.time.LocalDate;
import java.util.List;

public record MovieRequest(@NotEmpty(message = "Titulo do filme é obrigatorio.") String title,
                           String description,

                           @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
                           LocalDate releaseDate,

                           double rating,
                           List<Long> categories,
                           List<Long> streams) {
}
