package br.com.sw2you.realmeet.service;

import static java.util.Objects.requireNonNull;

import br.com.sw2you.realmeet.api.model.RoomDTO;
import br.com.sw2you.realmeet.domain.entity.Room;
import br.com.sw2you.realmeet.domain.entity.repository.RoomRepository;
import br.com.sw2you.realmeet.exception.RoomNotException;
import br.com.sw2you.realmeet.mapper.RoomMapper;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final RoomMapper roomMapper;

    public RoomService(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    public RoomDTO findById(Long id) {
        requireNonNull(id);
        Room room = roomRepository.findById(id).orElseThrow(RoomNotException::new);
        return roomMapper.fromEntityToDTO(room);
    }
}
