package com.msprasad.cloudproviderselector.controller;

import com.microsoft.applicationinsights.TelemetryClient;
import com.msprasad.cloudproviderselector.models.common.Pincode;
import com.msprasad.cloudproviderselector.services.impl.PincodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/redis/pincode")
public class RedisController {

    @Autowired
    private PincodeService pincodeService;

    @Autowired
    TelemetryClient telemetryClient;

    @PostMapping
    public String saveNewPincode(@RequestBody Pincode pincode) {
        telemetryClient.trackEvent("save New Pin code...");
        pincodeService.save(pincode);
        return "Successfully added : " + pincode.getPincodeVal() + " pincode";

    }

    @Cacheable(key="#id", value="picondes", unless = "#result.id < 1200")
    @GetMapping(path = "/{id}")
    public String fetchStudent(@PathVariable("id") String id) {
        telemetryClient.trackEvent("get Pin code...");
        return pincodeService.find(id);
    }

    @CacheEvict(key="#id",value="picondes")
    @DeleteMapping(path = "/{id}")
    public String deleteOldPincode(@PathVariable("id") String id) {
        pincodeService.delete(id);
        return "Successfully removed #pincode with id : " + id;
    }

    /*@Cacheable(key="#id", value="students", unless = "#result.id < 1200")*/
    @GetMapping
    public String fetchAllPincodes() {
        return pincodeService.findAllPincodes();
    }

    //@CachePut - Update a Cache. Use it with PutMapping
	/*@CachePut(key="#id",cacheNames="pincode")
	@PutMapping(path = "{id}")
	public String updateOldPincode(@PathVariable("id") long id,@RequestBody Pincode pincode) {
		pincodeService.update(id,pincode);
		return "Successfully update #pincode with id : " + id;
	}
	*/

}
