package furama.furama.repository.service_resort;

import furama.furama.model.serviceResort.ServiceResort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IServiceResortRepository extends JpaRepository<ServiceResort,Integer> {


//    select service_resort.service_resort_id,service_resort.code_service_resort,service_resort.description_other_convenience,service_resort.number_of_floors,service_resort.number_of_people,service_resort.pool_area,service_resort.standard_room,service_resort.usable_area
//,service_resort.rent_type_rent_type_id,service_resort.service_type_service_type_id
//    from service_resort
//    join service_type on service_resort.service_type_service_type_id = service_type.service_type_id
//    where service_type.service_type_name like 'V%';

    @Query(value = "select service_resort.service_resort_id,service_resort.code_service_resort,service_resort.description_other_convenience,service_resort.number_of_floors,service_resort.number_of_people,service_resort.pool_area,service_resort.standard_room,service_resort.usable_area\n" +
            ",service_resort.rent_type_rent_type_id,service_resort.service_type_service_type_id\n" +
            "    from service_resort\n" +
            "    join service_type on service_resort.service_type_service_type_id = service_type.service_type_id\n" +
            "    where service_type.service_type_name like :name",nativeQuery = true)
    List<ServiceResort> findByName(@Param("name") String name);

    @Query(value = "select service_resort.service_resort_id,service_resort.code_service_resort,service_resort.description_other_convenience,service_resort.number_of_floors,service_resort.number_of_people,service_resort.pool_area,service_resort.standard_room,service_resort.usable_area\n" +
            ",service_resort.rent_type_rent_type_id,service_resort.service_type_service_type_id\n" +
            "    from service_resort\n" +
            "    join service_type on service_resort.service_type_service_type_id = service_type.service_type_id\n" +
            "    where service_type.service_type_name like :name",nativeQuery = true)
    Page<ServiceResort> findByNamePage(@Param("name")String nameNew, Pageable pageable);
}
