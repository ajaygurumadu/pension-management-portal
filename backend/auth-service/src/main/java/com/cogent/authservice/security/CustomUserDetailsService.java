package com.cogent.authservice.security;

import com.cogent.authservice.responseDTO.PensionerResponseDTO;
import com.cogent.authservice.feignInterface.PensionerInterface;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private PensionerInterface pensionerInterface;

    public CustomUserDetailsService(PensionerInterface pensionerInterface) {
        this.pensionerInterface = pensionerInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String aadharNo) throws UsernameNotFoundException {
        PensionerResponseDTO pensionerResponseDTO = pensionerInterface.fetchAdminByAadharNo(aadharNo)
                .orElseThrow(() -> new UsernameNotFoundException("Username:" + aadharNo + " not found"));

        List<GrantedAuthority> grantedAuthorities = null;

        return new User(String.join("-", aadharNo, pensionerResponseDTO.getAadharNo()),
        		pensionerResponseDTO.getPassword(), true, true, true,
                true, grantedAuthorities);
    }
}
