package com.pensionmanagement.pensioner.detail.service.repository;

import org.springframework.stereotype.Repository;
import com.pensionmanagement.pensioner.detail.service.entity.Pensioner;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PensionerRepository extends JpaRepository<Pensioner, String> {

	Pensioner findAllByAadharNo(String aadharNo);

}
