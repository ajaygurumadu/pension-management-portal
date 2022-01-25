package com.pensionmanagement.processpension.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import com.pensionmanagement.processpension.entity.PensionDetail;

@Repository
public interface PensionDetailRepository extends JpaRepository<PensionDetail, String> {

	PensionDetail findAllByAadharNo(String aadharNo);

}
