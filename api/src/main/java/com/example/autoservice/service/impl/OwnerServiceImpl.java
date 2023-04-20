package com.example.autoservice.service.impl;

import com.example.autoservice.model.Owner;
import com.example.autoservice.repository.OwnerRepository;
import com.example.autoservice.service.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OwnerServiceImpl implements OwnerService {
    private OwnerRepository ownerRepository;

    @Override
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @Override
    public Owner update(Owner owner, Long updatedOwnerId) {
        owner.setId(updatedOwnerId);
        return ownerRepository.save(owner);
    }

    @Override
    public Owner getById(Long ownerId) {
        return ownerRepository.findById(ownerId).orElseThrow();
    }
}
