package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.Field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldDao extends JpaRepository<Field, String> {
}
