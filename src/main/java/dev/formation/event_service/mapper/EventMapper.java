package dev.formation.event_service.mapper;


import dev.formation.event_service.dto.EventDTO;
import dev.formation.event_service.entity.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDTO(Event event);
    Event toEntity(EventDTO eventDTO);
}
