package com.s.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s.entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer> {



}
