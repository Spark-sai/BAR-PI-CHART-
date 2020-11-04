package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.WhUserType;

public interface WhUserRepo  extends JpaRepository<WhUserType, String>
{
}
