package com.example.hobbyist.hobbyist.models;

import com.sun.tools.javac.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ProductRepository extends JpaRepository<Products, Long> {

       public ArrayList<Products> findByTitle(String title);

//       ArrayList<Products> findAll(String title);

//    Object findByTitle();
}

