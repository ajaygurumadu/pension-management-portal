package com.cogent.authservice.feignInterface;

import com.cogent.authservice.responseDTO.PensionerResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

import static com.cogent.authservice.constants.MicroServiceConstants.*;

@FeignClient(name = "PROCESS-PENSION-MICROSERVICE")
@Service
@RequestMapping(value = BASE_API)
public interface PensionerInterface {

    @RequestMapping(value = PensionerMicroServiceConstants.FETCH_ADMIN_BY_AADHARNO)
    Optional<PensionerResponseDTO> fetchAdminByAadharNo(@PathVariable("aadharNo") String aadharNo);
}
