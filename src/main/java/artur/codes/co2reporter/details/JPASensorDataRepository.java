package artur.codes.co2reporter.details;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface JPASensorDataRepository extends JpaRepository<SensorDataMapper, Long> {

    @Query("Select sd from SensorDataMapper sd where  sd.country=?1 and sd.city=?2")
    List<SensorDataMapper> findBy(String country, String city);

}
