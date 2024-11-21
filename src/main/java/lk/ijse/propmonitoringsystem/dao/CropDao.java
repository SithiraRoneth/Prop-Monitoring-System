package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDao extends JpaRepository<Crop,String> {
//    @Query("SELECT c.cropCode FROM Crop c ORDER BY c.cropCode DESC")
//    String findLastCropCode();
}
