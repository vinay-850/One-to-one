package com.nexential.springbootonetooneexam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexential.springbootonetooneexam.entity.People;

public interface PeopleRepository extends JpaRepository<People,Long> {

}
