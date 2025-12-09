package org.example.uberreviewservice.Repositories;

import org.example.uberreviewservice.Models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface driverRepository extends JpaRepository<Driver, Integer> {

    Optional<Driver> findDriverByIdAndLicenseNo(Integer driverId, String licenseNo);

    @Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id = :driverId AND license_no = :licenseNo")
    Optional<Driver> RawfindByIdAndLicenseNo(Integer driverId, String licenseNo);

    @Query("From Driver as d where d.id = :driverId AND d.LicenseNo = :licenseNo")
    Optional<Driver> hqlfindByIdAndLicenseNo(Integer driverId, String licenseNo);

}
