package com.ncu.dao;

import com.ncu.bean1.Country;

public interface ICountryDao {

	Country selectCountryById(int cid);
}
