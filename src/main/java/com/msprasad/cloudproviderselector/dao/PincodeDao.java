package com.msprasad.cloudproviderselector.dao;

import com.msprasad.cloudproviderselector.models.common.Pincode;

import java.util.Map;

public interface PincodeDao {
    void save(Pincode pincode);

    String find(String name);

    String findAllPincodes();

    void delete(String id);
}
