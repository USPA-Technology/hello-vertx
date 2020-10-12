package hello.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import hello.dao.CustomerDao;
import hello.model.Customer;

public class CustomerDataService {
	
	static CacheLoader<String, List<Customer>> cacheLoader = new CacheLoader<String, List<Customer>>() {
        @Override
        public List<Customer> load(String methodName) {
        	List<Customer> rs = new ArrayList<>();
        	if(methodName.equals("getSampleList")) {
        		rs.addAll(CustomerDao.getSampleList());
        	}
        	else if(methodName.equals("getSampleObject")) {
        		Customer customer = CustomerDao.getSampleObject();
        		if(customer != null) {
        			rs.add(customer);
        		}
        	}
            return rs;
        }
    };
    
    static LoadingCache<String, List<Customer>> cache = CacheBuilder.newBuilder()
    	      .expireAfterAccess(5,TimeUnit.SECONDS)
    	      .build(cacheLoader);

	public static List<Customer> getSampleList(){
		return cache.getUnchecked("getSampleList");
	}
	
	public static List<Customer> getSampleObject(){
		return cache.getUnchecked("getSampleObject");
	}
}
