package com.prosayj.springbootstudy.datajpa.repository;

import com.prosayj.springbootstudy.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// 繼承JpaRepository來完成對數據庫的操作
public interface UserRepository extends JpaRepository<User, Integer> {
}
