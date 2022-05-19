package com.practice.code.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@RequestMapping(value = "/get-token", method = RequestMethod.POST)
	public String getToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		final String token = jwtTokenUtil.generateToken(authenticationRequest);
		return token;
	}

	@RequestMapping(value = "/check-token", method = RequestMethod.POST)
	public boolean checkToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		final boolean token = jwtTokenUtil.validateToken(authenticationRequest.getToken(), authenticationRequest);
		return token;
	}

}
