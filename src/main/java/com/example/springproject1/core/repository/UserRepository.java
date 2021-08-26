package com.example.springproject1.core.repository;

import com.example.springproject1.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//Ya no agregamos la anotacion de Repository, sino que nuestra interface va a extender de otra interface
//llamada Jparepository y la ventaja es que cualquier tipo de clase Repository vamos a poder crearla usando este mismo repositorio
//Ya no vamos a tener que agregar los clasicos metodos de insertar, actualizar, etc
public interface UserRepository extends JpaRepository<User,Long> {

}
