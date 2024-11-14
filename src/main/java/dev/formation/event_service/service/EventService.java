package dev.formation.event_service.service;


import dev.formation.event_service.dto.EventDTO;
import dev.formation.event_service.entity.Event;
import dev.formation.event_service.mapper.EventMapper;
import dev.formation.event_service.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;

    // Constructeur pour l'injection des dépendances
    public EventService(EventRepository eventRepository, EventMapper eventMapper) {
        this.eventRepository = eventRepository;
        this.eventMapper = eventMapper;
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<EventDTO> getEventById(Long id) {
        return eventRepository.findById(id)
                .map(eventMapper::toDTO);
    }

    public EventDTO createEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        Event savedEvent = eventRepository.save(event);
        return eventMapper.toDTO(savedEvent);
    }

    public EventDTO updateEvent(Long id, EventDTO eventDTO) {
        return eventRepository.findById(id)
                .map(existingEvent -> {
                    existingEvent.setTitle(eventDTO.getTitle());
                    existingEvent.setDescription(eventDTO.getDescription());
                    existingEvent.setStartDate(eventDTO.getStartDate());
                    existingEvent.setEndDate(eventDTO.getEndDate());
                    existingEvent.setLocation(eventDTO.getLocation());
                    Event updatedEvent = eventRepository.save(existingEvent);
                    return eventMapper.toDTO(updatedEvent);
                }).orElseThrow(() -> new RuntimeException("Event not found"));
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
