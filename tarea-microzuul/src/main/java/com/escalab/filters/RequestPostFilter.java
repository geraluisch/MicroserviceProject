package com.escalab.filters;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RequestPostFilter extends ZuulFilter {
	
	private static Logger LOGGER = LoggerFactory.getLogger(RequestPostFilter.class);
    private static final String FILTERTYPE = "post";
    private static final Integer FILTERORDER = 1;

    public RequestPostFilter(){ }
    
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		 RequestContext ctx = RequestContext.getCurrentContext();
	     HttpServletRequest request = ctx.getRequest();
	     
		 long startTime = (Long) ctx.get("startTime");

		 LOGGER.info("Request URL::" + request.getRequestURL().toString() +
				     ":: Tiempo transcurrido=" + (Instant.now().toEpochMilli() - startTime));
		return null;
	}

	@Override
	public String filterType() {
		return FILTERTYPE;
	}

	@Override
	public int filterOrder() {
		return FILTERORDER;
	} 

}
