package com.api.crud.repositories;

import com.api.crud.models.ResourceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IResourceRepository extends JpaRepository<ResourceModel, Long> {


}
