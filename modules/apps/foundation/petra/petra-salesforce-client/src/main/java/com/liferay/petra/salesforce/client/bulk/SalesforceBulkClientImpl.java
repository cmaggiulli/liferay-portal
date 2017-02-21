/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.petra.salesforce.client.bulk;

import com.liferay.petra.salesforce.client.BaseSalesforceClientImpl;

import com.sforce.async.AsyncApiException;
import com.sforce.async.AsyncExceptionCode;
import com.sforce.async.BatchInfo;
import com.sforce.async.BulkConnection;
import com.sforce.async.JobInfo;
import com.sforce.async.QueryResultList;
import com.sforce.soap.partner.PartnerConnection;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

import java.io.InputStream;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Brian Wing Shun Chan
 * @author Peter Shin
 */
public class SalesforceBulkClientImpl
	extends BaseSalesforceClientImpl implements SalesforceBulkClient {

	@Override
	public JobInfo abortJob(String jobInfoId, int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.abortJob(jobInfoId);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod("abortJob", String.class);
		Object[] arguments = {jobInfoId};

		return (JobInfo)invoke(method, arguments, retryCount);
	}

	@Override
	public JobInfo closeJob(String jobInfoId, int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.closeJob(jobInfoId);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod("closeJob", String.class);
		Object[] arguments = {jobInfoId};

		return (JobInfo)invoke(method, arguments, retryCount);
	}

	@Override
	public BatchInfo createBatchFromStream(
			JobInfo jobInfo, InputStream inputStream, int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.createBatchFromStream(jobInfo, inputStream);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod(
			"createBatchFromStream", JobInfo.class, InputStream.class);
		Object[] arguments = {jobInfo, inputStream};

		return (BatchInfo)invoke(method, arguments, retryCount);
	}

	@Override
	public JobInfo createJob(JobInfo jobInfo, int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.createJob(jobInfo);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod("createJob", JobInfo.class);
		Object[] arguments = {jobInfo};

		return (JobInfo)invoke(method, arguments, retryCount);
	}

	@Override
	public BatchInfo getBatchInfo(
			String jobInfoId, String batchInfoId, int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.getBatchInfo(jobInfoId, batchInfoId);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod("getBatchInfo", String.class, String.class);
		Object[] arguments = {jobInfoId, batchInfoId};

		return (BatchInfo)invoke(method, arguments, retryCount);
	}

	@Override
	public QueryResultList getQueryResultList(
			String jobInfoId, String batchInfoId, int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.getQueryResultList(jobInfoId, batchInfoId);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod(
			"getQueryResultList", String.class, String.class);
		Object[] arguments = {jobInfoId, batchInfoId};

		return (QueryResultList)invoke(method, arguments, retryCount);
	}

	@Override
	public InputStream getQueryResultStream(
			String jobInfoId, String batchInfoId, String queryResultId,
			int retryCount)
		throws AsyncApiException, ConnectionException {

		try {
			BulkConnection bulkConnection = getBulkConnection();

			return bulkConnection.getQueryResultStream(
				jobInfoId, batchInfoId, queryResultId);
		}
		catch (AsyncApiException aae) {
			if (retryCount <= 0) {
				throw aae;
			}
		}

		Method method = getMethod(
			"getQueryResultStream", String.class, String.class, String.class);
		Object[] arguments = {jobInfoId, batchInfoId, queryResultId};

		return (InputStream)invoke(method, arguments, retryCount);
	}

	protected BulkConnection getBulkConnection()
		throws AsyncApiException, ConnectionException {

		if (_bulkConnection != null) {
			return _bulkConnection;
		}

		PartnerConnection partnerConnection = getPartnerConnection();

		ConnectorConfig connectorConfig = partnerConnection.getConfig();

		connectorConfig.setCompression(true);

		StringBuilder sb = new StringBuilder();

		String serviceEndpoint = connectorConfig.getServiceEndpoint();

		sb.append(
			serviceEndpoint.substring(0, serviceEndpoint.indexOf("/Soap/")));

		sb.append("/async/");

		String authEndpoint = connectorConfig.getAuthEndpoint();

		sb.append(authEndpoint.substring(authEndpoint.lastIndexOf("/") + 1));

		connectorConfig.setRestEndpoint(sb.toString());

		connectorConfig.setSessionId(connectorConfig.getSessionId());

		_bulkConnection = new BulkConnection(connectorConfig);

		return _bulkConnection;
	}

	protected Method getMethod(String methodName, Class<?>... parameterTypes)
		throws AsyncApiException, ConnectionException {

		BulkConnection bulkConnection = getBulkConnection();

		Class<?> declaringClass = bulkConnection.getClass();

		MethodKey methodKey = new MethodKey(
			declaringClass, methodName, parameterTypes);

		Method method = _methods.get(methodKey);

		if (method != null) {
			return method;
		}

		try {
			method = declaringClass.getMethod(methodName, parameterTypes);
		}
		catch (NoSuchMethodException nsme) {
			throw new AsyncApiException(
				"Unable to find method", AsyncExceptionCode.Unknown, nsme);
		}

		_methods.put(methodKey, method);

		return method;
	}

	protected Object invoke(Method method, Object[] arguments, int retryCount)
		throws AsyncApiException, ConnectionException {

		for (int i = 0; i < retryCount; i++) {
			if (_logger.isInfoEnabled()) {
				_logger.info(
					"Retrying: " + method.getName() + " (" + (i + 1) + ")");
			}

			try {
				return method.invoke(getBulkConnection(), arguments);
			}
			catch (InvocationTargetException ite) {
				if ((i + 1) >= retryCount) {
					Throwable throwable = ite.getCause();

					if (throwable instanceof AsyncApiException) {
						throw (AsyncApiException)throwable;
					}
					else if (throwable instanceof ConnectionException) {
						throw (ConnectionException)throwable;
					}

					throw new AsyncApiException(
						"Unable to invoke method", AsyncExceptionCode.Unknown,
						throwable);
				}
			}
			catch (Exception e) {
				throw new AsyncApiException(
					"Unable to invoke method", AsyncExceptionCode.Unknown, e);
			}
		}

		return null;
	}

	private static final Logger _logger = LoggerFactory.getLogger(
		SalesforceBulkClientImpl.class);

	private BulkConnection _bulkConnection;
	private final Map<MethodKey, Method> _methods = new ConcurrentHashMap<>();

	private class MethodKey {

		public MethodKey(
			Class<?> declaringClass, String methodName,
			Class<?>... parameterTypes) {

			_declaringClass = declaringClass;
			_methodName = methodName;
			_parameterTypes = parameterTypes;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (!(obj instanceof MethodKey)) {
				return false;
			}

			MethodKey methodKey = (MethodKey)obj;

			if ((_declaringClass == methodKey._declaringClass) &&
				_methodName.equals(methodKey._methodName) &&
				Arrays.equals(_parameterTypes, methodKey._parameterTypes)) {

				return true;
			}

			return false;
		}

		private Class<?> _declaringClass;
		private final String _methodName;
		private final Class<?>[] _parameterTypes;

	}

}