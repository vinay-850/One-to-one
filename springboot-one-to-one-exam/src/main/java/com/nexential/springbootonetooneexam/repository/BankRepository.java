package com.nexential.springbootonetooneexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexential.springbootonetooneexam.entity.Bank;

public interface BankRepository extends JpaRepository<Bank,Long>
{

}
