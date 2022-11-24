package com.iav.tcc.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iav.tcc.entity.IpAddress;
import com.iav.tcc.repository.IpAddressRepository;

@Service
public class IpAddressService {
	
    private static final String IPV4_REGEX =
            "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." +
            "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final Pattern IPv4_PATTERN = Pattern.compile(IPV4_REGEX);
	
	@Autowired
	private IpAddressRepository ipAddressRepository;
	
	public IpAddress add(IpAddress ip) throws Exception {
		IpAddress ipAddressObj = null;
		if(!isValidInet4Address(ip.getIpAddress())) {
			throw new Exception("Invalid Ip");
		}
		boolean isFound = false;
		Iterable<IpAddress> ipAddressItr = ipAddressRepository.findAll();
		for(IpAddress obj : ipAddressItr) {
			if(obj.getIpAddress().equals(ip.getIpAddress())) {
				ipAddressObj = obj;
				isFound = true;
				break;
			}
		}
		if(!isFound) {ipAddressObj = ipAddressRepository.save(ip);}
		return ipAddressObj;
	}
	
	public Iterable<IpAddress> getIp(){
		return ipAddressRepository.findAll();
	}
	
	public List<String> getAllIpByIntegers(List<Integer> ids){
		List<String> ips = new ArrayList<>();
		for(IpAddress obj : ipAddressRepository.findAllById(ids)) {
			ips.add(obj.getIpAddress());
		}
		return ips;
	}
	
	public List<String> getAllIp(){
		List<String> ips = new ArrayList<>();
		Iterable<IpAddress> ipItr = ipAddressRepository.findAll();
		for(IpAddress obj : ipItr) {
			ips.add(obj.getIpAddress());
		}
		return ips;
	}
	
	public int getIdByIp(String ip) {
		int id = -1;
		if(!isValidInet4Address(ip)) {return id;}
		Iterable<IpAddress> ipItr = ipAddressRepository.findAll();
		for(IpAddress obj:ipItr) {
			if(obj.getIpAddress().equals(ip)) {
				id = obj.getIpAddressId();
				break;
			}
		}
		return id;
	}
	
	private boolean isValidInet4Address(String ip)
    {
        if (ip == null) {
            return false;
        }
        Matcher matcher = IPv4_PATTERN.matcher(ip);
        return matcher.matches();
    }
}
