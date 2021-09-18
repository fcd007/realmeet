package br.com.sw2you.realmeet.service;

import static java.util.Objects.requireNonNull;
import org.springframework.stereotype.Service;
import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.entity.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotException;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomDTO findById(Long id) {
        requireNonNull(id);
        Room room = roomRepository.findById(id).orElseThrow(RoomNotException::new);
        return new RoomDTO().name(room.getName()).id(room.getId()).seats(room.getSeats());
    }
}
