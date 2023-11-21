package com.example.openapi.Repository;

import com.example.openapi.Entity.BestUlsan;
import com.example.openapi.Entity.TourInfoBody;
import com.example.openapi.Entity.TourInfoHeader;
import com.example.openapi.Entity.Ulsan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UlsanRepository extends JpaRepository<Ulsan, Long> {
    @Query("SELECT new com.example.openapi.Entity.BestUlsan(u.id, u.base, u.travelName) FROM Ulsan u")
    List<BestUlsan> getBestUlsan();
    @Query("SELECT new com.example.openapi.Entity.TourInfoHeader(u.id, u.base, u.travelName, u.briefInfo) " +
            "FROM Ulsan u WHERE u.id = :id")
    List<TourInfoHeader> findTourInfoHeader(@Param("id") Long id);

    @Query("SELECT new com.example.openapi.Entity.TourInfoBody(u.id, u.overview, u.phoneNumber, u.address, u.dayOff, " +
            "u.admissionFee, u.homepage, u.operatingHours, u.parkingAvailability) FROM Ulsan u WHERE u.id = :id")
    List<TourInfoBody> findTourInfoBody(@Param("id") Long id);
}
