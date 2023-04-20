package com.example.autoservice.service;

import com.example.autoservice.model.Owner;

public interface OwnerService {

    Owner save(Owner owner);

    Owner update(Owner owner, Long updatedOwnerId);

    Owner getById(Long ownerId);
}
