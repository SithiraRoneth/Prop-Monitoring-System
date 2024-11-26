/* Created By Sithira Roneth
 * Date :11/21/24
 * Time :11:56
 * Project Name :Prop-Monitoring-System
 * */
package lk.ijse.propmonitoringsystem.dao;

import lk.ijse.propmonitoringsystem.entity.impl.EquipmentManage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldEquipmentDetailsDao extends JpaRepository<EquipmentManage,String> {
}
